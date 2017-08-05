package demo10_10;
import java.io.*;
public class demo10_10
{
	public static void main(String[] args) throws Exception
	{
        //	BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));	//从键盘读取输入字符
        System.out.println("输入文件所在路径:");
//		String str1=buf.readLine();
//		File dir=new File(str1);
//		System.out.println(str1);
        System.out.println("请输入欲读取的文件名:");
//		String str2=buf.readLine();
//		System.out.println(str2);
		File readForm=new File("d:\\lib","322.txt");
		if(readForm.isFile()&&readForm.canWrite()&&readForm.canRead())
		{
			RandomAccessFile rafFile=new RandomAccessFile(readForm,"rw");
			while(rafFile.getFilePointer()<rafFile.length());
				System.out.println(rafFile.readLine());
			System.out.println("test");
			rafFile.close();
		}
		else
            System.out.println("文件不可用");
    }
}
