import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.*;

class psp
{
public static void main(String a[])
{
try
{
String Line="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\o.exe";
CommandLine cmdLine=CommandLine.parse(Line);
DefaultExecutor executor = new DefaultExecutor();
executor.setExitValue(1);
ExecuteWatchdog watchdog = new ExecuteWatchdog(6000);
executor.setWatchdog(watchdog);
int exitValue = executor.execute(cmdLine);
System.out.println(exitValue);
}catch(Exception e)
{}
}
}