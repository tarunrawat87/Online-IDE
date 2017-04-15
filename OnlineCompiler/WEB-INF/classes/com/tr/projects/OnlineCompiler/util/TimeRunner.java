package com.tr.projects.OnlineCompiler.util;



public class TimeRunner extends Thread
{
public TimeRunner()
{
start();
}
public void run()
{
try
{
Thread.sleep(1000);
}catch(InterruptedException e)
{
System.out.println(e);
}
}
}
