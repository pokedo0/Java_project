package creditCard;
import java.util.Scanner;

//creditcard类，功能为控制逻辑输入和输出结果
public class creditCard {
	public static void main(String args[])
	{
		Scanner reader=new Scanner(System.in);
		Number num=new Number();
        //循环输入，直至输入 end 结束程序
        while(true)
		{
			System.out.println("Please input the credit Card number:");
			System.out.println("(Press 'end' to end the program)");
			String sample=reader.next();
            //结束程序
            if(sample.equals("end"))
			{
				System.out.println("The program has exit");
				break;
			}
            //调用检测类Number，当输入格式不对时，捕捉异常并作出提示，进入下一轮循环输入
            try{
				if(num.Test(sample)==true)
					System.out.println("Pass!\n");
				else
					System.out.println("Fail to pass!\n");
				}
			catch(Exception e)
			{System.out.println("The format of number is not right!!\n");}
		}

	}
}

//Number类，功能为检测输入数据并返回true或false结果
class Number
{
	public  boolean Test(String sample)
	{
		int[] array=Reverse(sample);
        int odd = 0;        //奇数
        int even = 0;        //偶数
        //遍历数组
        for(int i=0;i<array.length;i++)
		{
            if ((i + 1) % 2 != 0)    //奇数情况
                odd+=array[i];
            else            //偶数情况
            {
				if(array[i]*2<10)
					even+=array[i]*2;
				else
					even+=array[i]*2-9;
			}	
		}
//调试，输出 奇数 偶数 结果
//		System.out.println("\nodd"+odd);
//		System.out.println("even"+even);
		if(((odd+even)%10)==0)
			return true;
		else
			return false;
	}

    //对输入数据做逆序处理并返回一个数组
    //逆序处理:新建数组并从sample尾部逐个遍历，从数组前部开始赋值
    public  int[] Reverse(String sample)
	{
		int length=sample.length();
		int arr[]=new int[length];
		for(int i=0;i<sample.length();i++)
		{
			arr[i]=Integer.parseInt(String.valueOf(sample.charAt(length-1-i)));
		}
//输出逆序后的结果，调试用
//		for(int a:arr)
//		{System.out.print(a);}
		return arr;
	}
}
