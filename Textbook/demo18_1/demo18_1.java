package demo18_1;
import java.net.*;
import java.io.*;
public class demo18_1 {

	public static void main(String args[])
	{
		String urlName="http://www.edu.cn/index.html";
		if(args.length>0)
			urlName=args[0];
		new demo18_1().display(urlName);
	}
	public void display(String urlName)
	{
		try
		{
			URL url=new URL(urlName);
			InputStreamReader in=new InputStreamReader(url.openStream());
			BufferedReader br=new BufferedReader(in);
			String aLine;
			while((aLine=br.readLine())!=null)
				System.out.println(aLine);
		}
			catch(MalformedURLException e)
			{
				System.out.println(e);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}	
	}
}
