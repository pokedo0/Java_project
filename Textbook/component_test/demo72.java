package component_test;
import java.awt.event.*;
import javax.swing.*;
public class demo72 extends MouseAdapter implements MouseMotionListener
{
	JFrame frm;
	JTextField text;
	
	public void display()
	{
		frm=new JFrame();
		frm.setBounds(10,10,300,200);
		frm.setLayout(null);
		text=new JTextField(200);
		text.setBounds(20,70,300,30);
		frm.add(text);
		frm.addMouseListener(this);
		frm.addMouseMotionListener(this);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
	}
	public static void main(String[] args) 
	{
		new demo72().display();
	}
	public void mousePressed(MouseEvent e)
	{
        text.setText("鼠标按下坐标" + e.getPoint());
    }
	public void mouseReleased(MouseEvent e)
	{
        text.setText("鼠标释放坐标" + e.getPoint());
    }
	public void mouseMoved(MouseEvent e)
	{
        text.setText("鼠标移动坐标" + e.getPoint());
    }
	public void mouseDragged(MouseEvent e)
	{
        text.setText("鼠标拖动坐标" + e.getPoint());
    }
}
