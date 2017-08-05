package demo18_3;

import java.io.*;
import java.net.Socket;

/**
 * Created by pokedo on 2017/2/27.
 */
public class MyClient implements  Runnable {
    Socket clientSocket;
    boolean flag = true;
    Thread connenThread;
    BufferedReader cin;
    DataOutputStream cout;
    public static void main(String args[]){
        new MyClient().clientStart();
    }

    private void clientStart() {
        try{
            clientSocket = new Socket("127.0.0.1", 8080);
            System.out.println("link established !");
            while(true){
                InputStream is = clientSocket.getInputStream();
                cin = new BufferedReader(new InputStreamReader(is));
                OutputStream os = clientSocket.getOutputStream();
                cout = new DataOutputStream(os);
                connenThread = new Thread(this);
                connenThread.start();
                String line;
                while((line = cin.readLine()) != null){
                    System.out.println(line);
                    if(line.equals("exit")){
                        flag = false;
                        connenThread.interrupt();
                        break;
                    }
// else if(line.equals("close this")){
//                        connenThread.interrupt();
//                        os.close();
//                    }
                }
                cout.close();
                os.close();
                is.close();
                clientSocket.close();
                System.exit(0);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        while (true){
            try{
                int ch;
                while((ch = System.in.read()) != -1){
                    cout.write((byte)ch);
                    if(ch == '\n')
                        cout.flush();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
