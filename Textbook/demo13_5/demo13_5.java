package demo13_5;            //Jbutton类
import javax.swing.*;

public class demo13_5 extends JFrame    //继承JFrame类
{
	public static void main(String[] args)
	{
		demo13_5 jfrm=new demo13_5();
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ic = new ImageIcon("avatest.jpg");        //创建一个图标对象
        JButton btn = new JButton("2", ic);        //创建一个button，设置文字和图标
        jfrm.setLayout(null);
		jfrm.setSize(400,360);					//
        jfrm.setTitle("按钮类窗口");                //标题
        btn.setBounds(100, 90, 300, 80);            //设置button位置，大小
        btn.setToolTipText("我是按钮");            //显示提示信息
        jfrm.add(btn);
		jfrm.setVisible(true);
	}
}
