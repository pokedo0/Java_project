package UDPServer;
import java.net.*;
import java.io.*;
public class UDPServer {

	public static void main(String args[])
	{
		UDPServer frm=new UDPServer();
	}
	
	String strbuf="";

    public UDPServer()    //服务器类线程对象st
    {
		SerThread st=new SerThread();
		st.start();
	}
}
class SerThread extends Thread
{
	public void run()
	{
		String str1;
		try{
			DatagramSocket skt=new DatagramSocket(8000);
            System.out.println("服务器名:" + InetAddress.getLocalHost().getHostName());
            while(true)
			{
                byte[] inbuf = new byte[256];        //byte数组，创建packet数据包对象
                DatagramPacket pkt=new DatagramPacket(inbuf,inbuf.length);
				skt.receive(pkt);
                str1 = new String(pkt.getData());//接收packet数据
                str1.trim();                    //去掉字符串中首尾空格
                if(str1.length()>0)
				{
					int pot=pkt.getPort();
                    System.out.println("远程端口:" + pot);
                    System.out.print("服务器已接收到信息:" + str1);
                }
			}
			
		}
		catch(IOException e){}	
	}
}
