package demo14_8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class demo14_8 extends JFrame implements ActionListener
{
	JTextField inputName=new JTextField(20);
	JTextArea nameArea=new JTextArea();
	public demo14_8(String s)
	{
		super(s);	
		inputName=new JTextField(20);
		inputName.addActionListener(this);
		nameArea=new JTextArea();
		add(inputName,BorderLayout.NORTH);
		add(nameArea,BorderLayout.CENTER);
		setBounds(50,50,600,400);
		setVisible(true);
	}
	public static void main(String args[])
	{
        demo14_8 frm = new demo14_8("确认对话框窗口");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		String str=inputName.getText();
		int n=JOptionPane.showOptionDialog(this,"showinputdialog","show",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,new Object[]{"but1","but2","but3"},"but1");
        //	int n=JOptionPane.showConfirmDialog(this,"请确认您的输入是否正确","确认对话框",JOptionPane.YES_NO_CANCEL_OPTION);
        //	if(n==JOptionPane.YES_OPTION)
			nameArea.append(str+"\n");
	//	else if(n==JOptionPane.NO_OPTION)
			inputName.setText(null);
	}
}