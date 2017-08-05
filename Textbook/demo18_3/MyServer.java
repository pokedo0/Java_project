package demo18_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pokedo on 2017/2/27.
 */
public class MyServer implements Runnable{
    ServerSocket server = null;
    Socket clientSocket;
    boolean flag = true;
    Thread connenThread;
    BufferedReader sin;
    DataOutputStream sout;
    int n = 0;

    public static void main(String[] args) {
        MyServer ms = new MyServer();
        ms.serverStart();
    }

    private void serverStart() {
        try {
            server = new ServerSocket(8080);
            System.out.println("port : " + server.getLocalPort());
            while (flag) {
                clientSocket = server.accept();
                System.out.println("link estiblished ! ");
                InputStream is = clientSocket.getInputStream();
                sin = new BufferedReader(new InputStreamReader(is));
                OutputStream os = clientSocket.getOutputStream();
                sout = new DataOutputStream(os);
                connenThread = new Thread(this);
                connenThread.start();
                String line;
                while ((line = sin.readLine()) != null) {
                    System.out.println(line);
                    if (line.equals("exit")) {
                        connenThread.interrupt();
                        flag = false;
                        break;
                    }
                    System.out.println("line");
                }
                sout.close();
                os.close();
                sin.close();
                is.close();
                clientSocket.close();
                System.out.println("close");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true){
            try{
                int ch;
                while((ch = System.in.read()) != -1){
                    sout.write((byte)ch);
                    //.flush()写入到流中,只要sout还没close(),
                    // client端则一直接收sout发送的字节流
                    if(ch == '\n')
                        sout.flush();
                    System.out.println("run");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void finalize(){
        try{
            server.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

