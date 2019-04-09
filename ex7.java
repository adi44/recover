import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

class teacher{
  String name;
  String salary;
  String subject;
  public teacher(String name,String salary,String subject){
    this.name=name;
    this.salary=salary;
    this.subject=subject;
  }

  public void total_info(){
    System.out.println("Name: "+name);
    System.out.println("Salary: "+salary);
    System.out.println("Subject: "+subject);
  }
}

class student{
  String names;
  String rollno;
  String section;
  public student(String names,String rollno,String section){
    this.names=names;
    this.rollno=rollno;
    this.section=section;
  }

  public void total_info(){
    System.out.println("Name: "+names);
    System.out.println("Sallary: "+rollno);
    System.out.println("Subject: "+section);
  }
}

public class ex7 {
  public static void main(String args[]) throws IOException{
    Frame f=new Frame();
    Label l1=new(Label)
    TextField tf1=new TextField("roll number");
    tf1.setBounds(50,200,200,50);
    TextField tf2=new TextField("name");
    tf2.setBounds(50,300,200,50);
    TextField tf3=new TextField("subject");
    tf3.setBounds(50,400,200,50);

    Button b2=new Button("clear");
    b2.setBounds(300,400,50,50);
    Button b3=new Button("search");
    b3.setBounds(300,300,50,50);
    
    CheckboxGroup cgb=new CheckboxGroup();
    Checkbox ch1 = new Checkbox("Teacher",cgb,false);  
          ch1.setBounds(500,300, 100,50);  
          Checkbox ch2 = new Checkbox("Student",cgb,false);  
          ch2.setBounds(500,400, 100,50);  


    Scanner fr=new Scanner(new File("ex71output.txt")); 
  
             
    f.add(tf1);
    f.add(tf2);
    f.add(tf3);
    f.add(b2);
    f.add(b3);
    f.add(ch1);
    f.add(ch2);
    f.setSize(1200,1200);
    f.setLayout(null);
    f.setVisible(true);


    
    ch1.addItemListener(new ItemListener() {  
                public void itemStateChanged(ItemEvent e) {        
        try{         
                        
          FileWriter fstream = new FileWriter("ex71output.txt",true);
          BufferedWriter out = new BufferedWriter(fstream);
          PrintWriter outStream = new PrintWriter(out);
          out.write(tf1.getText());
          out.write("\t");
          out.write(tf2.getText());
          out.write("\t");
          out.write(tf3.getText());
          out.write("\r\n");    
          out.close();
                  }         
        catch(Exception d){System.out.println(d);} 
      } 
            });  
          ch2.addItemListener(new ItemListener() {  
              public void itemStateChanged(ItemEvent e) {                 
                    try{
        
          FileWriter fstream = new FileWriter("ex72output.txt",true);
          BufferedWriter out = new BufferedWriter(fstream);
          PrintWriter outStream = new PrintWriter(out); 
          out.write(tf1.getText());
          out.write("\t");
          out.write(tf2.getText());
          out.write("\t");
          out.write(tf3.getText());
          out.write("\r\n");    
          out.close();
                      
        }
        catch(Exception m){System.out.println(m);}
      }
          });  





        
    b2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e1){
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
      }
    });

    fr.close();   
  
    b3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e2){
        String word = ""; int val = 0;
      try{
       
           word = ",";
           Scanner file = new Scanner(new File("ex71output.txt"));

           while(file.hasNextLine())
           {
               String line = file.nextLine();
               if(line.indexOf(word) != -1)
               {
                   System.out.println("Word EXISTS in the file");
                   System.out.println(line);
                   val = 1;
                   break;
               }
           }
           if(val == 0)
           {
              System.out.println("Word does not exist");
           }
        }
    
     catch(Exception e){
       System.out.println(e);
     }
        
      }
    });
  }
}
