package demo13_7;			//JtextField,JtextArea,JPasswordField
import javax.swing.*;
public class demo13_7 extends JFrame
{
    JTextField jtf = new JTextField("该文本框不可编辑", 30);        //创建文本框
    static JPasswordField jpf=new JPasswordField("it is a test",30);
	public demo13_7(String str)
	{
        super(str);                //调用父类JFrame的构造方法
        jtf.setBounds(40,80,280,40);
        jtf.setEditable(false);        //设置为不可编辑,显示为灰色
        add(jtf);            //加入jfrm窗口中
    }
	public static void main(String[] args) 
	{
        demo13_7 frm = new demo13_7("文本编辑功能窗口");
        JTextArea jta = new JTextArea("你好", 10, 30);            //创建文本域
        JScrollPane jsp=new JScrollPane(jta);
		frm.setLocation(400,300);
		frm.setSize(480,440);
		frm.setLayout(null);
        jsp.setBounds(40, 140, 320, 200);            //滚动窗口的位置和大小
        jpf.setBounds(40, 20, 280, 40);            //密码文本 位置和大小
        frm.add(jpf);
		frm.add(jsp);
		char[] password=jpf.getPassword();
		String str=new String(password);		//??????
        System.out.println("口令是:" + password + "转化为文本:" + str);
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
