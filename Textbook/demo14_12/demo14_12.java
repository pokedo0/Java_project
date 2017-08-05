package demo14_12;        //组合框

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class demo14_12 extends JFrame
{
	static demo14_12 frm=new demo14_12();
	static JComboBox combo;
	static JTextArea ta=new JTextArea(5,15);
	static String[] color={"red","green","blue","yellow"};
	public static void main(String args[])
	{
		frm.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		combo=new JComboBox(color);
		combo.setEditable(true);
		combo.addItemListener(frm.new MyItemListener());
		combo.addActionListener(frm.new MyActionListener());
		frm.add(combo);
		frm.add(ta);
		frm.setSize(700,360);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    class MyItemListener implements ItemListener        //内部类，非静态
    {
		public void itemStateChanged(ItemEvent e)
		{
			JComboBox cb=(JComboBox)e.getSource();
			String clr=(String)cb.getSelectedItem();
			if(clr=="red")
				ta.setBackground(Color.RED);
			if(clr=="blue")
				ta.setBackground(Color.blue);
			if(clr=="yellow")
				ta.setBackground(Color.yellow);
            frm.setTitle("您选择了" + clr);
            ta.setText("您选择了" + clr);
        }
	}

    class MyActionListener implements ActionListener    //内部类，非静态
    {
		public void actionPerformed(ActionEvent e)
		{
			JComboBox cb=(JComboBox)e.getSource();
			String s=(String)cb.getSelectedItem();
			ta.setText(s+"\n");		
		}		
	}
}