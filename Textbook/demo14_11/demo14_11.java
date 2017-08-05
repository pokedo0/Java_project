package demo14_11;        //列表框

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class demo14_11 extends JFrame implements ListSelectionListener
{
	private JList list;
    private JTextField tf = new JTextField("我是文本框");
    private String[]color={"red","green","blue","yellow"};
	List demo;
	public demo14_11(String s)
	{
		super(s);
		list=new JList (color);
		JScrollPane ps=new JScrollPane(list);
		list.addListSelectionListener(this);
		add(ps,BorderLayout.CENTER);
		add(tf,BorderLayout.NORTH);
		setSize(400,260);
		setVisible(true);
	}
	public static void main(String argsp[])
	{
        demo14_11 frm = new demo14_11("列表框");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void valueChanged(ListSelectionEvent e)
	{
		JList lt=(JList)e.getSource();
		String clr=(String)lt.getSelectedValue();
        //String clr=(String)list.getSelectedValue();		//lt用直接用list也可以？~~
        if(clr=="red")
			tf.setBackground(Color.red);
		if(clr=="green")
			tf.setBackground(Color.green);
		if(clr=="blue")
			tf.setBackground(Color.blue);
		if(clr=="yellow")
			tf.setBackground(Color.yellow);
	}
	
}
