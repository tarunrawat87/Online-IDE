class CommonObject
{
int x;
boolean flag;
synchronized public void set(int x)
{
try
{
if(flag==true)
{
System.out.println("Producer  is going to wait..");
wait();
System.out.println("Producer is wakes from wait..");
}
notify();

this.flag=true;
this.x=x;
System.out.println("Producer Calling notify..");

}catch(InterruptedException e)
{
System.out.println(e);
}
}
synchronized public int get()
{
try
{
if(flag==false)
{
System.out.println("Consumer is going to wait..");
wait();
System.out.println("Consumer  wakes from wait..");

}
notify();

System.out.println("Consumer Calling notify..");
System.out.println(x);
flag=false;



}catch(InterruptedException e)
{
System.out.println(e);
}
return x;

}
}

class Consumer extends Thread
{
CommonObject c;
Consumer(CommonObject c)
{
this.c=c;
start();
}
public void run()
{
for(int x=1;x<=2;x++)
{
c.get();
}
}
}

class Producer extends Thread
{
CommonObject c;
Producer (CommonObject c)
{
this.c=c;
start();
}
public void run()
{
for(int x=1;x<=2;x++)
{
c.set(x);
}
}
}



class main
{
public static void main(String a[])
{
CommonObject commonObject=new CommonObject();
Consumer thread1=new Consumer(commonObject);
Producer thread2=new Producer(commonObject);

 }
}