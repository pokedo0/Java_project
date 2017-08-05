package demo9_3;   //异常处理
public class demo9_3
{
	public static void main(String[] args)
	{
		 int a=5,b=0;
		 try{
			 if(b==0)
                 throw new ArithmeticException();            //抛出异常
             else
				 System.out.println(a+"/"+b+"="+a/b);
		 } catch (ArithmeticException e)                        //捕获异常
         {
             System.out.println("异常" + e + "被抛出");
             e.printStackTrace();
		 }
	}
}
