package demo14_7;            //窗口组件及其事件处理

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class demo14_7 extends JFrame implements WindowListener
{
	static JLabel lab=new JLabel();
	static demo14_7 frm=new demo14_7();
	public demo14_7()
	{
		this.setLayout(null);
        setTitle("窗口事件");
        setBounds(120,50,520,300);
		lab.setBounds(15,10,300,100);
		add(lab);
		addWindowListener(this);
		setVisible(true);
	}
	public static void main(String args[])
	{
		
	}
	public void windowOpened(WindowEvent e)
	{
        lab.setText("打开新窗口");
    }
	public void windowActivated(WindowEvent e)
	{
        lab.setText("窗口被激活");
    }
	public void windowIconified(WindowEvent e)
	{
        frm.setTitle("窗口被最小化");
    }
	public void windowDeiconified(WindowEvent e)
	{
        frm.setTitle("窗口被还原正常大小");
    }
	public void windowClosing(WindowEvent e)
	{
		frm.dispose();
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e)
	{
        lab.setText("窗口失去焦点");
    }
	public void windowClosed(WindowEvent e)
	{
	}
}