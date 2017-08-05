package demo13_1;        //JFrame类
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
public class demo13_1 {
    static JFrame jfrm = new JFrame("这是个swing program");

    public static void main(String[] args)
	{
        JLabel lab = new JLabel("我是一个标签");
        Image im=(new ImageIcon("22.jpg")).getImage();
		jfrm.setIconImage(im);
		jfrm.setSize(500, 800);
		jfrm.setBackground(Color.BLUE);
		jfrm.setLocation(260,300);
		jfrm.add(lab);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);	
	}
}
