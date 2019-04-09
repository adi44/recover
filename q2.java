


import java.io.*;
import java.util.Scanner;
class student
	
	{
		String name;
		void student(String name)
			{
				System.out.println("Name :"+name);
			}
		void student()
			{
				Scanner input= new Scanner(System.in);
				System.out.println("Enter the name");
				String name= input.next();
				System.out.println("Your Name is: " +name );
			}
	}

class q2
{
	public static void main(String[] args)
		{
			student obj1= new student();
			obj1.student("abcd");
			obj1.student();
		}
}