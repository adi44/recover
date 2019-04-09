import java.io.*;
import java.util.Scanner;
abstract class shape
{
	void area_square()
	{

	}
	void area_triangle()
	{

	}
	void area_circle()
	{

	}
	void area_rectangle()
	{

	}
}

class area extends shape
{
	private int side;
	@Override 
	void area_square()
		{
				Scanner input= new Scanner(System.in);
				System.out.println("Enter the side");
				int side=input.nextInt();
				int area = side*side;
				System.out.println(+area);
		}
	void area_circle()
		{
				Scanner input= new Scanner(System.in);
				System.out.println("Enter the radius");
				int side=input.nextInt();
				double area = 3.14 * side * side;
				System.out.println(+area);
		}
				
	void area_triangle()
		{
			int height;
			int base;
			Scanner input= new Scanner(System.in);
			System.out.println("Enter the height");
			height= input.nextInt();
			System.out.println("Enter the base");
			base= input.nextInt();
			int area=1/2* base*height;
			System.out.println(+area);
		}
			void area_rectangle()
		{
			int height;
			int base;
			Scanner input= new Scanner(System.in);
			System.out.println("Enter the height");
			height= input.nextInt();
			System.out.println("Enter the base");
			base= input.nextInt();
			int area=base*height;
			System.out.println(+area);
		}

}


public class q1
{
	public static void main(String[] args)
	{
		area obj=new area();
		System.out.println("Enter your choice\n");
		System.out.println("1. Area of rectangle");
		System.out.println("2. Area of circle");
		System.out.println("3. Area of triangle");
		System.out.println("4. Area of square");
		


		Scanner input= new Scanner(System.in);
		int choice = input.nextInt();
		if(choice==2)
		{
			obj.area_circle();
		}
		if(choice==1)
		{
			obj.area_rectangle();
		}
		if(choice==3)
		{
			obj.area_triangle();
		}
		if(choice==4)
		{
			obj.area_square();
		}


	}
}