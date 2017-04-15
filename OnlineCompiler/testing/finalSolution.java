import java.io.*;

class TaskRunner extends Thread
{
private ProcessBuilder processBuilder;
private Process process;
public TaskRunner(ProcessBuilder processBuilder)
{
this.processBuilder=processBuilder;
start();
}
public void run()
{

try
{
System.out.println("Starting execution..");
//process=processBuilder.start();
//process.waitFor();
//Runtime.getRuntime().exec("o.exe");
int x=0;



}catch(Exception e)
{
System.out.println(e);
}
finally
{
//process.destroy();
}
}
}


class TimeRunner extends Thread
{
TimeRunner()
{
start();
}
public void run()
{
try
{
System.out.println("Timer starts");
Thread.sleep(2000);
}catch(InterruptedException e)
{
System.out.println(e);
}
}
}

class psp
{
private ProcessBuilder processBuilder;
public void run()
{
processBuilder=new ProcessBuilder("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\o.exe");
processBuilder.redirectError(new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\abc.txt"));
processBuilder.redirectOutput(new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\abc1.txt"));
processBuilder.redirectInput(new File("c:\\tomcat7\\webapps\\OnlineCompiler\\testing\\abc2.txt"));


System.out.println("Checkpoint 1");
try{
TaskRunner t=new TaskRunner(processBuilder);
TimeRunner timeRunner=new TimeRunner();

System.out.println("Checkpoint 2");

System.out.println(t.isAlive());
while(t.isAlive())
{
if(!timeRunner.isAlive())
{
t.stop();
Runtime.getRuntime().exec("taskkill /F /IM o.exe");
Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");

throw new Exception("Time Limit Exceeded !");

}
}

}catch(Exception e)
{
System.out.println(e);

}








}
public static void main(String a[])
{
new psp().run();
}
}
