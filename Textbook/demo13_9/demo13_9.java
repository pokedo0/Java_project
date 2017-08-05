package demo13_9;                //FlowLayout类
import java.awt.*;
import javax.swing.*;
public class demo13_9 extends JFrame
{
    static JFrame frm = new JFrame("流式布局设置管理器Flowlayout");

    public static void main(String[] args)
	{
		FlowLayout flow=new FlowLayout(FlowLayout.CENTER,50,20);
        JButton but = new JButton("按钮");
        JLabel lab = new JLabel("一个标签");
        frm.setLayout(flow);            //设置页面布局为流式布局方式
        frm.setSize(520, 300);
		frm.add(but);
		frm.add(lab);
        frm.add(new JTextField("流式布局策略flowlayout", 18));
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
