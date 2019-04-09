import java.io.*;
import java.util.Scanner;
class Teacher extends Thread
{
	
				String name;
				int registeration_number;
				long phone_number;
				String department;


			
		synchronized void input_data()
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
			public void Run()
		{

			System.out.println("Thread is Running");

		}
	
}
class Student extends Thread
{
		public void Run()
		{
			System.out.println("Student class thread is running");

		}
		synchronized void method()
		{
			System.out.println("this is synchronized method for class Student");
		}
		
}
class Parents implements Runnable
{
	public void run()
	{
		System.out.println("Thread is running");
	}
	synchronized void method()
		{
			System.out.println("this is synchronized method for class parents");
		}
	
}
class Q2
{
	public static void main(String args[])
	{
		Teacher obj1=new Teacher();
		Student obj2=new Student();
		Parents obj3=new Parents();
		obj1.Run();
		obj2.Run();
		obj3.run();
		obj1.input_data();
		obj2.method();
		obj3.method();
	}
}
