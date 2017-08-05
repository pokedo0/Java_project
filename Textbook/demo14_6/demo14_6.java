package demo14_6;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class demo14_6	extends JFrame implements ActionListener 
{
    private JLabel[] arr = {new JLabel("用户名"), new JLabel("密码")};
    private JTextField jName = new JTextField();                //用户名文本框
    private JPasswordField jPassword = new JPasswordField();    //声明密码文本框
    private JTextArea jText = new JTextArea("现不可编辑", 10, 30);    //声明文本区
    private JScrollPane jsp = new JScrollPane(jText);            //创建滚动窗格，显示文本区对象

    public demo14_6()
	{
		this.setLayout(null);
		arr[0].setBounds(20,10,50,25);
		jName.setBounds(70,10,170,25);
		arr[1].setBounds(20,30,50,25);
		jPassword.setBounds(70,35,170,25);
		jsp.setBounds(20,70,220,100);
        jText.setEnabled(false);                //文本去对象jtext为不可编辑状态
        jText.setDisabledTextColor(Color.RED);    //文本区禁用时文字为红色
        this.add(jsp);                //滚动窗格jsp添加到窗口中
        this.add(arr[0]);
		this.add(arr[1]);
		this.add(jName);
		this.add(jPassword);
        jName.addActionListener(this);            //注册监听者
        jPassword.addActionListener(this);
        this.setTitle("文本组件的应用");
        this.setBounds(100,100,280,220);
	}
	public static void main(String[] args) 
	{
		demo14_6 frm=new demo14_6();
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {                                            //char[]转String类
        if(jName.getText().equals("abc")&&String.valueOf(jPassword.getPassword()).equals("123"))
		{
            jText.setEnabled(true);        //设置文本区为可编辑状态
            jText.setText("可编辑状态");
            jText.setLineWrap(true);    //设置文本区自动折行
        }
	}
}
