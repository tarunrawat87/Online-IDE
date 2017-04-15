package com.tr.projects.OnlineCompiler.backend;
 
import com.tr.projects.OnlineCompiler.backend.tools.*;
import com.tr.projects.OnlineCompiler.backend.exceptions.*;
import com.tr.projects.OnlineCompiler.util.*;

import java.io.*;
import java.util.concurrent.*;

public class CodeCompiler 
{
private String compilerOutputFileName;
private String compilerErrorFileName;
private String programInputFileName;
private String programOutputFileName;
private String programErrorFileName;
private String fileName;
private String command;
private String output;
private File programFiles[];
public CodeCompiler()
{
programFiles=new File[6];
programFiles[0]=new File(compilerOutputFileName="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\output.txt");
programFiles[1]=new File(compilerErrorFileName="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\error.txt");
programFiles[2]=new File(programInputFileName="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\progamInput.txt");
programFiles[3]=new File(programOutputFileName="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\progamOutput.txt");
programFiles[4]=new File(programErrorFileName="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\progamError.txt");
//programFiles[5]=new File
fileName="c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\program.";
 
//deleteFiles(programFiles);  




}
public void getCompiler(String type,String code,String output,String input) throws backendException
{
System.out.println(type);
//System.out.println("code"+code);

String compilerName=getCompilerName(type);
System.out.println(compilerName);

if(compilerName==null)throw new backendException("Such a compiler is not installed");
try
{
File file=null;
if(compilerName.toLowerCase().equals("node")){ file=new File(fileName+"js");}
else
{
file=new File(fileName+type.toLowerCase());
}
if(file.exists())file.delete();
writeToFile(file,code);

File errorFile=new File(compilerErrorFileName);
File outputFile=new File(compilerOutputFileName);
ProcessBuilder processBuilder;//continue here
if(compilerName.equals("javac"))
{

processBuilder=new ProcessBuilder(compilerName,"-d","c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\",file.getAbsolutePath());
processBuilder.redirectError(errorFile);
processBuilder.redirectOutput(outputFile);
Process process=processBuilder.start();
process.waitFor();

}
if(compilerName.equals("gcc"))
{
processBuilder=new ProcessBuilder(compilerName,file.getAbsolutePath(),"-o","c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\o.exe");
processBuilder.redirectError(errorFile);
processBuilder.redirectOutput(outputFile);
Process process=processBuilder.start();
 process.waitFor();

}
if(compilerName.equals("g++"))
{

processBuilder=new ProcessBuilder(compilerName,file.getAbsolutePath(),"-o","c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\o.exe");
processBuilder.redirectError(errorFile);
processBuilder.redirectOutput(outputFile);
Process process=processBuilder.start();
 process.waitFor();

}









FileContentReader fileContentReader=new FileContentReader();
if(fileContentReader.hasErrorMessage(errorFile))
{

throw new backendException(fileContentReader.getMessage(errorFile));
}
//Running the code Workleft
if(compilerName.equals("javac"))
{
System.out.println("Running..");

processBuilder=new ProcessBuilder("java","-classpath","c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles;","psp");
processBuilder.redirectError(new File(programErrorFileName));
processBuilder.redirectOutput(new File(programOutputFileName));
processBuilder.redirectInput(new File(programInputFileName));


TaskRunner t=new TaskRunner(processBuilder);

TimeRunner timeRunner=new TimeRunner();

while(true)
{
if(!timeRunner.isAlive())
{
if(t.isAlive())
{
System.out.println("Infinite Loopp..");
t.stop();
throw new backendException("Time Limit Exceeded !");
}
System.out.println(" Completed JVM Here");
break;
}
}
timeRunner.join();
t.join();
this.output=new FileContentReader().getMessage(new File(programOutputFileName));
System.out.println(" Java  Done");
return ;

}
if(compilerName.equals("gcc"))
{

processBuilder=new ProcessBuilder("c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\o.exe");
processBuilder.redirectError(new File(programErrorFileName));

processBuilder.redirectOutput(new File(programOutputFileName));
processBuilder.redirectInput(new File(programInputFileName));


TaskRunner t=new TaskRunner(processBuilder);
TimeRunner timeRunner=new TimeRunner();


while(t.isAlive())
{
if(!timeRunner.isAlive())
{
t.stop();
 Runtime.getRuntime().exec("taskkill /F /IM o.exe");
Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");

throw new backendException("Time Limit Exceeded !");

}

}

timeRunner.join();
t.join();
this.output=new FileContentReader().getMessage(new File(programOutputFileName));
System.out.println(" C  Done");
return;

}
if(compilerName.equals("g++"))
{
System.out.println("C++...");
processBuilder=new ProcessBuilder("c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\o.exe");
processBuilder.redirectError(new File(programErrorFileName));
processBuilder.redirectOutput(new File(programOutputFileName));
processBuilder.redirectInput(new File(programInputFileName));


System.out.println("Checkpoint 1");

TaskRunner t=new TaskRunner(processBuilder);
TimeRunner timeRunner=new TimeRunner();
System.out.println("Checkpoint 2");

while(t.isAlive())
{
if(!timeRunner.isAlive())
{
t.stop();
Runtime.getRuntime().exec("taskkill /F /IM o.exe");
Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");

throw new backendException("Time Limit Exceeded !");

}


}
timeRunner.join();
t.join();
this.output=new FileContentReader().getMessage(new File(programOutputFileName));
return;






}



if(compilerName.equals("node"))
{
System.out.println("NodeJS...");
processBuilder=new ProcessBuilder("node ",file.getAbsolutePath());
processBuilder.redirectError(new File(programOutputFileName));
processBuilder.redirectOutput(new File(programOutputFileName));
processBuilder.redirectInput(new File(programInputFileName));


System.out.println("Checkpoint 1");

TaskRunner t=new TaskRunner(processBuilder);
TimeRunner timeRunner=new TimeRunner();
System.out.println("Checkpoint 2");

while(t.isAlive())
{
if(!timeRunner.isAlive())
{
t.stop();
Runtime.getRuntime().exec("taskkill /F /IM node.exe");
Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");

throw new backendException("Time Limit Exceeded !");

}


}
timeRunner.join();
t.join();
this.output=new FileContentReader().getMessage(new File(programOutputFileName));
System.out.println(output);
return;






}







}catch(Exception exception)
{
throw new backendException(exception.getMessage());
}
finally
{
}
}

public String getCompilerName(String type)
{
if(type.toLowerCase().equals("c"))
return "gcc";
if(type.toLowerCase().equals("c++"))
return "g++";
if(type.toLowerCase().equals("java"))
return "javac";
if(type.toLowerCase().equals("nodejs"))
return "node";


return null;
}

public void runProgram(String type,String filename) throws backendException
{
ProcessBuilder processBuilder=new ProcessBuilder();


}
private void writeToFile(File file,String fileContent)
{
try
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
randomAccessFile.writeBytes(fileContent);
randomAccessFile.close();
}catch(IOException exception)
{
System.out.println(exception);
}
}
public String getOutput()
{
return this.output;
}

private void releaseResources()
{

for(File file:programFiles)
{

File inputFile=new File("c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\progamInput.txt");
if(!file.getName().equals("c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\progamInput.txt"))file.delete();
{
try{
RandomAccessFile randomAccessFile=new RandomAccessFile(inputFile,"rw");

randomAccessFile.setLength(0);
randomAccessFile.close();
//File outputFiles=new File("c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\o.exe");
//outputFiles.delete();

}catch(IOException exception)
{
System.out.println("Error in relaseREcd");
}
System.out.println("Resources Deleted");
}
} 
}
}