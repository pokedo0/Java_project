package demo13_11;            //GridLAyout 计算器
import java.awt.*;
import javax.swing.*;
public class demo13_11 
{
	static JPanel pan=new JPanel();
	static JTextField tf=new JTextField("0. ");
	static JButton[] b=new JButton[10];
	static JButton bp,ba,bs,bm,bd,be;
	public static void main(String[] args) 
	{
		for(int i=0;i<=9;i++)
            b[i] = new JButton("" + i);    //转为字符串，设置显示数字
        bp=new JButton(".");ba=new JButton("+");bs=new JButton("-");
		bm=new JButton("*");bd=new JButton("/");be=new JButton("=");
        JFrame frm = new JFrame("网格式布局管理器");
        frm.setLayout(null);
		frm.setSize(300, 350);
        GridLayout grid = new GridLayout(4, 4);        //创建4X4的页面布局
        pan.setLayout(grid);
		tf.setBounds(35,15,220,30);
		pan.setBounds(35, 50, 220, 200);
        tf.setBackground(Color.CYAN);                //文本框背景颜色
        tf.setHorizontalAlignment(JTextField.RIGHT);        //设置文本框中文字向右对齐
        pan.add(b[7]);pan.add(b[8]);pan.add(b[9]);pan.add(bd);
		pan.add(b[4]);pan.add(b[5]);pan.add(b[6]);pan.add(bm);
		pan.add(b[1]);pan.add(b[2]);pan.add(b[3]);pan.add(bs);
		pan.add(b[0]);pan.add(bp);pan.add(be);pan.add(ba);
		frm.add(tf);
		frm.add(pan);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);	
	}
}
