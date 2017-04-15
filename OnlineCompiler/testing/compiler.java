//package com.tr.projects.OnlineCompiler.backend;

import java.io.*;

class Compiler
{
public static void main(String a[])
{
try
{
ProcessBuilder processBuilder=new ProcessBuilder("javac","abcd.java");

File errorFile=new File("error.txt");
File outputFile=new File("output.txt");

processBuilder.redirectError(errorFile);
processBuilder.redirectOutput(outputFile);

Process process=processBuilder.start();





}catch(Exception exception)
{
System.out.println(exception);
}
}

}