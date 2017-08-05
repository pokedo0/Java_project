package NetworkProgram.IMProgram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/***
 *
 * @author dell
 *服务器端每次都要启动一个线程来对当前监听到的Socket进行通信处理
 */
public class ServerThread implements Runnable {
    private Socket client;  // 当前客户端对应的Socket
    private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));  // 用来从键盘读取信息
    private PrintStream out;  // 用来向当前的客户端Socket输出信息
    private BufferedReader in;// 用来向当前的客户端的Socket读取信息

    public ServerThread(Socket client) {  // 构造方法
        super();
        this.client = client;
    }

    public void run() {
        try {
            out = new PrintStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("服务器已经连接成功");  // 告诉客户端已经连接成功
            out.flush();
            while (true) {
                String msg = in.readLine();  // 读取客户端的信息
                System.out.println("端口为" + client.getLocalPort() + "的客户说:" + msg);// 输出客户端的信息
                msg = read.readLine(); // 从键盘得到服务器端的回复信息
                out.println(msg);
                out.flush();     // 输出缓冲流
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage()); // 打印错误信息
        } finally {
            try {
                out.close();
                in.close();
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }


}