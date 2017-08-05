package demo13_8;            //JTabbedPane 选项卡
import javax.swing.*;
public class demo13_8 extends JFrame
{
	JTabbedPane jtab=new JTabbedPane(JTabbedPane.TOP);
	public demo13_8()
	{
        JLabel[] lab = new JLabel[6];        // 声明JLabel数组
        Icon pic;                        //声明图像变量pic
        String title;                    //声明选卡标题变量
        for(int i=1;i<=5;i++)
		{
            pic = new ImageIcon("d:\\0" + i + ".jpg");//创建图像对象pic
            lab[i]=new JLabel();
            lab[i].setIcon(pic);                //设置标签对象lab【i】上的图标
            title = "第" + i + "页";            //将标题和标签添加到选项卡中
            jtab.add(title,lab[i]);
		}
        add(jtab);                        //选项卡添加到窗口中
    }
	
	public static void main(String[] args) 
	{
		demo13_8 frm=new demo13_8();
        frm.setTitle("选项卡应用");
        frm.setSize(4000,1000);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
