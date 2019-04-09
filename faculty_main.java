import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
 class faculty implements Serializable
	{
		

				String name;
				int registeration_number;
				long phone_number;
				String department;


			
		void input_data()
			{
				Scanner input =new Scanner(System.in);

					{	
						System.out.println("Enter the name of the faculty\n");
						name=input.next();
						System.out.println("Enter the registeration number\n");
						registeration_number=input.nextInt();
						System.out.println("Enter the phone number of the faculty\n");
						phone_number=input.nextInt();
						System.out.println("Enter the department of the faculty\n");
						 department= input.next();


					}

			}
		int display_data()
		{

			System.out.println("Name :" +name);
			System.out.println("registeration number: " +registeration_number);
			System.out.println("phone_number: "+phone_number);
			System.out.println("Department: " +department);
			return 0;
		}
	}
public class faculty_main
{
	public static void main(String args[]) throws IOException
	{
		faculty obj[]= new faculty[3];
		for(int i=0;i<3;i++)
			obj[i].input_data();


		FileInputStream in = null;
		FileOutputStream out = null;

		try
			{
				
				out= new FileOutputStream("output.ser");
				ObjectOutputStream fo =new ObjectOutputStream(out);
				for(int i=0;i<3;i++)
					fo.writeObject(obj[i]);
				
				System.out.println(" done ");

			}
		catch( IOException i)
			{
				i.printStackTrace();
			}
		try
			{
				in= new FileInputStream("output.ser");
				ObjectInputStream input = new ObjectInputStream(in);
				for(int i=0;i<3;i++)
					obj[i]=(faculty)input.readObject();

			}
		
		catch(ClassNotFoundException exception)
			{
				System.out.println("not found");
				exception.printStackTrace();
				return;
			}

		finally
			{
				if(out !=null)
				{
					out.close();
				}
			}
			System.out.println("Reading Data From File");
			for(int i=0;i<3;i++)
				obj[i].display_data();
	}
}