import java.util.Hashtable;
import java.util.Enumeration;
import java.awt.*;
import java.awt.event.*;
class HashtableExample extends Frame 
{
	 
     TextField t1;  
     Button b;
     Label mean;
      
       Frame f= new Frame("Dictionary");  

	void meaning()
	{
		
    t1=new TextField();  
    t1.setBounds(50,100, 200,30);  
   	f.add(t1);
    t1.setEditable(true);
   	b=new Button("Click Here");  
    b.setBounds(50,150,80,30);  
    f.add(b);  
    mean= new Label() ;
    mean.setBounds(50,200,1000,30);
    f.add(mean);
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  

    b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {  
          

        } 
    });

	}

 
}
public class dictionary
 { 

	public static void main(String[] args)
 {
 
   
 	HashtableExample obj=new HashtableExample();
 	obj.meaning();
 
  
  }}