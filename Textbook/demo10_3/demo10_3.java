package demo10_3;
import java.io.*;
public class demo10_3 
{

	public static void main(String[] args)
	{
		FileInputStream fin;
		DataInputStream din;
		FileOutputStream fout;
		DataOutputStream dout;
		try
		{
            fout = new FileOutputStream("d:\\temp");        //过滤流
            dout = new DataOutputStream(fout);            //数据处理
            dout.writeInt(10);
			dout.writeLong(12345);
			dout.writeFloat(3.14153f);
            dout.writeChars("GoOOO！");
            dout.close();
		}
		catch(IOException e)
		{}
		try
		{
			fin=new FileInputStream("d:\\temp");
			din=new DataInputStream(fin);
			System.out.println(din.readInt());
		 	System.out.println(din.readLong());
			System.out.println(din.readFloat());
		//	System.out.println(din.readChars());
			char ch;
			while((ch=din.readChar())!='\0')
				System.out.print(ch);
			din.close();
		}
		catch(IOException e)
		{}
	}
}
