package demo13_12;					//CardLayout
import java.awt.*;
import javax.swing.*;
public class demo13_12 extends JFrame
{
    static JFrame frm = new JFrame("卡片式布局设置管理器");
    static JPanel pan1=new JPanel();
	static JPanel pan2=new JPanel();		
	public static void main(String[] args) 
	{
		frm.setLayout(null);
		pan2.setLayout(new GridLayout(1,4));
		CardLayout crd=new CardLayout(20,20);
        pan1.setLayout(crd);        //pan1设定了CardLayout
        frm.setSize(450,400);
//		frm.setResizable(false);
		pan1.setBounds(10, 10, 400, 200);
		pan2.setBounds(10, 200, 400, 40);
		frm.add(pan1);
		frm.add(pan2);
        JLabel lab1 = new JLabel("我是第一页", JLabel.CENTER);
        JLabel lab2 = new JLabel("我是第二页", JLabel.CENTER);
        JTextField tex = new JTextField("卡片式布局策略", 18);
        pan1.add(lab1, "c1");        //pan1加入三条新建的组件
        pan1.add(lab2,"c2");
		pan1.add(tex, "t1");
        crd.show(pan1, "t1");        //pan1设定了CardLayout,设定显示 t1
        pan2.add(new JButton("第一页"));        //pan2没有设定为CardLayout,默认显示
        pan2.add(new JButton("上一页"));
        pan2.add(new JButton("下一页"));
        pan2.add(new JButton("最后页"));
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
