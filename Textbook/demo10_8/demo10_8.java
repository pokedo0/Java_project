package demo10_8;        //利用缓冲区输入输出流复制文件
import java.io.*;
public class demo10_8 {

	public static void main(String[] args) throws IOException
	{
		String str;
        BufferedReader in = new BufferedReader(new FileReader("d:\\社长.txt"));        //内部new了FileReader
        BufferedWriter out=new BufferedWriter(new FileWriter("d:\\test1.txt"));
		while((str=in.readLine())!=null)
		{
            System.out.println(str);        //显示
            out.write(str);
			out.newLine();
		}
        out.flush();            //缓冲区数据全部写入文件中
        in.close();
		out.close();
	}
}
