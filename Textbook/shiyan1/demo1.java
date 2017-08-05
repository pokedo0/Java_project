package shiyan1;
import java.util.*;
public class demo1 {
	public static void main(String[] args)
	{
		int count=0,sum=0;
        int arr[] = new int[50];        //new一个数组存放因数
        Scanner reader=new Scanner(System.in);
		System.out.println("please input the number:");
		int num=reader.nextInt();
        //以下求出所有因数，并存入arr数组中
        for (int i = 1; i < num; i++)        //当求出因数时，数组下标count+1,sum求和当前因数
            if(num%i==0)
			{
				arr[count]=i;
				count++;
				sum+=i;
			}
        //以下判断是否为完全数，并输出结果
        if (num == 0)            //特殊判断
            System.out.println(num + "不是完整数！");
        else if(sum==num)
		{
            System.out.println(num + "是完整数!");
            for(int j=0;j<count;j++)
			{	
				if(j!=count-1)
					System.out.print(arr[j]+"+");
				else
					System.out.print(arr[j]+"="+sum);
			}
		}
		else if(sum!=num)
            System.out.println(num + "不是完整数！");
    }
}
