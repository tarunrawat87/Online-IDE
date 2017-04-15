package com.tr.projects.OnlineCompiler.backend;

import java.io.*;

class ErrorMessage
{
private String message;
public ErrorMessage()
{
message="";
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


}