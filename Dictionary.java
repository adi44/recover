import java.util.Hashtable;
import java.util.Enumeration;
import java.awt.*;
public class HashtableExample 
{
 
 public static void main(String[] args)
 {
 
   Enumeration names;
   String key;
 
   // Creating a Hashtable
   Hashtable<String, String> hashtable = 
              new Hashtable<String, String>();
 
   // Adding Key and Value pairs to Hashtable
   hashtable.put("zenith","the point above the observer directly opposite the nadir");
   hashtable.put("zealot","a fervent and even militant proponent of something");
   hashtable.put("yearn","desire strongly or persistently");
   hashtable.put("yawner","a person who yawns");
   hashtable.put("xenophobia","a fear of foreigners or strangers");
   String word="yearn";

    Frame f= new Frame("Dictionary");  
    TextField t1,t2;  
    t1=new TextField("Enter the Word");  
    t1.setBounds(50,100, 200,30);  
   	f.add(t1);
   	Button b=new Button("Click Here");  
    b.setBounds(50,150,80,30);  
    f.add(b);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  

 
   names = hashtable.keys();
   while(names.hasMoreElements())
   {
     
   }
  }

}