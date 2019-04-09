import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Ex10 implements ActionListener
{
TextArea area;  
Frame frame;
MenuBar menuBar;
Menu menu1, menu2; 
MenuItem mItem1, mItem2, mItem3, mItem4, mItem5, mItem6, mItem7;
FileDialog fg;
Label label1;
Ex10()
{
frame = new Frame("MY program");

menuBar= new 	MenuBar();

area=new TextArea();  
area.setBounds(20,100,20,100);  



menu1 = new Menu("File");
mItem1 = new MenuItem("Print");
mItem2 = new MenuItem("Open");
mItem3= new MenuItem("Save");
mItem4 = new MenuItem("Save as");


menu1.add(mItem1);
menu1.add(mItem2);
menu1.add(mItem3);
menu1.add(mItem4);

menu2 = new Menu("Save-as");



menu1.add(menu2);

menu1.add(mItem4);


menuBar.add(menu1);

mItem2.addActionListener(this);
mItem4.addActionListener(this);

label1 = new Label("", Label.CENTER);

frame.setMenuBar(menuBar);
frame.add(label1,BorderLayout.CENTER);
frame.add(area);
frame.setSize(370,270);
frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand().equals("Open"))
{

	
	fg = new FileDialog(frame, "Open a file");
	fg.setVisible(true);
	String file = fg.getDirectory()+ fg.getFile();
	
	BufferedReader br = null;
	FileReader fr = null;
	try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				area.setText(sCurrentLine);
			}
		} catch (IOException ez) {

			ez.printStackTrace();
		} 


}
            
		
	
	
}




public static void main(String... ar)
{
new Ex10();
}

}