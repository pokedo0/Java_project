package NetworkProgram.RS232;

import gnu.io.SerialPort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Thread.sleep;

/**
 * Created by pokedo on 2017/3/17.
 */
public class Receiver implements Runnable {
    InputStream intStr;
    BufferedReader readerin;
    SerialPort serialPort;

    public Receiver(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    @Override
    public void run() {
        try {
            intStr = serialPort.getInputStream();
            readerin = new BufferedReader(new InputStreamReader(intStr));
            String str = null;
            byte[] b = new byte[1024];
            int len = 0;
            int c;
            while (true) {
                if ((c = intStr.read()) != -1) {
                    System.out.println("Receive:");
                    len = intStr.read(b);
                    String s = new String(b, 0, len);
                    if (s != null && !"".equals(s))
                        System.out.println((char) c + s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                intStr.close();
                readerin.close();
                serialPort.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

