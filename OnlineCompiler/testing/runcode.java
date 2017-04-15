import java.io.*;
import java.util.*;
 
class runcode
{
private Thread newThread;
public void runCode()
{


ProcessBuilder processBuilder=new ProcessBuilder("java","-classpath","c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\;","psp");
processBuilder.redirectOutput(new File("outputFile.txt")); 
processBuilder.redirectError(new File("bac.txt")); 





//File inputFile=new File("c:\\tomcat7\\OnlineCompiler\\testing\\ab.txt");
//processBuilder.redirectInput(inputFile); 

try{
Process process=processBuilder.start();
process.waitFor();

File newfile=new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\outputFile.txt");
RandomAccessFile raf=new RandomAccessFile(newfile,"rw");

while(raf.getFilePointer()<raf.length())
{
System.out.println(raf.readLine());
}
raf.close();
}catch(Exception exception)
{
System.out.println(exception);
}



}
public  static void main(String a[])
{
runcode r=new runcode();
r.runCode();
}
}