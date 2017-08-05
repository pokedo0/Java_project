package demo14_10;            //鼠标拖动按钮

import javax.swing.*;
import java.awt.event.*;
public class demo14_10 extends JFrame
{
	static JTextField tf=new JTextField(20);
    static JButton but = new JButton("拖动我");
    static int px,py,ox,oy,offx,offy,x,y;
	public demo14_10()
	{
		new MyMouseMotionList();
	}
	public static void main(String args[])
	{
		demo14_10 frm=new demo14_10();
		frm.setLayout(null);
        frm.setTitle("鼠标事件的");
        frm.setBounds(10,10,660,520);
		tf.setBounds(60,200,400,40);
		but.setBounds(60,50,160,50);
		tf.setEditable(false);
		frm.add(tf);
		frm.add(but);
		but.addMouseMotionListener(new MyMouseMotionList());
		but.addMouseListener(new MyMouseList());
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	static class MyMouseList extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			px=e.getX();
			py=e.getY();
			ox=but.getLocation().x;
			oy=but.getLocation().y;
		}
	}
	static class MyMouseMotionList extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			
			offx=e.getX()-px;
			offy=e.getY()-py;
			x=ox+offx;
			y=oy+offy;
            String position = "命令按钮放置在(" + x + "," + y + ")的位置";
            tf.setText(position);
			but.setLocation(x,y);
			ox=x;
			oy=y;	
		}	
	}	
}