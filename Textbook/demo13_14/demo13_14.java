package demo13_14;				//BoxLayout
import java.awt.Container;
import javax.swing.*;
public class demo13_14 {

	public static void main(String[] args) 
	{
        JFrame frm = new JFrame("盒式布局管理器");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(400,130);
        BoxLayout b1 = new BoxLayout(frm.getContentPane(), BoxLayout.X_AXIS);        //容器为frm的内容窗格
        frm.setLayout(b1);
		JButton but;
		for(int i=1;i<10;i++)
		{
            but = new JButton("按钮" + i);
            frm.add(but);
		}
		frm.setVisible(true);
	}
}
