package shiyan3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Cal extends JFrame implements ActionListener
{
	static JTextField input1=new JTextField(10);
	static JTextField input2=new JTextField(10);
	static JTextField result=new JTextField(10);
    static JPanel jpan = new JPanel(new GridLayout(2, 2));    //运算按钮区域设置网格布局
    static JButton plus=new JButton("+");
	static JButton min=new JButton("-");
    static JButton multi = new JButton("×");
    static JButton divide=new JButton("/");
    static JLabel text1 = new JLabel("输入数1");
    static JLabel text2 = new JLabel("输入数2");
    static JLabel text3 = new JLabel("结果");
    static Font butfont = new Font("console", Font.PLAIN, 20);    //按钮字体
    static Font textfont = new Font("宋体", Font.BOLD, 14);        //文字标签字体

    public Cal()        //构造方法，创建GUI界面
    {
		this.setLayout(null);
		this.setBounds(50,50,280,300);
		input1.setBounds(90,10,150,30);
		input2.setBounds(90,50,150,30);
		result.setBounds(90,90,150,30);
		jpan.setBounds(100,135,100,100);
		text1.setFont(textfont);
		text2.setFont(textfont);
		text3.setFont(textfont);
		text1.setBounds(20, 15,80,20);
		text2.setBounds(20, 55,80,20);
		text3.setBounds(20, 95,80,20);
		this.add(text1);
		this.add(text2);
		this.add(text3);
		this.add(input1);
		this.add(input2);
		this.add(result);
		this.add(jpan);
		plus.setFont(butfont);
		min.setFont(butfont);
		multi.setFont(butfont);
		divide.setFont(butfont);
        plus.addActionListener(this);        //按钮注册监听者
        min.addActionListener(this);
		divide.addActionListener(this);
		multi.addActionListener(this);
		jpan.add(plus);
		jpan.add(min);
		jpan.add(multi);
		jpan.add(divide);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
        Cal frm = new Cal();        //创建cal对象
    }

    //----------------按钮事件处理
    public void actionPerformed(ActionEvent e)
	{
        float num1 = Float.parseFloat(input1.getText());    //转化为float类型进行计算
        float num2=Float.parseFloat(input2.getText());
		if((JButton)e.getSource()==plus)
			result.setText(""+(num1+num2));
		
		if((JButton)e.getSource()==min)
			result.setText(""+(num1-num2));
		
		if((JButton)e.getSource()==multi)
			result.setText(""+(num1*num2));
		
		if((JButton)e.getSource()==divide)
		{
			if(num2==0)
                result.setText("被除数不能为零！");        //当有除数为零的情况则结果框报错
            else
				result.setText(""+(num1/num2));
		}	
	}
}