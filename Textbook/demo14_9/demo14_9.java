package demo14_9;

import java.awt.event.*;
import javax.swing.*;
public class demo14_9 extends JFrame
{
	int x,y;
	JButton bt=new JButton("move me");
	JTextField tf=new JTextField();
	public demo14_9(String s)
	{
		super(s);
		setLayout(null);
		setBounds(100,100,600,600);
		bt.setBounds(30,30,160,40);
		bt.addKeyListener(new Mykey());
		tf.setBounds(60,200,340,40);
		add(bt);
		add(tf);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String args[])
	{
        demo14_9 frm = new demo14_9("键盘事件");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class Mykey extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			JButton but=(JButton)e.getSource();
			x=but.getLocation().x;
			y=but.getLocation().y;
			if(e.getKeyCode()==KeyEvent.VK_UP)
			{
				y=y-2;
				if(y<=0)
					y=0;
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				y=y+2;
				if(y>=240)
					y=240;
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			{
				x=x-2;
				if(x<=0)
					x=0;
			}
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				x=x+2;
				if(x>=200)
					x=200;
			}
			but.setLocation(x,y);
		}
		public void keyReleased(KeyEvent e)
		{
            String str = "按钮左上角的位置是(" + x + "," + y + ")";
            tf.setText(str);
		}
	}
}
