package demo11_5;
class ThreadSale implements Runnable
{
	private int tickets=10;
	public void run()
	{
		while(true)
		{
			if(tickets>0)
                System.out.println(Thread.currentThread().getName() + "ÊÛ»úÆ±µÚ" + tickets-- + "ºÅ");
            else
				System.exit(0);
		}
	}
}

public class demo11_5 {
	public static void main(String args[])
	{
		ThreadSale t=new ThreadSale();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		t1.start();
		t2.start();
		t3.start();
	}
}
