package demo11_6;

class Bank
{
	private static int sum=2000;

    public synchronized static void take(int k)        //互斥，同步资源，必须完成当前线程才轮到下一个线程
    {
		int temp=sum;
		temp-=k;
		try {
			Thread.sleep((long) (1000*Math.random()));
		} catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
		}
		sum=temp;
		System.out.println("sum="+sum+"      "+Thread.currentThread().getName());
	}
}
class Customer extends Thread
{
	public void run()
	{
		for(int i=1;i<=4;i++)
			Bank.take(100);
	}
}

public class demo11_6 {
	public static void main(String args[])
	{
		Customer c1=new Customer();
		Customer c2=new Customer();
		c1.start();
		c2.start();
	}
}
