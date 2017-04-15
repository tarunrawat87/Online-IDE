package com.tr.projects.OnlineCompiler.util;

public class TaskRunner extends Thread
{
private ProcessBuilder processBuilder;
public TaskRunner(ProcessBuilder processBuilder)
{
this.processBuilder=processBuilder;
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


