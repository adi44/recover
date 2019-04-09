import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class StopWords{
	public void remove()
	{
		String[] stopWrds = {"is","are"};
		try
		{
			Scanner scan =new Scanner(new File("dialogue.txt"));
			FileOutputStream out= new FileOutputStream("result.txt");
			while(scan.hasNext())
			{
				int flag=1;
				String s1= scan.next();
				s1=s1.toLowerCase();
				for(int i=0;i<stopWrds.length;i++)
				{
					if(s1.equals(stopWrds[i]))
					{
						flag=0;
					}
				}
			if(flag!=0)
			{
				System.out.print(s1);
				PrintStream p=new PrintStream(out);
				p.println(s1);
			}
			}
		}
	catch(Exception e){
		System.err.println();
	}
	}
}