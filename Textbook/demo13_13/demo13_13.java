package demo13_13;
import java.awt.*;
import java.awt.GridBagConstraints.*;
import javax.swing.*;
public class demo13_13 extends JFrame
{
	static demo13_13 frm=new demo13_13();
    static JLabel jlab = new JLabel("调整窗口大小", JLabel.CENTER);
    static JTextArea jta1 = new JTextArea("文本区1", 5, 15);
    static JTextArea jta2 = new JTextArea("文本区2", 5, 15);
    static JTextField jtf = new JTextField("文本框");
    static JPanel jp=new JPanel();
    static JButton jbt1 = new JButton("按钮1");
    static JButton jbt2 = new JButton("按钮2");

    public static void main(String[] args)
	{
        frm.setTitle("网格包布局设置管理器");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(350, 130);
		frm.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();    //创建网格包约束条件对象
        gbc.fill = GridBagConstraints.BOTH;                    //组件具有填充模式both
        gbc.anchor = GridBagConstraints.CENTER;                //当组件小于显示区域时，居中对齐
        Container conta = frm.getContentPane();                //获取frm的内容窗格
        frm.addCom(jlab, conta, gbc, 0, 0, 1, 4, 0, 0);                //设置组件属性，先行后列
        frm.addCom(jta1,conta,gbc,1,0,2,1,5,1);
		frm.addCom(jta2,conta,gbc,1,3,1,1,5,0);
		frm.addCom(jtf,conta,gbc,2,3,1,1,5,0);
		frm.addCom(jbt1,conta,gbc,3,1,1,1,5,0);
		frm.addCom(jbt2,conta,gbc,3,2,1,1,5,0);
        jp.setBackground(Color.cyan);            //设置面板jp背景色
        jp.setBorder(new javax.swing.border.LineBorder(Color.red));        //jp带红色边框
        gbc.insets = new Insets(10, 10, 10, 10);                //设置jp与显示区域边缘的距离,在特定填充模式下有效果
        frm.addCom(jp,conta,gbc,1,1,2,2,10,5);
		frm.setVisible(true);
	}
	private void addCom(Component c, Container con, GridBagConstraints gbcon, int row,
                        int col, int numberOfRow, int numberOfCol, double weightX, double weightY) //自定义方法
    {
        gbcon.gridy = row;            //位置变量
        gbcon.gridx=col;
        gbcon.gridwidth = numberOfCol;    //占行列数大小变量
        gbcon.gridheight=numberOfRow;
        gbcon.weightx = weightX;        //缩放比例变量
        gbcon.weighty=weightY;
        con.add(c, gbcon);        //把组件c和按约束条件gbcon添加到容器con(conta内容窗格)中
        //  frm.add(c,gbcon);	    //也可实现上面功能，frm中添加对应组件和约束条件
    }
}
