package component_test;
import java.awt.event.*;
import javax.swing.*;
public class demo69 
{
	JFrame frm=new JFrame();
    JLabel lab = new JLabel("得到焦点");

    public void display()
	{
		frm.setBounds(10,10,300,200);
		frm.setLayout(null);
		lab.setBounds(20,20,80,20);
		frm.add(lab);
		frm.addWindowListener(new WinClose());
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
	}
	class WinClose extends WindowAdapter
	{
		public void windowActivated(WindowEvent e)
		{
            lab.setText("得到焦点");
        }
	    public void windowDeactivated(WindowEvent e)
		{
            lab.setText("失去焦点");
        }
	}
	public static void main(String[] args) 
	{
		new demo69().display();
	}

}
