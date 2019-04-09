import java.util.*;
import java.io.*;
import java.lang.*;

class Student{
    String name;
    String dep;
    int ID;

    void Student(String name,String dep,int ID){
        this.name = name;
        this.dep = dep;
        this.ID = ID;
    }
}

class Teacher{
    String name;
    String sub;
    int ID;

    void Teacher(String name,String sub,int ID){
        this.name = name;
        this.sub = sub;
        this.ID = ID;
    }
}

public class Question3
{
    public static void main(String[] args)
    {   
    Scanner scan=new Scanner(System.in);
	
    Teacher t[]=new Teacher[2];
    Student s[]=new Student[3];
       
        String filename = "file.txt";

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream ou = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(ou);
            for(int i=0;i<2;i++)
            {
            // Method for serialization of object
                t[i] = new Teacher();
                int k = i+1;
                System.out.println("\nEnter name of teacher "+k+" : ");
                String tname=scan.nextLine();
                System.out.println("\nEnter subject of teacher "+k+" : ");
                String tsub=scan.nextLine();
                System.out.println("\nEnter ID of teacher "+k+" : " + k);
                int tID=k;

                t[i].Teacher(tname,tsub,tID);
                out.writeObject(t[i]);
            }

            for(int i=0;i<3;i++)
            {
                // Method for serialization of object
                 s[i] = new Student();
                 int k = i+1;
                 System.out.println("Enter name of student "+k+" : ");
                 String sname=scan.nextLine();
                 System.out.println("\nEnter subject of student "+k+" : ");
                 String sdep=scan.nextLine();
                 System.out.println("\nEnter ID of student "+k+" : "+k);
                 int sID=k;
                 s[i].Student(sname,sdep,sID);
                 out.writeObject(s[i]);
            }

            ou.close();
            ou.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught 1");
        }

        Teacher tr[] = new Teacher[2];
        Student sr[] = new Student[3];

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            for(int k=0;k<2;k++){
            tr[k] = (Teacher)in.readObject();}


            for(int l=0;l<3;l++){
                sr[l] = (Student)in.readObject();}

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught 2");
        }

        catch(ClassNotFoundException ex)
        {
           System.out.println("ClassNotFoundException is caught");
        }

        ArrayList<Teacher> tlist = new ArrayList<Teacher>();
        ArrayList<Student> slist = new ArrayList<Student>();

        for (int i=0;i<2;i++){
            tlist.add(tr[i]);
        }

        for (int i=0;i<3;i++){
            slist.add(sr[i]);
        }

        Iterator titr = tlist.iterator();

        while (titr.hasNext()){
            System.out.println(titr.next());
        }

        Iterator sitr = slist.iterator();

        while (sitr.hasNext()){
            System.out.println(sitr.next());
        }

    }}