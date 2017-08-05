package NetworkProgram.IMProgram;

import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 30000);
            new Thread(new ClientThread(client)).start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}