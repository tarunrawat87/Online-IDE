class psp
{
public static void main(String a[])
{
try
{
ProcessBuilder processBuilder=new ProcessBuilder("del C://javaeg//ab.java ");
Process process=processBuilder.start();
process.waitFor();
}catch(Exception exception)
{
System.out.println(exception);
}
}
}