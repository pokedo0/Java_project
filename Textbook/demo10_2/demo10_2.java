package demo10_2;        //读写二进制文件
import java.io.*;
public class demo10_2 
{
	public static void main(String[] args)	throws IOException
	{
		FileInputStream fin=new FileInputStream("d:\\javatest.jpg");   //throw filenotfoundexception
		FileOutputStream fout=new FileOutputStream("d:\\copy.png");
		System.out.println("the size of file:"+fin.available());
		byte[] b=new byte[fin.available()];
		fin.read(b);
		fout.write(b);
		System.out.println("done");
		fin.close();			//throw IOexception
		fout.close();
	}
}
