package demo10_6;
import java.io.*;
public class demo10_6 {

	public static void main(String[] args) throws IOException
	{
		FileWriter fw=new FileWriter("d:\\test.txt");
		char[] c={'g','g','h','k'};
		String str="ceshi SB";
	  	fw.write(c);
		fw.write(str);
		fw.close();
		
	}

}
