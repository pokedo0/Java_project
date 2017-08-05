package NotePad;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.event.*;

public class NotePad extends JFrame
{
	JMenuBar Bar;
	JTextArea textArea;
	File file;
    String Carbon = "";    //副本
    UndoManager undoManager;
	JMenu FileMenu,EditMenu,FormatMenu,HelpMenu;

	JMenuItem NewMenuItem,OpenMenuItem,SaveMenuItem,SaveAsMenuItem,Exit;
	JMenuItem UndoMenuItem,RedoMenuItem,CutMenuItem,CopyMenuItem,PasteMenuItem,DeleteMenuItem,FoundMenuItem,
	          ReplaceMenuItem,SelectAllMenuItem,DateMenuItem;
	JCheckBoxMenuItem LineWrapMenuItem;
	JMenuItem FontMenuItem;
	JMenuItem AboutMenuItem;
	JFileChooser fileChooser;
	Font font;

	int position;

    //查找对话框
    FoundDialog foundDialog;

    //替换对话框
    ReplaceDialog replaceDialog;

    //字体对话框
    FontDialog fontDialog;

    //关于对话框
    AboutDialog aboutDialog;

    //弹出式菜单
    JPopupMenu PopupMenu;
	JMenuItem UndoMenuItem2,RedoMenuItem2,CutMenuItem2,CopyMenuItem2,PasteMenuItem2,DeleteMenuItem2,SelectAllMenuItem2;


	public NotePad(String Title)
	{
		super(Title);
        font = new Font("微软雅黑", Font.PLAIN, 13);
        Bar=new JMenuBar();
		textArea=new JTextArea();
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textArea.setLineWrap(true);
		this.add(new JScrollPane(textArea),BorderLayout.CENTER);
//		this.add(textArea,BorderLayout.CENTER);
		this.setBounds(500,500,600,500);
		this.setJMenuBar(Bar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		fileChooser=new JFileChooser();
		Action action=new Action();
		file=null;
        undoManager = new UndoManager();    //撤销管理器

        FileMenu = new JMenu("文件(F)");
        FileMenu.setMnemonic(KeyEvent.VK_F);
		FileMenu.setFont(font);

		Bar.add(FileMenu);
        NewMenuItem = new JMenuItem("新建(N)");
        NewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		NewMenuItem.setFont(font);
		NewMenuItem.addActionListener(action);
        OpenMenuItem = new JMenuItem("打开(O)...");
        OpenMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		OpenMenuItem.setFont(font);
		OpenMenuItem.addActionListener(action);
        SaveMenuItem = new JMenuItem("保存(S)");
        SaveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		SaveMenuItem.setFont(font);
		SaveMenuItem.addActionListener(action);
        SaveAsMenuItem = new JMenuItem("另存为(A)...");
        SaveAsMenuItem.setFont(font);
		SaveAsMenuItem.addActionListener(action);
        Exit = new JMenuItem("退出(X)");
        Exit.setFont(font);
		Exit.addActionListener(action);
		FileMenu.add(NewMenuItem);
		FileMenu.add(OpenMenuItem);
		FileMenu.add(SaveMenuItem);
		FileMenu.add(SaveAsMenuItem);
		FileMenu.addSeparator();
		FileMenu.add(Exit);

        EditMenu = new JMenu("编辑(E)");
        EditMenu.setMnemonic(KeyEvent.VK_E);
		EditMenu.setFont(font);
		Bar.add(EditMenu);
        UndoMenuItem = new JMenuItem("撤销(U)");
        UndoMenuItem.setFont(font);
		UndoMenuItem.addActionListener(action);
		UndoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		/*		textArea.getActionMap().put("Undo", new AbstractAction("Undo")
                {
					public void actionPerformed(ActionEvent e)
					{
						if (undoManager.canUndo())
							undoManager.undo();
						else
							JOptionPane.showMessageDialog(null,"不 可 撤 销 !","Warning",JOptionPane.WARNING_MESSAGE);
					}
				});
		*/
		textArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
        RedoMenuItem = new JMenuItem("重做(R)");
        RedoMenuItem.setFont(font);
		RedoMenuItem.addActionListener(action);
		RedoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
		/*		textArea.getActionMap().put("Undo", new AbstractAction("Redo")
                {
					public void actionPerformed(ActionEvent e)
					{
						if (undoManager.canRedo())
							undoManager.redo();
						else
							JOptionPane.showMessageDialog(null,"不 可 重 做 !","Warning",JOptionPane.WARNING_MESSAGE);
					}
				});
				textArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Redo");
		*/
        textArea.getDocument().addUndoableEditListener(undoManager);   //撤销管理器监听文本域
        CutMenuItem = new JMenuItem("剪切(T)");
        CutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		CutMenuItem.setFont(font);
		CutMenuItem.addActionListener(action);
        CopyMenuItem = new JMenuItem("复制(C)");
        CopyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		CopyMenuItem.setFont(font);
		CopyMenuItem.addActionListener(action);
        PasteMenuItem = new JMenuItem("粘贴(P)");
        PasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		PasteMenuItem.setFont(font);
		PasteMenuItem.addActionListener(action);
        DeleteMenuItem = new JMenuItem("删除(L)");
        DeleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0)); 		//////////////
		DeleteMenuItem.setFont(font);
		DeleteMenuItem.addActionListener(action);
        FoundMenuItem = new JMenuItem("查找(F)...");
        FoundMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		FoundMenuItem.setFont(font);
		FoundMenuItem.addActionListener(action);
        ReplaceMenuItem = new JMenuItem("替换(R)...");
        ReplaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		ReplaceMenuItem.setFont(font);
		ReplaceMenuItem.addActionListener(action);
        SelectAllMenuItem = new JMenuItem("全选(A)");
        SelectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		SelectAllMenuItem.setFont(font);
		SelectAllMenuItem.addActionListener(action);
        DateMenuItem = new JMenuItem("时间/日期(D)");
        DateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));           /////////////
		DateMenuItem.setFont(font);
		DateMenuItem.addActionListener(action);
		EditMenu.add(UndoMenuItem);
		EditMenu.add(RedoMenuItem);
		EditMenu.addSeparator();
		EditMenu.add(CutMenuItem);
		EditMenu.add(CopyMenuItem);
		EditMenu.add(PasteMenuItem);
		EditMenu.add(DeleteMenuItem);
		EditMenu.addSeparator();
		EditMenu.add(FoundMenuItem);
		EditMenu.add(ReplaceMenuItem);
		EditMenu.addSeparator();
		EditMenu.add(SelectAllMenuItem);
		EditMenu.add(DateMenuItem);

        FormatMenu = new JMenu("格式(O)");
        FormatMenu.setMnemonic(KeyEvent.VK_O);
		FormatMenu.setFont(font);
		Bar.add(FormatMenu);
        LineWrapMenuItem = new JCheckBoxMenuItem("自动换行(W)", true);
        LineWrapMenuItem.setFont(font);
		LineWrapMenuItem.addActionListener(action);
        FontMenuItem = new JMenuItem("字体(F)...");
        FontMenuItem.setFont(font);
		FontMenuItem.addActionListener(action);
		FormatMenu.add(LineWrapMenuItem);
		FormatMenu.add(FontMenuItem);

        HelpMenu = new JMenu("帮助(H)");
        HelpMenu.setMnemonic(KeyEvent.VK_H);
		HelpMenu.setFont(font);
		Bar.add(HelpMenu);
        AboutMenuItem = new JMenuItem("关于记事本(A)");
        AboutMenuItem.setFont(font);
		AboutMenuItem.addActionListener(action);
		HelpMenu.add(AboutMenuItem);

        //查找对话框
        foundDialog=new FoundDialog(this);

        //替换对话框
        replaceDialog=new ReplaceDialog(this);

        //字体对话框
        fontDialog=new FontDialog(this);

        //关于对话框
        aboutDialog=new AboutDialog(this);

        //弹出式菜单
        PopupMenu=new JPopupMenu();
        UndoMenuItem2 = new JMenuItem("撤销(U)");
        UndoMenuItem2.addActionListener(action);
        RedoMenuItem2 = new JMenuItem("重做(R)");
        RedoMenuItem2.addActionListener(action);
        CutMenuItem2 = new JMenuItem("剪切(T)");
        CutMenuItem2.addActionListener(action);
        CopyMenuItem2 = new JMenuItem("复制(C)");
        CopyMenuItem2.addActionListener(action);
        PasteMenuItem2 = new JMenuItem("粘贴(P)");
        PasteMenuItem2.addActionListener(action);
        DeleteMenuItem2 = new JMenuItem("删除(L)");
        DeleteMenuItem2.addActionListener(action);
        SelectAllMenuItem2 = new JMenuItem("全选(A)");
        SelectAllMenuItem2.addActionListener(action);
		PopupMenu.add(UndoMenuItem2);
		PopupMenu.add(RedoMenuItem2);
		PopupMenu.add(CutMenuItem2);
		PopupMenu.add(CopyMenuItem2);
		PopupMenu.add(PasteMenuItem2);
		PopupMenu.add(DeleteMenuItem2);
		PopupMenu.add(SelectAllMenuItem2);
		textArea.addMouseListener(action);

	}

	class Action extends MouseAdapter implements ActionListener
	{
		public void mouseReleased(MouseEvent e)
		{
			if (e.isPopupTrigger())
			{
				PopupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		public void actionPerformed(ActionEvent e)
		{
			String command=e.getActionCommand();
            if (command == "新建(N)") {
				int value;
				System.out.println("text"+textArea.getText());
				System.out.println("Carbon"+Carbon);
                if (Carbon.equals(textArea.getText()))        //当副本与文本域文字相同时候
                {
					textArea.setText("");
                    NotePad.this.setTitle("无标题 - 记事本");
                    file=null;
					Carbon="";
				}
				else
				{
					if(file!=null)
                        value = JOptionPane.showOptionDialog(NotePad.this, "是否将更改保存到" + file.getPath() + "?", "记事本",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"保存(S)", "不保存(N)", "取消"}, "保存(S)");
                    else
                        value = JOptionPane.showOptionDialog(NotePad.this, "是否将更改保存到 无标题?", "记事本",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"保存(S)", "不保存(N)", "取消"}, "保存(S)");
                    if(value==0)
						SaveMenuItem.doClick();

					else if(value==1)
					{
						textArea.setText("");
                        NotePad.this.setTitle("无标题 - 记事本");
                        file=null;
                        Carbon = "";        //保存后，副本重新赋值为""
                    }
					else if(value==2)
						{}
				}
			}
            if (command == "打开(O)...") {
				int value;
                if (Carbon.equals(textArea.getText()))        //当副本与文本域文字相同时候
                {
                    value = fileChooser.showOpenDialog(NotePad.this);        //拥有者为NotePad的调用对象frm，也可为frm中的菜单栏组件
                    if(value==JFileChooser.APPROVE_OPTION)
					{
						file=fileChooser.getSelectedFile();
						textArea.setText(readFile(file));
                        NotePad.this.setTitle(file.getName() + " - 记事本");
                        Carbon = textArea.getText();        //副本重新赋值为 文本域的字符
                    }

				}
				else
				{
					if(file!=null)
                        value = JOptionPane.showOptionDialog(NotePad.this, "是否将更改保存到" + file.getPath() + "?", "记事本",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"保存(S)", "不保存(N)", "取消"}, "保存(S)");
                    else
                        value = JOptionPane.showOptionDialog(NotePad.this, "是否将更改保存到 无标题?", "记事本",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"保存(S)", "不保存(N)", "取消"}, "保存(S)");
                    if(value==0)
						SaveMenuItem.doClick();
					else if(value==1)
					{
                        value = fileChooser.showOpenDialog(NotePad.this);        //拥有者为NotePad的调用对象frm，也可为frm中的菜单栏组件
                        if(value==JFileChooser.APPROVE_OPTION)
						{
							file=fileChooser.getSelectedFile();
							textArea.setText(readFile(file));
                            NotePad.this.setTitle(file.getName() + " - 记事本");
                            Carbon = textArea.getText();        //副本重新赋值为 文本域的字符
                        }
					}
					else if(value==2)
						{}
				}
			}
            if (command == "保存(S)") {
				if(file==null)
				{
					int value=fileChooser.showSaveDialog(NotePad.this);
                    if (value == JFileChooser.APPROVE_OPTION)    //点击fileChooser中的保存按钮
                    {
						file=fileChooser.getSelectedFile();
						writeFile(file,textArea.getText());
						Carbon=textArea.getText();
                        NotePad.this.setTitle(file.getName() + " - 记事本");

					}
				}
				else if(file!=null)
				{
					writeFile(file,textArea.getText());
					Carbon=textArea.getText();
				}

			}
            if (command == "另存为(A)...") {
				int value=fileChooser.showSaveDialog(NotePad.this);
                if (value == JFileChooser.APPROVE_OPTION)    //点击fileChooser中的保存按钮
                {
					file=fileChooser.getSelectedFile();
					writeFile(file,textArea.getText());
					Carbon=textArea.getText();
                    NotePad.this.setTitle(file.getName() + " - 记事本");
                }
			}
            if (command == "退出(X)") {
				int value;
                if (Carbon.equals(textArea.getText()))        //当副本与文本域文字相同时候
                    System.exit(0);
				else
				{
					if(file!=null)
                        value = JOptionPane.showOptionDialog(NotePad.this, "是否将更改保存到" + file.getPath() + "?", "记事本",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"保存(S)", "不保存(N)", "取消"}, "保存(S)");
                    else
                        value = JOptionPane.showOptionDialog(NotePad.this, "是否将更改保存到 无标题?", "记事本",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"保存(S)", "不保存(N)", "取消"}, "保存(S)");
                    if(value==0)
						SaveMenuItem.doClick();
					else if(value==1)
						System.exit(0);
					else if(value==2)
						{}
				}
			}
            if (command == "撤销(U)") {

				if (undoManager.canUndo())
					undoManager.undo();
				else
                    JOptionPane.showMessageDialog(null, "不 可 撤 销 !", "Warning", JOptionPane.WARNING_MESSAGE);

			}
            if (command == "重做(R)") {
				if (undoManager.canRedo())
					undoManager.redo();
				else
                    JOptionPane.showMessageDialog(null, "不 可 重 做 !", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            if (command == "剪切(T)") {
				textArea.cut();
			}
            if (command == "复制(C)") {
				textArea.copy();
			}
            if (command == "粘贴(P)") {
				textArea.paste();
			}
            if (command == "删除(L)") {
				textArea.replaceSelection("");
			}
            if (command == "查找(F)...") {
				foundDialog.setVisible(true);
			}
            if (command == "替换(R)...") {
				replaceDialog.setVisible(true);
			}

            if (command == "全选(A)") {
				textArea.selectAll();
			}
            if (command == "时间/日期(D)") {
                SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        //格式化日期
                String Date = Format.format(new Date());        //new一个Date()类，并格式化为String类
                if(textArea.getSelectedText()==null)
					textArea.insert(Date, textArea.getCaretPosition());
				else
					textArea.replaceSelection(Date);
			}
            if (command == "自动换行(W)") {
				if(LineWrapMenuItem.isSelected())
					textArea.setLineWrap(true);
				else
					textArea.setLineWrap(false);
			}
            if (command == "字体(F)...") {
				fontDialog.setVisible(true);
				for(int i=0; i<fontDialog.ListName.getItemCount(); i++)
				{
					if(textArea.getFont().getFamily().equals(fontDialog.ListName.getItem(i)))
						fontDialog.ListName.select(i);
				}
				for(int i=0; i<fontDialog.ListStyle.getItemCount(); i++)
					if(textArea.getFont().getStyle()==i)
						fontDialog.ListStyle.select(i);
				for(int i=0; i<fontDialog.ListSize.getItemCount(); i++)
				{
					if(String.valueOf(textArea.getFont().getSize()).equals(fontDialog.ListSize.getItem(i)))
						fontDialog.ListSize.select(i);
				}
				fontDialog.DemoArea.setFont(new Font(fontDialog.ListName.getSelectedItem(),
				                                     fontDialog.ListStyle.getSelectedIndex(),Integer.parseInt(fontDialog.ListSize.getSelectedItem())));
			}
            if (command == "关于记事本(A)") {
				aboutDialog.setVisible(true);
			}
		}
	}							////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String readFile(File f)
	{
		String fileContent="";
		try
		{
			InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk");
			BufferedReader reader=new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null)
			{
				fileContent += line+"\r\n";
			}
			fileContent=fileContent.substring(0,fileContent.length()-2);
			read.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return fileContent;
	}
	public static void writeFile(File f, String fileContent)
	{
		try
		{
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f),"gbk");
			BufferedWriter writer=new BufferedWriter(write);
			writer.write(fileContent);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void UpSearch(String object,Boolean Check)
	{
		String str=textArea.getText();
		int CaretPosition=textArea.getCaretPosition();
        String text = object;            //当查找不到时，需要记录改变大小写之前的object信息以便显示
        if (!Check)        //每次都要判断"区分大小写"复选框的选中情况
        {
			object=object.toUpperCase();
			str=str.toUpperCase();
		}
        System.out.println("区分大小写:" + Check);
        if(textArea.getSelectionStart()==(CaretPosition-object.length())&&textArea.getSelectionEnd()==CaretPosition)
		{
			CaretPosition-= (object.length() + 1);
            //lastIndexOf返回指定子字符串在此字符串中最右边出现处的索引。因此字符串长度+1
            //(其实可以为CaretPosition=CaretPosition-1-1,不过因为要选取指定结果字符串放弃)
        }
		position=str.lastIndexOf(object,CaretPosition);
        System.out.println("代进计算的光标位置:" + CaretPosition);
        System.out.println("计算字符位置:" + position);
        System.out.println("光标位置:" + textArea.getCaretPosition());
        System.out.println("字符所在位置:" + position);
        if(position==-1)
            JOptionPane.showMessageDialog(this, "找不到" + text + "", "记事本", JOptionPane.INFORMATION_MESSAGE);
        else
		{
			textArea.select(position,object.length()+position);
            System.out.println("end后光标位置:" + textArea.getCaretPosition() + "\n");
        }
	}
	public void DownSearch(String object,Boolean Check)
	{
		String str=textArea.getText();
		int CaretPosition=textArea.getCaretPosition();
		String text=object;
        if (!Check)        //每次都要判断"区分大小写"复选框的选中情况
        {
			object=object.toUpperCase();
			str=str.toUpperCase();
		}
        System.out.println("区分大小写:" + Check);
        //在计算出索引位置，执行select()方法后，光标位置==SelectionEnd()的位置，因此不用改变光标数值以此方便indexOf()的计算
        position=str.indexOf(object,CaretPosition);
        System.out.println("代进计算的光标位置:" + CaretPosition);
        System.out.println("计算字符位置:" + position);
        System.out.println("光标位置:" + textArea.getCaretPosition());
        System.out.println("字符所在位置:" + position);
        if(position==-1)
            System.out.println();
//            JOptionPane.showMessageDialog(this, "找不到\"" + text + "\"", "记事本", JOptionPane.INFORMATION_MESSAGE);
        else
		{
			textArea.select(position,object.length()+position);
            System.out.println("end后光标位置:" + textArea.getCaretPosition() + "\n");
        }
	}

	class FontDialog extends JDialog implements ActionListener,ItemListener
	{
		JDialog FontDialog;
		List ListName,ListStyle,ListSize;
		int FontName,FontStyle,FontSize;
		JPanel jp;
		JButton OK,Cancel;
		JTextArea DemoArea;
		JLabel LabelName,LabelStyle,LabelSize;
		JTextField NameField,StyleField,SizeField;
		public FontDialog(JFrame owner)
		{
            super(owner, "字体", false);
            GraphicsEnvironment AllFont=GraphicsEnvironment.getLocalGraphicsEnvironment();
			String Name[]=AllFont.getAvailableFontFamilyNames();
            String Style[] = {"常规", "粗体", "倾斜", "粗偏斜体"};
            String Size[]=new String[48];
			for(int i=0; i<48; i++)
				Size[i]=i+8+"";
			ListName=new List();
			ListName.setFont(font);
			ListName.addItemListener(this);
			ListStyle=new List();
			ListStyle.setFont(font);
			ListStyle.addItemListener(this);
			ListSize=new List();
			ListSize.setFont(font);
			ListSize.addItemListener(this);
			for(int i=0; i<Name.length; i++)
			{
				ListName.add(Name[i]);
				if(textArea.getFont().getFamily().equals(Name[i]))
					ListName.select(i);
			}
			for(int i=0; i<Style.length; i++)
				ListStyle.add(Style[i]);
			for(int i=0; i<Style.length; i++)
				if(textArea.getFont().getStyle()==i)
					ListStyle.select(i);
			for(int i=0; i<Size.length; i++)
			{
				ListSize.add(Size[i]);
				if(String.valueOf(textArea.getFont().getSize()).equals(Size[i]))
					ListSize.select(i);
			}
            LabelName = new JLabel("字体(F)");
            LabelName.setFont(font);
            LabelStyle = new JLabel("字形(Y)");
            LabelStyle.setFont(font);
            LabelSize = new JLabel("大小(S)");
            LabelSize.setFont(font);
			NameField=new JTextField(10);
			NameField.setFont(font);
			StyleField=new JTextField(10);
			StyleField.setFont(font);
			SizeField=new JTextField(10);
			SizeField.setFont(font);
            DemoArea = new JTextArea("微软中文软件\nAaBbCc 012345");
            OK = new JButton("确定");
            OK.addActionListener(this);
			OK.setFont(font);
            Cancel = new JButton("取消");
            Cancel.addActionListener(this);
			Cancel.setFont(font);
			jp=new JPanel();
            jp.setBorder(BorderFactory.createTitledBorder(null, "示例", TitledBorder.LEFT, TitledBorder.TOP, font));
            jp.setLayout(new BorderLayout());
			this.setLayout(null);
			this.setVisible(false);
			DemoArea.setSize(380,180);
			DemoArea.setOpaque(false);
			DemoArea.setEditable(false);
			NameField.setText(ListName.getSelectedItem());
			StyleField.setText(ListStyle.getSelectedItem());
			SizeField.setText(ListSize.getSelectedItem());
			this.setBounds(10,10,600,600);
			LabelName.setBounds(20,20,260,30);
			NameField.setBounds(20,50,260,30);
			ListName.setBounds(20,80,260,150);
			LabelStyle.setBounds(300,20,150,30);
			StyleField.setBounds(300,50,150,30);
			ListStyle.setBounds(300,80,150,150);
			LabelSize.setBounds(470,20,80,30);
			SizeField.setBounds(470,50,80,30);
			ListSize.setBounds(470,80,80,150);
			jp.setBounds(150,250,400,200);
			OK.setBounds(330,490,100,40);
			Cancel.setBounds(450,490,100,40);
			this.add(LabelName);
			this.add(NameField);
			this.add(ListName);
			this.add(LabelStyle);
			this.add(StyleField);
			this.add(ListStyle);
			this.add(LabelSize);
			this.add(SizeField);
			this.add(ListSize);
			this.add(jp);
			this.add(OK);
			this.add(Cancel);
			jp.add(DemoArea,BorderLayout.CENTER);
		}
		public void actionPerformed(ActionEvent e)
		{
            if (e.getActionCommand() == "确定") {
				textArea.setFont(DemoArea.getFont());
				this.setVisible(false);
			} else if (e.getActionCommand() == "取消")
                this.setVisible(false);
		}
		public void itemStateChanged(ItemEvent e)
		{
			NameField.setText(ListName.getSelectedItem());
			StyleField.setText(ListStyle.getSelectedItem());
			SizeField.setText(ListSize.getSelectedItem());
			DemoArea.setFont(new Font(ListName.getSelectedItem(),ListStyle.getSelectedIndex()
			                          ,Integer.parseInt(ListSize.getSelectedItem())));
		}
	}

	class ReplaceDialog extends JDialog implements ActionListener
	{
		JDialog ReplaceDialog;
		JCheckBox checkBox;
		JLabel ReplaceLabel,FoundLabel;
		JTextField FoundText,ReplaceText;
		JButton ReplaceButton,ReplaceAllButton;
		JButton NextButton,Cancel;
		public ReplaceDialog(JFrame owner)
		{
            super(owner, "替换", false);
            ReplaceLabel = new JLabel("替换为(P):");
            ReplaceLabel.setFont(font);
            FoundLabel = new JLabel("查找内容(N):");
            FoundLabel.setFont(font);
			FoundText=new JTextField(20);
			FoundText.setFont(font);
			ReplaceText=new JTextField(20);
			ReplaceText.setFont(font);
            ReplaceButton = new JButton("替换(R)");
            ReplaceButton.setFont(font);
            ReplaceAllButton = new JButton("全部替换(A)");
            ReplaceAllButton.setFont(font);
            NextButton = new JButton("查找下一个(F)");
            NextButton.setFont(font);
            checkBox = new JCheckBox("区分大小写(C)");
            checkBox.setFont(font);
            Cancel = new JButton("取消");
            Cancel.setFont(font);
			this.setFont(font);
			this.setVisible(false);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setLayout(null);
			this.setBounds(10,10,600,280);
			FoundLabel.setBounds(20,15,100,40);
			ReplaceLabel.setBounds(20,60,100,40);
			FoundText.setBounds(140,30,280,30);
			ReplaceText.setBounds(140,70,280,30);
			checkBox.setBounds(20,170,150,30);
			NextButton.setBounds(440,20,130,35);
			ReplaceButton.setBounds(440,70,130,35);
			ReplaceAllButton.setBounds(440,120,130,35);
			Cancel.setBounds(440,170,130,35);
			this.add(FoundLabel);
			this.add(ReplaceLabel);
			this.add(FoundText);
			this.add(ReplaceText);
			this.add(checkBox);
			this.add(NextButton);
			this.add(ReplaceButton);
			this.add(ReplaceAllButton);
			this.add(Cancel);
            NextButton.addActionListener(this);        //监听按钮
            ReplaceButton.addActionListener(this);
			ReplaceAllButton.addActionListener(this);
			Cancel.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e)
		{
            if (e.getActionCommand() == "查找下一个(F)") {
				DownSearch(FoundText.getText(),checkBox.isSelected());
			}
            if (e.getActionCommand() == "替换(R)") {
				String SelectedText=textArea.getSelectedText();
				if(SelectedText!=null&&SelectedText.equals(FoundText.getText()))
				{
					textArea.replaceSelection(ReplaceText.getText());
					DownSearch(FoundText.getText(),checkBox.isSelected());
				}
				else
				{
					DownSearch(FoundText.getText(),checkBox.isSelected());
					textArea.replaceSelection(ReplaceText.getText());
                    System.out.println("替换后光标位置:" + textArea.getCaretPosition());
                    DownSearch(FoundText.getText(),checkBox.isSelected());
				}
			}
		}
	}
	class FoundDialog extends JDialog implements ActionListener
	{
		JLabel FoundLabel;
		JTextField FoundText;
		JCheckBox checkBox;
		JRadioButton UpButton;
		JRadioButton DownButton;
		ButtonGroup grp;
		JButton NextButton,Cancel;
		JPanel jp;
		public FoundDialog(JFrame owner)
		{
            super(owner, "查找", false);
            FoundLabel = new JLabel("查找内容(N):");
            FoundLabel.setFont(font);
			FoundText=new JTextField(20);
			FoundText.setFont(font);
            checkBox = new JCheckBox("区分大小写(C)");
            checkBox.setFont(font);
            UpButton = new JRadioButton("向上(U)");
            UpButton.setFont(font);
            DownButton = new JRadioButton("向下(D)", true);
            DownButton.setFont(font);
			grp=new ButtonGroup();
            NextButton = new JButton("查找下一个(F)");
            NextButton.setFont(font);
            Cancel = new JButton("取消");
            Cancel.setFont(font);
			jp=new JPanel();
			jp.setFont(font);
			this.setFont(font);
			this.setVisible(false);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jp.setBorder(BorderFactory.createTitledBorder(null, "方向", TitledBorder.LEFT, TitledBorder.TOP, font));
            //设置面板标题边框，指定位置和字体
            this.setLayout(null);
			this.setBounds(10,10,600,200);
			FoundLabel.setBounds(20,15,100,40);
			FoundText.setBounds(140,20,280,30);
			checkBox.setBounds(20,90,150,30);
			jp.setBounds(210,60,200,70);
			NextButton.setBounds(440,20,130,35);
			Cancel.setBounds(440,70,130,35);
			this.add(FoundLabel);
			this.add(FoundText);
			this.add(checkBox);
			this.add(jp);
			jp.add(UpButton,BorderLayout.WEST);
			jp.add(DownButton,BorderLayout.EAST);
			grp.add(UpButton);
			grp.add(DownButton);
			this.add(NextButton);
			this.add(Cancel);
            NextButton.addActionListener(this);        //监听按钮
            Cancel.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e)
		{
            if (e.getActionCommand() == "查找下一个(F)") {
				if(UpButton.isSelected())
					UpSearch(FoundText.getText(),checkBox.isSelected());
				else
					DownSearch(FoundText.getText(),checkBox.isSelected());
			} else if (e.getActionCommand() == "取消")
                this.setVisible(false);

		}
	}
	class AboutDialog extends JDialog
	{
		public JButton OK;
		public JLabel Windows;
		public JTextArea ta;
		public AboutDialog(JFrame owner)
		{
            super(owner, "关于记事本", false);
            OK = new JButton("确定");
            Windows=new JLabel("Windows10");
            Windows.setFont(new Font("微软雅黑", Font.PLAIN, 50));
            Windows.setForeground(new Color(65,105,225));
            ta = new JTextArea("Microsoft Windows\nNotePad\n版本1.0\nCopyright (c) 16/7/30 by pokedo");
            ta.setForeground(Color.black);
			ta.setOpaque(false);
			ta.setEditable(false);
			this.setLayout(null);
			this.setResizable(false);
			this.setVisible(false);
			this.setBounds(10,10,600,400);
			Windows.setBounds(200,20,500,100);
			ta.setBounds(50,120,500,150);
			OK.setBounds(450,300,100,35);
			this.add(Windows);
			this.add(ta);
			this.add(OK);
		}
	}

	public static void main(String args[])
	{
        NotePad frm = new NotePad("无标题 - 记事本");
        frm.setVisible(true);
	}

}