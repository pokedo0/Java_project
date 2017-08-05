package demo10_5;
import java.io.*;
public class demo10_5 {

	public static void main(String[] args) throws IOException
	{
		char[] c=new char[500];
        FileReader fr = new FileReader("d:\\社长.txt");
        int num=fr.read(c);
		String str=new String(c,0,num);
        System.out.println("字符个数:" + num);
        System.out.println("内容" + str);
        fr.close();
	}

}
