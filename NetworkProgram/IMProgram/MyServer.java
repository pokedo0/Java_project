package NetworkProgram.IMProgram;

import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(30000);
            ServerSocket s2 = new ServerSocket(8080);
            while (true) {
                Socket client = ss.accept();
                ServerThread serverThread = new ServerThread(client);
                new Thread(serverThread).start();  // Æô¶¯Ïß³Ì
                Socket client2 = s2.accept();
                ServerThread serverThread1 = new ServerThread(client2);
                new Thread(serverThread1).start();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}