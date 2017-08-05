package demo11_2;
class MyThread implements Runnable
{
	private String who;
	public MyThread(String name)
	{
		who=name;
	}
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			try{
				Thread.sleep((long) (1000*Math.random()));
			}
			catch(InterruptedException e)
			{
				System.out.println(e.toString());
			}
            System.out.println(who + "正在运行!");
        }
	}
}

public class demo11_2 
{
	public static void main(String args[])
	{
        MyThread your = new MyThread("你");
        MyThread mon = new MyThread("妈");
        Thread t1=new Thread(your);
		Thread t2=new Thread(mon);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
		}
		t2.start();
	}
}
