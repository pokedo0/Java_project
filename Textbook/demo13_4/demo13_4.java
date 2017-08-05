package demo13_4;            //JLabel类
import java.awt.*;
import javax.swing.*;
public class demo13_4 {
	public static void main(String[] args) 
	{
        JFrame jfrm = new JFrame("标签类窗口");
        JLabel jlab = new JLabel("我是一个标签", JLabel.RIGHT);
        jfrm.setLayout(null);
		jfrm.setSize(500, 500);
        Container c = jfrm.getContentPane();        //通过方法调用container再设置其内容窗格颜色
        c.setBackground(Color.PINK);
        //	jfrm.setBackground(Color.pink);			//框架背景颜色，但被内容窗格遮盖。
        jlab.setOpaque(true);                    //设置标签为不透明
        jlab.setBackground(Color.yellow);        //标签背景色
        jlab.setForeground(Color.red);            //标签前景颜色，字体颜色
        jlab.setSize(200,50);
		jlab.setLocation(100,80);
		Font fnt=new Font("Serief",Font.BOLD+Font.ITALIC,20);
		jlab.setFont(fnt);
		jfrm.add(jlab);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);

	}

}
