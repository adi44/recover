import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.serializable;
class faculty
	{
		void faculty()

			{

				String name;
				int registeration_number;
				long phone_number;
				String department;


			}
		void input_data()
			{
				Scanner input =new Scanner(System.in);

					{	
						System.out.println("Enter the name of the faculty\n");
						String name=input.next();
						System.out.println("Enter the registeration number\n");
						int registeration_number=input.nextInt();
						System.out.println("Enter the phone number of the faculty\n");
						String phone_number=input.next();
						 String phoneNumberPattern = "(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}";
						 boolean retval = true;
						 if(!retval)
						 {
						 	System.out.println("Enter the phone number of the faculty\n");
							phone_number=input.next();
						 }
						System.out.println("Enter the department of the faculty\n");
						String department= input.next();


					}

			}
	}
public class faculty_main
{
	public static void main(String args[])
	{}}