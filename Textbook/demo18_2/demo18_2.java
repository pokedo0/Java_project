package demo18_2;
import java.net.*;

public class demo18_2 {
	InetAddress myIPAddress=null;
	InetAddress myServer=null;
	public static void main(String args[])
	{
		demo18_2 search=new demo18_2();
		System.out.println("your ip is:"+search.myIP());
		System.out.println("Sender ip is:"+search.serverIP());
	}
	public InetAddress myIP()
	{
		try
		{
			myIPAddress=InetAddress.getLocalHost();
		}
		catch(UnknownHostException e)
		{}
		return myIPAddress;
	}
	public InetAddress serverIP()
	{
		try{
			myServer=InetAddress.getByName("www.youtube.com");
		}
			catch(UnknownHostException e)
			{}
			return myServer;
	}
}
