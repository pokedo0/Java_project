package demo14_4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class demo14_14 extends JFrame implements ActionListener
{
	static demo14_14 frm=new demo14_14();
	static JPanel pan1=new JPanel();
	static JPanel pan2=new JPanel();
    static JButton but1 = new JButton("第一页");
    static JButton but2 = new JButton("上一页");
    static JButton but3 = new JButton("下一页");
    static JButton but4 = new JButton("最后页");
    static CardLayout crd=new CardLayout(5,10);
	public static void main(String[] args)
	{
		frm.setLayout(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setTitle("操作事件");
        pan2.setLayout(new GridLayout(1,4));
		pan1.setLayout(crd);
		frm.setSize(350,300);
        but1.addActionListener(frm);        //frm向but注册
        but2.addActionListener(frm);
		but3.addActionListener(frm);  
		but4.addActionListener(frm);
		pan1.setBounds(10, 10, 320, 200);
		pan2.setBounds(10, 220, 320, 25);
		frm.add(pan1);
		frm.add(pan2);
        JLabel lab1 = new JLabel("第一页", JLabel.CENTER);
        JLabel lab2 = new JLabel("第二页", JLabel.CENTER);
        JTextField tex = new JTextField("卡片式布局策略", 18);
        pan1.add(lab1, "n1");            //将lab命名为n1后加入pan1中，卡片布局中堆叠卡片显示
        pan1.add(lab2,"n2");
		pan1.add(tex,"n3");
        crd.show(pan1, "n3");            //将pan1中的n3组件显示在容器中
        pan2.add(but1);                    //将but1加入pan2中
        pan2.add(but2);
		pan2.add(but3);
		pan2.add(but4);
		frm.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
        JButton but = (JButton) e.getSource();            //获得事件源并强制转换成JButton类型
        if(but==but1) crd.first(pan1);
        else if (but == but2) crd.previous(pan1);        //前一页
        else if (but == but3) crd.next(pan1);            //下一页
        else crd.last(pan1);
	}
}
