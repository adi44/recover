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


class Teacher implements Serializable 

	{
		String Employee_ID, Name, Subject,SubjectII, Department;
		public Teacher(String Employee_ID, String Name, String Subject,String SubjectII, String Department)
			{
				
				this.Employee_ID=Employee_ID;
				this.Name= Name;
				this.Subject= Subject;
        this.SubjectII=SubjectII;
				this.Department = Department;

			}
	}
class Student implements Serializable

  {
    String StudentID, Name, Branch, Batch;
    public Student(String StudentID, String Name, String Branch, String Batch)
    {
      this.StudentID=StudentID;
      this.Name= Name;
      this.Branch = Branch;
      this.Batch = Batch;
    }
  }
  public class Question7 extends Frame implements ActionListener,ItemListener{
	    TextField tf1,tf2,tf3,tf4,tf5,search; 
	    Label l1,l2,l3,l4; 
      Checkbox checkbox1= new Checkbox();
      Checkbox checkbox2= new Checkbox();


    	Button b1;  
    Question7(){  
        tf1=new TextField("Enter the Name of the faculty");  
        tf1.setBounds(50,50,250,20);  
        tf2=new TextField("Enter the Employee ID of the faculty");  
        tf2.setBounds(50,100,250,20);  
        tf3=new TextField("Enter the Subject of the Faculty ");  
        tf3.setBounds(50,150,250,20);   
        tf5=new TextField("Enter the Subject II of the Faculty ");  
        tf5.setBounds(50,200,250,20);   
        tf4=new TextField("Enter the Department of the faculty");  
        tf4.setBounds(50,250,250,20);
        b1=new Button("Press to Save Data in File");  
        b1.setBounds(50,300,250,50);  
        l1=new Label();  
        l1.setBounds(500,350,250,20);  
        l2=new Label();  
        l2.setBounds(500,400,250,20);  
        l3=new Label();  
        l3.setBounds(500,450,250,20);   
       	l4=new Label();  
        l4.setBounds(500,500,250,20);
        checkbox1= new Checkbox("Student");
        checkbox1.setBounds(500,200,250,50);
        checkbox2= new Checkbox("Teacher");
        checkbox2.setBounds(500,300,250,50);
        b1.addActionListener(this);
        checkbox1.addItemListener(this);    

        add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);add(l1);add(l2);add(l3);add(l4);add(b1);add(checkbox2);add(checkbox1);
         
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
    String SubjectII=tf5.getText();
	 	String key;
	 	String search1=search.getText().toString();
	 	Hashtable<String,Teacher> h= new Hashtable<String, Teacher>();
	 	if(e.getSource()==b1)
	 		{		
	 				Teacher t1= new Teacher(Employee_id,Name,Subject,SubjectII,Department);
	 				h.put(Employee_id,t1);

	 				
	 				  try {

            				FileOutputStream fileOut = new FileOutputStream("hello.ser");
            				ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(h);

	 						    tf1.setText("");
        					tf2.setText("");
        					tf3.setText("");
        					tf4.setText("");
                  tf5.setText("");

							
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




	 		

	 }
   public void itemStateChanged(ItemEvent ie)
   {
        
   }

	public static void main(String[] args) throws Exception
	{
		new Question7();
		

	}
}