import java.awt.* ;  
import java.awt.event.*;  
import java.util.Hashtable;

import java.lang.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Collections;
import java.util.Map;
class Student
{
	String S_name, S_registeration,Email;
	long Phonenumber;
	void student(String S_name, String S_registeration, long Phonenumber,String Email)
	{
		this.S_name= S_name;
		this.S_registeration=S_registeration;
		this.Phonenumber=Phonenumber;
		this.Email=Email;
	}
}
public class Ex8 extends Frame{


	TextField tf1,tf2,tf3,tf4;
	Label label;
	Button b1;
	List l1,l2;
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox checkbox1,checkbox2,checkbox3,checkbox4;
		
	Ex8()
	{  
		label = new Label("Welcome to Student Registeration Portal");
		label.setBounds(50,50,500,20);
        tf1=new TextField("Enter the Name of the student");  
        tf1.setBounds(50,100,250,20);  
        tf2=new TextField("Enter the Student Registeration Number");  
        tf2.setBounds(50,150,250,20);  
        tf3=new TextField("Enter the Email");  
        tf3.setBounds(50,200,250,20);   
        tf4=new TextField("Enter the Phonenumber");  
        tf4.setBounds(50,250,250,20);
        b1=new Button("Register");
        b1.setBounds(350,600,250,20);
        l1=new List(30);
        l1.setBounds(500,100,500,50);
        l2=new List(30);
        l2.setBounds(500,200,250,50);
        
        checkbox1=new Checkbox("Semester 1",cbg,false);
        checkbox1.setBounds(350, 300,100,50);
        checkbox2=new Checkbox("Semester 2",cbg,false);
        checkbox2.setBounds(350,350,100,50);
        checkbox3=new Checkbox("Semester 3",cbg,false);
        checkbox3.setBounds(650, 300,100,50);
        checkbox4=new Checkbox("Semester 4",cbg,false);
        checkbox4.setBounds(650,350,100,50);
        Label Registeration =new Label();
        Registeration.setBounds(500, 400,500,50);

          checkbox1.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent e) {  
                l1.removeAll();                 
                l1.add("Introduction to computer Science and python") ;
                l1.add("Discrete MAthematics") ;
                l1.add("English") ;
                l1.add("Career Development Classes") ;
                l1.add("Chemistry") ;
                l1.add("Biology") ;
                l1.add("Economics");
                l2.removeAll();    
                l2.add("CSE235");
                l2.add("CSE234");
                l2.add("MAT121");
                l2.add("CDC101");
                l2.add("ENG101");
                l2.add("CSE236"); 
             }  
          });  
            checkbox2.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent e) {  
                l1.removeAll();             
                l1.add("Introduction to Electrical Engineering and Computer Science") ;
                l1.add("Economics and Ecommerce") ;
                l1.add("English") ;
                l1.add("Career Development Classes") ;
                l1.add("Single Variable Calculus") ;
                l1.add("Classical Mechanics") ;
                l1.add("Basic Electronics");
                l2.removeAll();    
                l2.add("CSE235");
                l2.add("CSE234");
                l2.add("MAT121");
                l2.add("CDC101");
                l2.add("ENG101");
                l2.add("CSE236");
             }  
          });  
              checkbox3.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent e) { 
                l1.removeAll();                  
                l1.add("Data Structures in C") ;
                l1.add("Environmental Studies") ;
                l1.add("Linear Algebra") ;
                l1.add("Career Development Classes") ;
                l1.add("Digital System Design") ;
                l1.add("Engineering Fundamentals") ;
                l1.add("Electricity and Magnetism");
                l2.removeAll();    
                l2.add("CSE235");
                l2.add("CSE234");
                l2.add("MAT121");
                l2.add("CDC101");
                l2.add("ENG101");
                l2.add("CSE236"); 
             }  
          });  
                checkbox4.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent e) { 
                l1.removeAll();                      
                l1.add("Object Oriented Programming") ;
                l1.add("Computer Organization and Architecture") ;
                l1.add("Multivariable calculus") ;
                l1.add("Career Development Classes") ;
                l1.add("Signals and Systems") ;
                l1.add("Algorithm Analysis and Design") ;
                l2.removeAll();    
                l2.add("CSE235");
                l2.add("CSE234");
                l2.add("MAT121");
                l2.add("CDC101");
                l2.add("ENG101");
                l2.add("CSE236");
             }  
          });  
            b1.addActionListener(new ActionListener() {  
             public void actionPerformed(ActionEvent e) { 
               
               Registeration.setText("You Have been Registered");
             }  
          });  




        

        



    
       

        add(label);add(tf1);add(tf2);add(tf3);add(tf4);add(b1);add(l1);add(l2);add(checkbox1);add(checkbox2);add(checkbox3);add(checkbox4);add(Registeration);
         
        setSize(1300,700);  
        setLayout(null);  
        setVisible(true);  
         }   
	public static void main(String[] args)
	{
		new Ex8();
	}
}