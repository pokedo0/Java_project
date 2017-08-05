package shiyan1;
import java.util.*;
public class demo2 
{
	public static void main(String[] args)
	{
        int flat = 0;            //跳出循环条件
        Scanner reader=new Scanner(System.in);
		while(flat==0)
		{
			try
			{
				System.out.println("please input the month:");
				int a=reader.nextInt();
                if (a == 0 || a < 0)                //输入数有效性判断
                    System.out.println("请输入大于0的整数!");
                else if(a<=2||a==12) {
                    System.out.println(a + "月是冬季");
                    flat = 1;
                } else if(a>=3&&a<=5) {
                    System.out.println(a + "月是春季");
                    flat = 1;
                } else if(a>=6&&a<=8) {
                    System.out.println(a + "月是秋季");
                    flat = 1;
                } else if(a>=9&&a<=11) {
                    System.out.println(a + "月是秋季");
                    flat = 1;
                }
            } catch (InputMismatchException e)        //输入数为小数时抛出异常
            {
                System.out.println("请输入整数！异常:" + e.toString());
                break;
			}
		}
	}
}
