package NetworkProgram.RS232;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.util.Enumeration;

public class RS232 {
    public void list() {
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();

        while(ports.hasMoreElements())
        {
            CommPortIdentifier cpIdentifier = (CommPortIdentifier)ports.nextElement();
            System.out.println("¿ÉÓÃ¶Ë¿Ú:");
            System.out.println(cpIdentifier.getName());
        }
    }

    public static void main(String[] args) {
        new RS232().list();
    }
}  