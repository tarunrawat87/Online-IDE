class thread1 extends Thread
{
thread1()
{
start();
}
public void run()
{
while(true);
}
}


class thread2 extends Thread
{
thread2()
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

}


}


}


class psp
{
public static void main(String a[])
{
thread1 t1=new thread1();
thread2 t2=new thread2();

while(true)
{
if(!t2.isAlive())
{
t1.stop();
System.out.println("Dead");
break;
}
}
}
}