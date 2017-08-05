package demo18_4;
import java.net.*;
import java.io.*;
public class demo18_4 {

	public static void main(String args[])
	{
		demo18_4 frm=new demo18_4();
	}
	public demo18_4()
	{
		CliThread ct=new CliThread();
		ct.start();
	}
}
class CliThread extends Thread
{
	public void run()
	{
		String str1;
		String servername="DESKTOP-Q7FO4MJ";
        System.out.println("请发送信息给服务器" + servername);
        try{
			DatagramSocket skt=new DatagramSocket();
			DatagramPacket pkt;
			while(true)
			{
				BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
                System.out.print("请输入信息:");
                str1=buf.readLine();
				byte[] outbuf=new byte[str1.length()];
				outbuf=str1.getBytes();
				
				InetAddress address=InetAddress.getByName(servername);
				pkt=new DatagramPacket(outbuf,outbuf.length,address,8000);
				skt.send(pkt);		
			}		
		}
		catch(IOException e)
		{}
	}
}
