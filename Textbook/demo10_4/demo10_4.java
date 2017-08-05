package demo10_4;        //标准输入输出流
import java.io.*;
public class demo10_4 {

	public static void main(String[] args)
	{
		try
		{
            byte[] b = new byte[128];        //设置缓冲区
            System.out.println("please input:");
            int count = System.in.read(b);        //读取标准输入流，存放到b中
            System.out.println("what input is:");
			for(int i=0;i<count;i++)
				System.out.print(b[i]+" ");
            for (int i = 0; i < count - 2; i++)        //b中最后含回车符和换行符
                System.out.print((char)b[i]+" ");
            System.out.println("输入字符个数：" + count);
            Class inclass=System.in.getClass();
			Class outclass=System.out.getClass();
            System.out.println("in 所在的类：" + inclass.toString());
            System.out.println("out 所在的类：" + outclass.toString());
        }
		catch(IOException e)
		{}

	}

}
