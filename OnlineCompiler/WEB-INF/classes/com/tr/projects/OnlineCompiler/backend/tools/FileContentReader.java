package com.tr.projects.OnlineCompiler.backend.tools;
import java.io.*;


public class FileContentReader
{
private String message;
public FileContentReader()
{
}
public String getMessage(File file) throws IOException
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
StringBuffer stringBuffer=new StringBuffer();

while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
stringBuffer.append(randomAccessFile.readLine());
stringBuffer.append("\n");
}
randomAccessFile.close();
return new String(stringBuffer);

}
public boolean hasErrorMessage(File file)
{
long length=0;
try
{
String message=getMessage(file);
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
length=randomAccessFile.length();
System.out.println(length);
randomAccessFile.close();
System.out.println(message);
}catch(IOException exception)
{
System.out.println(exception);
}
return length>0;

}
}