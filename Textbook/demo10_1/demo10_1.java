package demo10_1;
import java.io.*;
public class demo10_1 {
	public static void main(String[] args) 
	{
        FileInputStream fin;        //声明文件字节输入流对象fin
        FileOutputStream fout;
		char ch;
		int data;
		try
		{
            fin = new FileInputStream(FileDescriptor.in);        //创建输入对象
            fout=new FileOutputStream("d:\\abc.txt");
			System.out.println("please input the Strings,press'#' to end.");
            while ((ch = (char) fin.read()) != '#')    //读取后强转为char
                fout.write(ch);
			fin.close();
			fout.close();
			
			System.out.println();
			fin=new FileInputStream("d:\\abc.txt");
			fout=new FileOutputStream(FileDescriptor.out);
			while(fin.available()>0)
			{
                data = fin.read();    //读取为二进制字节
                fout.write(data);
			}
			fin.close();
			fout.close();
		}
		catch(FileNotFoundException e)
		{
            System.out.println("文件没找到。");
        }
		catch(IOException e)
		{}

	}

}
