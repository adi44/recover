import java.util.Hashtable;
import java.util.Enumeration;
import java.awt.*;
import java.awt.event.*;
class HashtableExample extends Frame implements ActionListener
{
	 Enumeration names;
     String key;
     TextField t1,t2;  
     Button b;
      Hashtable<String, String> hashtable = 
              new Hashtable<String, String>();
	void HashtableExample()
	{
		
 
   // Creating a Hashtable
		 // Adding Key and Value pairs to Hashtable
   hashtable.put("zenith","the point above the observer directly opposite the nadir");
   hashtable.put("zealot","a fervent and even militant proponent of something");
   hashtable.put("yearn","desire strongly or persistently");
   hashtable.put("yawner","a person who yawns");
   hashtable.put("xenophobia","a fear of foreigners or strangers");
  


    Frame f= new Frame("Dictionary");  
    
    t1=new TextField("Enter the Word");  
    t1.setBounds(50,100, 200,30);  
   	f.add(t1);
   	b=new Button("Click Here");  
    b.setBounds(50,150,80,30);  
    f.add(b);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  

	}

  public void actionPerformed(ActionEvent e) {  
  		
 
  
        String s1=t1.getText(); 
        Label mean= new Label("Meaning") ;
  
        if(e.getSource()==b)
        {
        	 names = hashtable.keys();
   			 while(names.hasMoreElements())
   			{
      			key = (String) names.nextElement();
      			if(s1==key)
      				mean.setText("Word :" +key+ " & Meaning :" +
      				hashtable.get(key));
   			}
        }
    } 
}
public class dictionary
 { 

	public static void main(String[] args)
 {
 
   
 	HashtableExample obj=new HashtableExample();
 	obj.HashtableExample();
 
  
  }}