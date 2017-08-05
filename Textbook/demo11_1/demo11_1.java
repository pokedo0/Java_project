package demo11_1;

class MyThread extends Thread
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
			{}
            System.out.println(who + "正在运行");
        }
	}
}
public class demo11_1
{
	public static void main(String args[])
	{
        MyThread your = new MyThread("你");
        MyThread mon = new MyThread("妈");
        your.start();
		mon.start();
        System.out.println("mian 运行结束");
    }
}

