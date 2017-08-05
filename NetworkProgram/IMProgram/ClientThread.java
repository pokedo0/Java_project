package NetworkProgram.IMProgram;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/***
 *
 * @author dell
 *服务器使用Socket连接上服务器之后，启动ClientThread 线程来处理该线程的Socket
 */
public class ClientThread implements Runnable {
    private Socket server;  //与服务器端对应的Socket
    private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));  // 用来从键盘读取信息
    private PrintStream out;  // 用来向当前的服务器端Socket输出信息
    private BufferedReader in;// 用来向当前的服务器的Socket读取信息
    private InputStream inputStream;
    String msg;

    public ClientThread(Socket server) {
        super();
        this.server = server;
    }

    public void run() {
        try {
            out = new PrintStream(server.getOutputStream());
            inputStream = server.getInputStream();
//            in = new BufferedReader(new InputStreamReader(inputStream));
            byte[] b = new byte[1024];
            int len = 0;
            while (true) {
                msg = in.readLine();  // 读取服务器的信息
                System.out.println("服务器端的回复:" + msg);// 输出服务器的信息
//                while ((len = inputStream.read(b)) != -1) {
//                    System.out.println("inputstream:");
//                    String s = new String(b, 0, len);
//                    if (s != null && !"".equals(s))
//                        System.out.println(s);
//                    msg = read.readLine(); // 从键盘得到向服务器的回复信息
//                    out.println(msg);
//                    out.flush();     // 输出缓冲流
//                }
                msg = read.readLine(); // 从键盘得到向服务器的回复信息
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
                server.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}