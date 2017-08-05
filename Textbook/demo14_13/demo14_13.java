package demo14_13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class demo14_13 extends JFrame
{
	private Color[] colorValues={Color.black,Color.blue,Color.red,Color.green};
	private JRadioButtonMenuItem[] colorItems,fonts;
	private JCheckBoxMenuItem[] styleItems;
	private JTextArea display;
	private ButtonGroup colorGroup,fontGroup;
	private int style;
	private JPopupMenu popupMenu;
	public demo14_13()
	{
        super("菜单应用程序");
        JMenu fileMenu = new JMenu("文件(F)");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem aboutItem = new JMenuItem("关于(A)");
        aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                JOptionPane.showMessageDialog(demo14_13.this, "这是一个菜单应用例子", "关于", JOptionPane.PLAIN_MESSAGE);
            }
		}
		
		);
		fileMenu.add(aboutItem);
        JMenuItem exitItem = new JMenuItem("退出(X)");
        exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
				
			}
		}
		);
		fileMenu.add(exitItem);
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
        JMenu formatMenu = new JMenu("格式(R)");
        formatMenu.setMnemonic(KeyEvent.VK_R);
		String[] colors={"black","blue","red","green"};
        JMenu colorMenu = new JMenu("颜色(C)");
        colorMenu.setMnemonic(KeyEvent.VK_C);
		colorItems=new JRadioButtonMenuItem[colors.length];
		colorGroup=new ButtonGroup();
		ItemHandler itemHandler=new ItemHandler();
		for(int count=0;count<colors.length;count++)
		{
			colorItems[count]=new JRadioButtonMenuItem(colors[count]);
			colorMenu.add(colorItems[count]);
			colorGroup.add(colorItems[count]);
			colorItems[count].addActionListener(itemHandler);
		}
		colorItems[0].setSelected(true);
		formatMenu.add(colorMenu);
		formatMenu.addSeparator();
        String[] fontNames = {"Serif", "宋体", "楷体"};
        JMenu fontMenu = new JMenu("字体(N)");
        fontMenu.setMnemonic(KeyEvent.VK_N);
		fonts=new JRadioButtonMenuItem[fontNames.length];
		fontGroup=new ButtonGroup();
		for(int count=0;count<fonts.length;count++)
		{
			fonts[count]=new JRadioButtonMenuItem(fontNames[count]);
			fontMenu.add(fonts[count]);
			fontGroup.add(fonts[count]);
			fonts[count].addActionListener(itemHandler);
		}
		fonts[0].setSelected(true);
		fontMenu.addSeparator();
        String[] styleNames = {"粗体", "斜体"};
        styleItems=new JCheckBoxMenuItem[styleNames.length];
		StyleHandler styleHandler=new StyleHandler();
		for(int count=0;count<styleNames.length;count++)
		{
			styleItems[count]=new JCheckBoxMenuItem(styleNames[count]);
			fontMenu.add(styleItems[count]);
			styleItems[count].addItemListener(new StyleHandler());
			
		}
		formatMenu.add(fontMenu);
		bar.add(formatMenu);
        display = new JTextArea("请设置字体和颜色");
        display.setForeground(colorValues[0]);
        display.setFont(new Font("宋体", Font.PLAIN, 20));
        add(display,BorderLayout.CENTER);
		setSize(600,400);
		setVisible(true);
		
		}
		public static void main(String args[])
		{
			demo14_13 frm=new demo14_13();
			frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		private class ItemHandler implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				for(int count=0;count<colorItems.length;count++)
				{
					if(colorItems[count].isSelected())
					{
						display.setForeground(colorValues[count]);
						break;
					}
				}
				for(int count=0;count<fonts.length;count++)
				{
					if(e.getSource()==fonts[count])
					{
						display.setFont(new Font(fonts[count].getText(),style,20));
						break;
					}
				}
			}
		}
		private class StyleHandler implements ItemListener
		{
			public void itemStateChanged(ItemEvent e)
			{
				int style=0;
				if(styleItems[0].isSelected())
					style+=Font.BOLD;
				if(styleItems[1].isSelected())
				{
					style+=Font.ITALIC;
				}
				display.setFont(new Font(display.getFont().getName(),style,20));
			}
		}
}