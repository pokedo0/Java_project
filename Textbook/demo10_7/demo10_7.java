package demo10_7;    //缓冲输入输出流
import java.io.*;
public class demo10_7 {

	public static void main(String[] args)  throws IOException
	{
		String Line;
		int count=0;
        FileReader fr = new FileReader("d:\\社长.txt");
        BufferedReader bfr=new BufferedReader(fr);
        while ((Line = bfr.readLine()) != null)        //每次读一行，直到文件结束
        {
				count++;
				System.out.println(Line);
			}
        System.out.println("读取了" + count + "行");
        bfr.close();
	}
}
