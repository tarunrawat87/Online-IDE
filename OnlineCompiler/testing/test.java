import java.io.*;

class psp
{
public static void main(String a[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader bsr=new BufferedReader(isr); 

try
{
int x=Integer.parseInt(bsr.readLine());
System.out.println(x+3);
int y=Integer.parseInt(bsr.readLine());
System.out.println(y-3);

}catch(IOException e)
{

}
}
}