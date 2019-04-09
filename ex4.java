import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

class stopWords{

public void remove()
{
String[] stopWrds={"a","why","this","an"};

try{
File file=new File(“dialogue.txt”);
Scanner fip1= new Scanner(file); //file here from which you want to remove the stop words
FileOutputStream out=new FileOutputStream(“removedstopwords.txt”);

while(fip1.hasNext())
{
int flag=1;
String s1=fip1.next();
s1=s1.toLowerCase();
for(int i=0;i<stopWrds.length;i++){
if(s1.equals(stopWrds[i])){
flag=0;
}
}
if(flag!=0)
{
System.out.println(s1);
PrintStream p=new PrintStream(out);
p.println(s1);
}

}

}
catch(Exception e){
System.err.println(“cannot read file”);

}
