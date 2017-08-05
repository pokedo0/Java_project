package component_test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class demo73 extends MouseAdapter implements ActionListener
{
	JFrame frm;
	JMenuBar mb1;
	JMenu mf1,me1;
	JPopupMenu pm1;
	JTextArea jta;
	JScrollPane jsp;
	public void display()
	{
		frm=new JFrame();
		frm.setBounds(10,10,240,180);
		frm.setLayout(null);
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jsp.setBounds(0,0,240,180);
		frm.add(jsp);
		jta.addMouseListener(this);
		addpopupMenu();
		addmyMenu();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);

	}

    public void addpopupMenu()        //弹出式菜单对象
    {
		pm1=new JPopupMenu("Popup");
        pm1.add(new JMenuItem("复制"));
        pm1.add(new JMenuItem("粘贴"));
        jta.add(pm1);
	}
	public void addmyMenu()
	{
		mb1=new JMenuBar();
        frm.setJMenuBar(mb1);    //菜单栏添加进JFrame
        mf1 = new JMenu("文件");
        me1 = new JMenu("编辑");
        mb1.add(mf1);
		mb1.add(me1);
        mf1.add(new JMenuItem("打开"));
        mf1.add(new JMenuItem("保存"));
        mf1.addSeparator();        //分割线
        JMenuItem itemExit = new JMenuItem("退出");
        mf1.add(itemExit);
		itemExit.addActionListener(this);
        me1.add(new JMenuItem("剪切"));
        me1.add(new JMenuItem("复制"));
    }
	public void actionPerformed(ActionEvent e)
	{
        if (e.getActionCommand() == "退出")
            System.exit(0);
	}
	public void mouseReleased(MouseEvent e)
	{
        if (e.isPopupTrigger())        //isPopupTrigger()方法进行判断用户是否要求弹出菜单
            pm1.show((Component)e.getSource(), e.getX(), e.getY());
	}
	public static void main(String[] args) 
	{
		new demo73().display();
	}

}
