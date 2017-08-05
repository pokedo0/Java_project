package demo9_5;

public class demo9_5 
{
	static void check(String str1)throws NullPointerException
	{
		if(str1.length()>2)
		{
			str1=null;
            System.out.println(str1.length());        //null长度抛出空指针异常
        }
		char ch;
		for(int i=0;i<str1.length();i++)
		{
			ch=str1.charAt(i);
            if (!Character.isDigit(ch))        //判断参数中是否为数字
                throw new NumberFormatException();
		}
	}

    public static void main(String[] args) throws Exception        //抛出异常给系统处理
    {
		int num;
		try
		{
            check(args[0]);                    //DOS中输入参数
            num=Integer.parseInt(args[0]);
			if(num>60)
                System.out.println("成绩为:" + num + "及格");
            else
                System.out.println("成绩为" + num + "不及格");
        }
		catch(NullPointerException e)
		{
            System.out.println("空指针异常" + e.toString());
        }
		catch(NumberFormatException e)
		{
            System.out.println("输入参数不是数值类型" + e.toString());
        }
		catch(Exception e)
		{
            System.out.println(e.toString() + "命令行中没有参数");
        }
	}
}
