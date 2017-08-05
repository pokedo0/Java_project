package demo13_10;		//BorderLayout
import java.awt.*;
import javax.swing.*;
public class demo13_10 
{
	public static void main(String[] args) 
	{
        JFrame frm = new JFrame("边界式布局方式");
        BorderLayout border = new BorderLayout(5, 10);        //水平垂直间隔
        frm.setLayout(border);
		frm.setSize(500, 300);
		frm.add(new JButton("north"),BorderLayout.NORTH);
		frm.add(new JButton("east"),BorderLayout.EAST);
		frm.add(new JButton("south"),BorderLayout.SOUTH);
		frm.add(new JButton("west"),BorderLayout.WEST);
		frm.add(new JButton("center"),BorderLayout.CENTER);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
