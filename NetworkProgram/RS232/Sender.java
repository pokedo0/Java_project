package NetworkProgram.RS232;

import gnu.io.SerialPort;

import java.io.*;

import static java.lang.Thread.sleep;

/**
 * Created by pokedo on 2017/3/14.
 */
public class Sender implements Runnable {
    SerialPort serialPort;
    BufferedReader readerout;
    OutputStream outStr;

    public Sender(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    @Override
    public void run() {
        try {
            System.out.println("The client has started !");
            readerout = new BufferedReader(new InputStreamReader(System.in));
            outStr = serialPort.getOutputStream();
            while (true) {
                String msg = readerout.readLine();
                if (msg != null && !"".equals(msg)) {
                    System.out.print("Send : \n" + msg + "\n");
                    outStr.write(msg.getBytes("utf-8"));
                    outStr.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                readerout.close();
                outStr.close();
                serialPort.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
