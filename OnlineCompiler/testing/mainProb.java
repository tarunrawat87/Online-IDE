import java.util.concurrent.*;

class psp
{
public static void main(String a[])
{
Callable<Void> callable=()->{
while(true);
};
Callable<Integer> callable1=()->{

Thread.sleep(500);

return 10;

};

ExecutorService es=Executors.newFixedThreadPool(2);
Future<Void> future=es.submit(callable);
Future<Integer> future1=es.submit(callable1);

while(!future.isDone())
{
if(future1.isDone())
{
future.cancel(true);
}
}
System.out.println("Problem");
es.shutdownNow();

es.shutdownNow();
}
}
