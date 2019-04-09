import java.awt.* ;  
import java.awt.event.*;  
import java.util.Hashtable;
import java.util.*;
import java.lang.*;
import java.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Collections;
import java.util.Map;

class studenteng implements Serializable 

	{
		String Student_ID, Name, Email,SubjectII, Department;
		public studenteng(String Student_ID, String Name, String Email, String Department)
			{
				
				this.Student_ID=Student_ID;
				this.Name= Name;
				this.Email= Email;
				this.Department = Department;

			}
	}

public class StudentStore extends Frame implements ActionListener{

	    TextField tf1,tf2,tf3,tf4,tf5,search; 
	    Label l1,l2,l3,l4; 

    	Button b1,b2;  
    StudentStore(){  
        tf1=new TextField("Enter the Name of the Student");  
        tf1.setBounds(50,50,250,20);  
        tf2=new TextField("Enter the Roll Number of the Student");  
        tf2.setBounds(50,100,250,20);  
        tf3=new TextField("Enter the Email Address");  
        tf3.setBounds(50,150,250,20);   
        tf4=new TextField("Enter the Department of the Student");  
        tf4.setBounds(50,200,250,20);
        b1=new Button("Press to Save Data in File");  
        b1.setBounds(50,250,250,50);  
        b2=new Button("Press to Search");  
        b2.setBounds(500,250,250,50);  
        l1=new Label();  
        l1.setBounds(50,300,250,20);  
        l2=new Label();  
        l2.setBounds(50,350,250,20);  
        l3=new Label();  
        l3.setBounds(50,400,270,20);   
       	l4=new Label();  
        l4.setBounds(50,450,260,20);
        search=new TextField("Enter the Roll Number to be searched");  
        search.setBounds(500,200,250,20);
        b1.addActionListener(this); 
        b2.addActionListener(this);   
        add(tf1);add(tf2);add(tf3);add(tf4);add(l1);add(l2);add(l3);add(l4);add(b1);add(b2);add(search);
         
        setSize(1000,1);  
        setLayout(null);  
        setVisible(true);  
         }   


	 public void actionPerformed(ActionEvent e) 
	 {
	 	String Name= tf1.getText();
	 	String Department= tf3.getText();
	 	String Student_id=tf2.getText();
	 	String Email=tf4.getText();
	 	String key;
	 	String search1=search.getText().toString();
	 	Hashtable<String,studenteng> h= new Hashtable<String, studenteng>();
	 	if(e.getSource()==b1)
	 		{		
	 				studenteng stud= new studenteng(Student_id,Name,Email,Department);
	 				h.put(Student_id,stud);

	 				
	 				  try {

            				FileOutputStream fileOut = new FileOutputStream("student.ser");
            				ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(h);

	 						tf1.setText("");
        					tf2.setText("");
        					tf3.setText("");
        					tf4.setText("");

							
							out.close();
            				fileOut.close();

        				  } 
       				 catch(FileNotFoundException f) 
       				 	  {
           					 f.printStackTrace();
        				  } 
        			 catch (IOException f)
        			     {
            				f.printStackTrace();
        				 }

    		}
    	if(e.getSource()==b2)
{
	 try
	{
  System.out.println("Creating File/Object input stream...");
  FileInputStream fileIn = new FileInputStream("student.ser");
  ObjectInputStream in = new ObjectInputStream(fileIn);
  System.out.println("Loading Hashtable Object...");
  h = (Hashtable)in.readObject();
  System.out.println("Closing all input streams...\n");
  in.close();
  fileIn.close();
  }
  catch(ClassNotFoundException f){
  f.printStackTrace();
  }
  catch(FileNotFoundException f){
  f.printStackTrace();
  }
  catch(IOException f){
  f.printStackTrace();
  }
  System.out.println("Printing out loaded elements...");
  for(Enumeration names = h.keys(); names.hasMoreElements();)
  		{

  			Object obj = names.nextElement();
 		    if(obj.toString().equalsIgnoreCase(search.getText().toString()))
 		    {
 		    	
 		    	  for(Map.Entry<String, studenteng> entry:h.entrySet()){    
        key=entry.getKey();  
        l1.setText("Student ID: "+obj.toString());
        studenteng b=entry.getValue();  
        l2.setText("Student Name : "+b.Name);
        l3.setText("Email Address : "+b.Department);
        l4.setText("Department : "+b.Email);


 		    	
 		    }}
 		    else
 		    {
 		    	l1.setText("Not Found");
 		    	 l2.setText("");
        l3.setText("");
        l4.setText("");

 		    }
  

  
  		}
  

}



	 		

	 }

	public static void main(String[] args) throws Exception
	{
		new StudentStore();
		

	}
}