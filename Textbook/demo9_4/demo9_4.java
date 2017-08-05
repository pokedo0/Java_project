package demo9_4;

public class demo9_4 
{
	public static double multi(int n)
	{
		if(n<0)
            throw new IllegalArgumentException("求负数阶乘异常");
        double s=1;
		for(int i=1;i<=n;i++)
			s=s*i;
		return s;
	}
	public static void main(String[] args) 
	{
        try            //捕获异常
        {
            int m = Integer.parseInt(args[0]);    //在DOS中运行，java demo9_4  +参数
            System.out.println(m+"!="+multi(m));
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
            System.out.println(e.toString() + "命令行中没提供参数");
        }
		catch(NumberFormatException e)
		{
            System.out.println(e.toString() + "应输入一个整数");
        }
		catch(IllegalArgumentException e)
		{
            System.out.println("出现异常是:" + e.toString());
        }
		finally
		{
            System.out.println("程序运行结束!");
        }
	}
}
