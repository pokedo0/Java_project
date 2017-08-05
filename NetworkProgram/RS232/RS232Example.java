package NetworkProgram.RS232;

/**
 * Created by pokedo on 2017/3/13.
 */

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class RS232Example {
    SerialPort serialPort;

    public void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Port in use!");
        } else {
            // points who owns the port and connection timeout
            serialPort = (SerialPort) portIdentifier.open("RS232Example", 2000);

            // setup connection parameters
            serialPort.setSerialPortParams(
                    38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        }
    }

    public static void main(String[] args) throws Exception {

        RS232Example rs = new RS232Example();
        String Com = "COM6";
        rs.connect(Com);
        System.out.println("Port : " + Com);
        Receiver receiver = new Receiver(rs.serialPort);
        new Thread(receiver).start();
        Sender client = new Sender(rs.serialPort);
        new Thread(client).start();
    }
}