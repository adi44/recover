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

class teacher implements Serializable 

	{
		String Employee_ID, Name, Subject,SubjectII, Department;
		public teacher(String Employee_ID, String Name, String Subject, String Department)
			{
				
				this.Employee_ID=Employee_ID;
				this.Name= Name;
				this.Subject= Subject;
				this.Subject=SubjectII;
				this.Department = Department;

			}
	}

public class Ex6 extends Frame implements ActionListener{

	    TextField tf1,tf2,tf3,tf4,tf5,search; 
	    Label l1,l2,l3,l4; 

    	Button b1,b2;  
    Ex6(){  
        tf1=new TextField("Enter the Name of the faculty");  
        tf1.setBounds(50,50,250,20);  
        tf2=new TextField("Enter the Employee ID of the faculty");  
        tf2.setBounds(50,100,250,20);  
        tf3=new TextField("Enter the Subject of the Faculty ");  
        tf3.setBounds(50,150,250,20);   
        tf4=new TextField("Enter the Department of the faculty");  
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
        l3.setBounds(50,400,250,20);   
       	l4=new Label();  
        l4.setBounds(50,450,250,20);
        search=new TextField("Enter the Employee ID to be searched");  
        search.setBounds(500,200,250,20);
        b1.addActionListener(this); 
        b2.addActionListener(this);   
        add(tf1);add(tf2);add(tf3);add(tf4);add(l1);add(l2);add(l3);add(l4);add(b1);add(b2);add(search);
         
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
         }   


	 public void actionPerformed(ActionEvent e) 
	 {
	 	String Name= tf1.getText();
	 	String Department= tf3.getText();
	 	String Employee_id=tf2.getText();
	 	String Subject=tf4.getText();
	 	String key;
	 	String search1=search.getText().toString();
	 	Hashtable<String,teacher> h= new Hashtable<String, teacher>();
	 	if(e.getSource()==b1)
	 		{		
	 				teacher t1= new teacher(Employee_id,Name,Subject,Department);
	 				h.put(Employee_id,t1);

	 				
	 				  try {

            				FileOutputStream fileOut = new FileOutputStream("hello.ser");
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
  FileInputStream fileIn = new FileInputStream("hello.ser");
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
 		    	
 		    	  for(Map.Entry<String, teacher> entry:h.entrySet()){    
        key=entry.getKey();  
        l1.setText("Employee ID : "+obj.toString());
        teacher b=entry.getValue();  
        l2.setText("Name : "+b.Name);
        l3.setText("Subject : "+b.Subject);
        l4.setText("Department : "+b.Department);


 		    	
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
		new Ex6();
		

	}
}