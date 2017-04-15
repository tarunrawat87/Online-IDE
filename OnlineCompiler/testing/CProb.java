import java.io.*;

class TaskRunner extends Thread
{
private ProcessBuilder processBuilder;
private Process process;
TaskRunner(ProcessBuilder processBuilder)
{
this.processBuilder=processBuilder;
//this.process=process;
start();
}
public void run()
{

try
{
Process process=processBuilder.start();
process.waitFor();
}catch(Exception e)
{
System.out.println(e);
}

}
}


class TimerRunner extends Thread
{
TimerRunner()
{
start();
}
public void run()
{
try
{
Thread.sleep(2000);
}catch(InterruptedException e)
{
System.out.println(e);
}
}
}









class psp
{
public void start()
{
try
{
//File file=new File("input.txt");
//RandomAccessFile raf=new RandomAccessFile(file,"rw");
//raf.close();
ProcessBuilder processBuilder;
processBuilder=new ProcessBuilder("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\o.exe");
processBuilder.redirectError(new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\error.txt"));

processBuilder.redirectOutput(new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\output.txt"));
processBuilder.redirectInput(new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\input.txt"));
//Process process;
TaskRunner t=new TaskRunner(processBuilder);
TimerRunner timeRunner=new TimerRunner();

while(t.isAlive())
{

if(!timeRunner.isAlive())
{
t.stop();
 Runtime.getRuntime().exec("taskkill /F /IM o.exe");
throw new Exception("Time Limit Exceeded !");

}

}

}
catch(Exception e)
{
System.out.println(e);
}

}
public static void main(String a[])
{
new psp().start();
}
}