package Calculate;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
public class Calculate extends JFrame		//???JFrame??
{
	static JPanel pan_text=new JPanel();				//????pan_text???????????????
	static JPanel pan_button=new JPanel();				//????pan_button???????????
	static JTextField uptext=new JTextField("",30);		//?????????uptext??????????????????30?????
	static JLabel downtext=new JLabel("0");				//???????downtext?????????????????????????"0"
    static Font butfont = new Font("console", Font.PLAIN, 20);   //???????з╤??????
    static double result = 0;                            //????result?????????ж═?????????????0
    static boolean numstart = true;                    //?з╪??????????????????
    static boolean expression_exit = false;            //?з╪??????????????,??logX,??X,sin(x) ??
    static boolean firstcal = true;                    //?????з╪??????????????????"C"??????"="?????????ж╠???
    static String lastcommand;						//??????????????
	static String downlast;							//????downlast?????? ??????? ???????????
	static String example;
	static int leftcount=0;
	static int rightcount=0;
	static String lastone;
	
	//*********?????????????Calculate????
	public static void main(String[] args)		
	{
		Calculate frm=new Calculate();		
	}


    //*********************************??ж═??????****************************************
    //*********************************??ж═??????****************************************
    //*********************************??ж═??????****************************************
    //*********????Calculate????????????JFrame???????JFrame??????
	public Calculate()
	{
		example="-+????%";
		//????frm???
		setLayout(null);				//????frm???????null
        setSize(450, 560);                //frm??з│
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
        setResizable(false);            //frm?????????з│
        GridBagConstraints Constraints=new GridBagConstraints();		//???????????????? ????
		Constraints.fill=GridBagConstraints.BOTH;		//????????????????
        Constraints.anchor = GridBagConstraints.CENTER;    //?????????????????зр???

        //??????????????НJ??pan_text
        pan_text.setBounds(30,10,385,130);		//???????????????
		pan_text.setBorder(BorderFactory.createLineBorder(new Color(142,156,173)));		//??????????
		pan_text.setLayout(new BorderLayout());			//???????? ?????????
		Font up=new Font("console",Font.PLAIN,30);		//????????????????
        Font down = new Font("console", Font.BOLD, 50);        //??????????б└?????
        uptext.setFont(up);
		uptext.setHorizontalAlignment(JLabel.RIGHT);	//???????????????
		uptext.setBorder(null);							//?????????????????
		uptext.setOpaque(false);						//????????????
		downtext.setFont(down);
		downtext.setHorizontalAlignment(JLabel.RIGHT);	//???????????????
        pan_text.add(uptext, BorderLayout.NORTH);        //?????????? ?? ж╦??
        pan_text.add(downtext, BorderLayout.SOUTH);        //?????????? ?? ж╦??
        add(pan_text);
		add(pan_button);

        //????????НJ??
        pan_button.setLayout(new GridBagLayout());		//??????????????????
		pan_button.setBounds(20,160,400,350);			//????????????????
		InsertAction Insert=new InsertAction();			
		OperateSign Sign=new OperateSign();

	/*	addPan("n!",pan_button,Constraints, 0, 5, 1, 1,OtherSign);		//??????????????????????????????..
		addPan("10^x",pan_button,Constraints, 1, 5, 1, 1,OtherSign);
		addPan("x^2",pan_button,Constraints, 2, 5, 1, 1,OtherSign);
		addPan("x^y",pan_button,Constraints, 3, 5, 1, 1,OtherSign);
		addPan("log",pan_button,Constraints, 4, 5, 1, 1,OtherSign); 
		addPan("??",pan_button,Constraints, 4, 4, 1, 1,OtherSign);
		addPan("sin",pan_button,Constraints,1,4, 1, 1,OtherSign);
		addPan("cos",pan_button,Constraints, 2, 4, 1, 1,OtherSign);
		addPan("tan",pan_button,Constraints, 3, 4, 1, 1,OtherSign);	*/
		addPan("(",pan_button,Constraints, 0, 0, 1, 1,Sign);
		addPan(")",pan_button,Constraints, 0, 1, 1, 1,Sign);
		addPan("+/-",pan_button,Constraints, 0, 2, 1, 1,Sign);
		addPan("%",pan_button,Constraints, 0, 3, 1, 1,Sign);
		addPan("CE",pan_button,Constraints, 1, 0, 1, 1,Insert);
		addPan("C",pan_button,Constraints, 1, 1, 1, 1,Insert);
		addPan("??",pan_button,Constraints, 1, 2, 1, 1,Insert);
		addPan("??",pan_button,Constraints, 1, 3, 1, 1,Sign);
		addPan("??",pan_button,Constraints, 2, 3, 1, 1,Sign);
		addPan("-",pan_button,Constraints, 3, 3, 1, 1,Sign);
		addPan("+",pan_button,Constraints, 4, 3, 1, 1,Sign);
		addPan("=",pan_button,Constraints, 5, 3, 1, 1,Sign);
		addPan(".",pan_button,Constraints, 5, 2, 1, 1,Insert);
		addPan("0",pan_button,Constraints, 5, 0, 1, 2,Insert);
		addPan("1",pan_button,Constraints, 4, 0, 1, 1,Insert);
		addPan("2",pan_button,Constraints, 4, 1, 1, 1,Insert);
		addPan("3",pan_button,Constraints, 4, 2, 1, 1,Insert);
		addPan("4",pan_button,Constraints, 3, 0, 1, 1,Insert);
		addPan("5",pan_button,Constraints, 3, 1, 1, 1,Insert);
		addPan("6",pan_button,Constraints, 3, 2, 1, 1,Insert);
		addPan("7",pan_button,Constraints, 2, 0, 1, 1,Insert);
		addPan("8",pan_button,Constraints, 2, 1, 1, 1,Insert);
		addPan("9",pan_button,Constraints, 2, 2, 1, 1,Insert);
	}

    //********?????????????????????????????┘у???????????xxxxxxxxxxx...?????????????????
    void changefont()
	{
        Font down = new Font("console", Font.BOLD, 50);            //??????????б└? ??????? ????
        Font down_after = new Font("console", Font.BOLD, 40);    //??????????б└? ???????? ????
        if (downtext.getText().length() >= 15)        //?????????15?????????з│???
            downtext.setFont(down_after);
		else
			downtext.setFont(down);
	}
	
	//*********????addPan???????????????????????
    //???????????????????????????????????з╡??з╡???????????????????????????
    public void addPan(String label,Container con,GridBagConstraints Constraints,int row,
			int col,int numberOfRow,int numberOfCol,ActionListener listener)
	{
		JButton button=new JButton(label);
        Constraints.gridy = row;                    //ж╦?????
        Constraints.gridx=col;
        Constraints.gridwidth = numberOfCol;        //?????????з│????
        Constraints.gridheight=numberOfRow;
		Constraints.weightx=10;					//???????????
		Constraints.weighty=10;
		Constraints.insets=new Insets(5,5,5,5);	//?????????
		button.addActionListener(listener);		//????????????????
		button.setFont(butfont);			//?????????
		con.add(button,Constraints);		//?????button??????????gbcon????????con(pan_button)??
	}
	
	
	
	//*******************************????????*****************************************
	//*******************************????????*****************************************
	//*******************************????????*****************************************

	//**********************??????????"C","CE","??"???????*****************
	public class InsertAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String input=e.getActionCommand();		//????input??????????????????
			int dotCount=downtext.getText().length()-downtext.getText().replace(".","").length();
			if(downtext.getText().equals(""))		//????????? ????????""??downlast????"",???????
				downlast="";		
			else
				downlast=downtext.getText().substring(downtext.getText().length()-1,downtext.getText().length());
				////downlast???? ??????? ???????????

			if(input.equals("C"))					//??input???????"C"
			{
                numstart = true;                        //numstart???true?????????????ж╠?????
                uptext.setText("");					//??????????
				downtext.setText("0");				//??????? ??????????0??
				result=0;							//??????????0
			}
			else if(input.equals("CE"))				//??input???????"CE",?????????????0???????????????
				downtext.setText("0");		
				
			else if(input.equals("??"))				//??input???????"??"
			{	
				if(downtext.getText().length()>1)	//??????????????????>1,????????????length()-1???????????					
					downtext.setText(downtext.getText().substring(0,downtext.getText().length()-1));				
				else								//??????????????????=1
					downtext.setText("0");
			}
			
			//?? "C","CE","??",???????????????????
			else
			{
                if (numstart)                    //numstart=true,???????????ж╦???????з╪??????"0","0.","????????"?????
                {
                    if (input.equals("."))        //???бу?????????"."
                        downtext.setText("0.");
					else
						downtext.setText(input);
                    numstart = false;                //??????ж╦???????numstart?false?????ж╦???????????????????????????
                }
				else	//numstart=false???
				{
					if(downtext.getText().equals("0")||downtext.getText().equals("0."))			//????????? ?"0"??"0."
					{
                        if (input.equals("0"))                            //????бу?????????"0"?????? "000000" ?????
                            downtext.setText("0");
                        else if (input.equals("."))                        //????бу?????????".",???? "0...."???
                            downtext.setText("0.");
						else if(downtext.getText().equals("0."))		//????????? ?"0.",???"0"???
                            downtext.setText(downtext.getText() + input);    //????бу?????0????
                        else
							downtext.setText(input);
					}
					else if(input.equals("."))	//????"x......"???
					{
						if(dotCount==0)
							downtext.setText(downtext.getText()+".");
						else
						{}
					}
					else			//???????????
						downtext.setText(downtext.getText()+input);
				}
			}	
			changefont();												//?????????????????	
		}
	}
	
	
	//*****************????????????*******************************
	public class OperateSign implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command=e.getActionCommand();
			if(!uptext.getText().equals(""))
				lastone=uptext.getText().substring(uptext.getText().length()-1, uptext.getText().length());
			else
				lastone="";	
			if(command.equals("+"))
			{  		
				operatorInsert("+");
			}
			else if(command.equals("-"))
			{  
				operatorInsert("-");
			}
			else if(command.equals("??"))
			{  	operatorInsert("??");
			}
			else if(command.equals("??"))
			{  	
				operatorInsert("??");
			}
			else if(command.equals("%"))
			{  	
				operatorInsert("%");
			}
			else if(command.equals("("))
			{
				if(lastone.equals(")"))
				{}
				else
				{
					uptext.setText(uptext.getText()+"(");
					downtext.setText("0");
					leftcount++;
				}
			}
			else if(command.equals(")"))
			{
				if(leftcount-rightcount>0)
					rightcount++;
				else
					return;
				if(example.indexOf(lastone)>=0||lastone.equals("("))
					uptext.setText(uptext.getText()+downtext.getText()+")");
				else
					uptext.setText(uptext.getText()+")");				
			}
			else if(command.equals("+/-"))
			{
				if(downtext.getText().substring(0,1).equals("-"))
					downtext.setText(downtext.getText().substring(1,downtext.getText().length()));
				else
					downtext.setText("-"+downtext.getText());
				return;
			}
			else if(command.equals("="))
			{
				if(example.indexOf(lastone)>=0)
					if(downtext.getText().substring(0,1).equals("-"))
						uptext.setText(uptext.getText()+"("+downtext.getText()+")");
					else
						uptext.setText(uptext.getText()+downtext.getText());
				while(leftcount-rightcount>0)
				{	
					uptext.setText(uptext.getText()+")");
					rightcount++;
				}
			}
	//		downtext.setText("0");
			numstart=true;
			changefont();	//?????????????????
			
		}
		public void operatorInsert(String operator)
		{
			if(exist()&&numstart==true)
				uptext.setText(uptext.getText().substring(0, uptext.getText().length()-1)+operator);	
			else if(lastone.equals(")"))
				uptext.setText(uptext.getText()+operator);
			else if(downtext.getText().substring(0,1).equals("-"))
				uptext.setText(uptext.getText()+"("+downtext.getText()+")"+operator);
			else
				uptext.setText(uptext.getText()+downtext.getText()+operator);
		}

        public boolean exist()    //?з╪?uptext????ж╦?????????
        {
			if(lastone.equals(""))
				return false;
			else if(example.indexOf(lastone)==-1)
				return false;
			else 
				return true;
		}
	}
}
	