package demo13_6;                //RCheckbox和JRadioButton
import javax.swing.*;
public class demo13_6   extends JFrame
{
    static JFrame frm = new JFrame("复选框和单选框");
    static JCheckBox jchk1 = new JCheckBox("粗体", true);
    static JCheckBox jchk2 = new JCheckBox("斜体", true);
    static JCheckBox jchk3 = new JCheckBox("下划线", true);
    static JRadioButton jrb1=new JRadioButton("red");
	static JRadioButton jrb2=new JRadioButton("green",true);
	static JRadioButton jrb3=new JRadioButton("blue");
	public static void main(String[] args)
	{
        ButtonGroup grp = new ButtonGroup();        //创建一个单选按钮组对象
        frm.setLocation(200,150);
		frm.setSize(300, 220);
		frm.setLayout(null);
        jchk1.setBounds(20, 20, 200, 50);            //设置位置，大小
        jchk2.setBounds(20,40,150,20);
		jchk3.setBounds(20,60,150,20);
		jrb1.setBounds(20,80,150,20);
		jrb2.setBounds(20,100,150,20);
		jrb3.setBounds(20,120,150,20);
        grp.add(jrb1);                            //加入到单选按钮组中成为单选按钮
        grp.add(jrb2);
		grp.add(jrb3);
        frm.add(jchk1);                            //复选框加入窗口中
        frm.add(jchk2);
		frm.add(jchk3);
        frm.add(jrb1);                            //单选按钮加入窗口中
        frm.add(jrb2);
		frm.add(jrb3);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
