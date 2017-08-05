package demo13_2;        //JPanel类
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class demo13_2 {
	public static void main(String[] args) 
	{
		JFrame jfrm=new JFrame("My frame");
		jfrm.setSize(400, 400);
		jfrm.setLocation(500,400);
		JPanel jpan=new JPanel();
		jpan.setSize(300,300);
		jpan.setLocation(40, 30);
		JButton bun=new JButton("Click me");
		bun.setSize(150,50);
		bun.setLocation(100,100);
        jfrm.setLayout(null);        //取消默认布局管理器
        jpan.setLayout(null);
		jpan.add(bun);
        jpan.setBorder(new TitledBorder("面板区"));        //为jpan设置边框
        jfrm.add(jpan);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
	}

}
