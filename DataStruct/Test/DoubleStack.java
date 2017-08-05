package DataStruct.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pokedo on 2017/4/10.
 */
public class DoubleStack
{
    //该栈用于存储double类型的数值
    private Stack<Double> numberStack=new Stack<Double>();
    //该栈用于存储String类型的操作数
    private Stack<String> operatorStack=new Stack<String>();
    //该符号表用于定义运算符的优先级
    private Map<String,Integer> table=getMap();
    /**
     * 该方法用于实现从标准输入流中获得一个字符串
     * @return 获得的字符串
     */
    public String getInput()
    {
        System.out.print("请输入一个中序表达式:");
        Scanner in =new Scanner(System.in);
        String input=in.nextLine();
        return input;
    }
    /**
     * 该方法用于去除字符串中的空白符
     * @param input 要去除空白符的字符串
     * @return 去除了空白符之后的字符串
     */
    public String deleteBlank(String input)
    {
        return input.replaceAll(" ", "");
    }
    /**
     * 该方法用于实现使用双栈法进行表达式的计算
     */
    public double counter(String input)
    {
        //用于组装数字，将其组装成正确的数字
        String n="";
        //遍历所输入的字符串
        for(int i=0;i<input.length();i++)
        {
            //得到当前字符串中的字符
            String ch=String.valueOf(input.charAt(i));
            //当为数字的时候，对其进行组装，将其组装成字符串
            if(ch.matches("[0-9\\.]"))
            {
                n+=ch;
            }
            //当其为运算符的时候，将前面组装好的数字字符串转化为数字，并压入栈中
            else
            {

                if(!n.equals(""))
                {
                    numberStack.push(Double.parseDouble(n));
                    n="";
                }
                //当操作数栈中不为空的时候,并且当前操作符不是左括号的时候,对运算符进行判断并做出相应的计算
                if (!operatorStack.isEmpty() && !ch.matches("[(（]"))
                {
                    //当当前操作符不是右括号的时候
                    if (!ch.matches("[)）]"))
                    {
                        //获取栈顶元素
                        String top=operatorStack.getTop();
                        //当栈顶元素为左括号时,逃过其比较
                        if (!top.matches("[(（]"))
                        {
                            //操作数栈中的操作数的优先级大于等于当前操作数的优先级时，进行运算
                            while(!operatorStack.isEmpty()&&table.get(top)>=table.get(ch))
                            {
                                counterShell(operatorStack.pop());
                                if(!operatorStack.isEmpty())
                                {
                                    top=operatorStack.getTop();
                                }
                            }
                        }
                        operatorStack.push(ch);
                    }
                    //当当前的操作符为右括号的时候，对其进行运算操作直至弹出的操作符为左括号
                    else
                    {
                        String pop=operatorStack.pop();
                        while (!pop.matches("[(（]"))
                        {
                            counterShell(pop);
                            pop=operatorStack.pop();
                        }
                    }
                }
                else
                {
                    operatorStack.push(ch);
                }
            }
        }
        //对运算的最后一个数压入数字栈中
        if(!n.equals(""))
        {
            numberStack.push(Double.parseDouble(n));
        }
        //当操作数栈中的内容不为空时，对其进行运算
        while(!operatorStack.isEmpty())
        {
            counterShell(operatorStack.pop());
        }
        return numberStack.pop();
    }
    /**
     *
     * 该方法用于根据传入的操作符进行相应的计算,并将其运算结果压入操作数栈中
     * @param op 传入的操作符
     * @return 进行计算的结果
     *
     */
    private void counterShell(String op)
    {
        double result=0.0;
        switch(op)
        {
            case "×":
            case "*":
            {
                double two=numberStack.pop();
                double one=numberStack.pop();
                result=one*two;
                break;
            }
            case "÷":
            case "/":
            {
                double two=numberStack.pop();
                double one=numberStack.pop();
                result=one/two;
                break;
            }
            case "+":
            {
                double two=numberStack.pop();
                double one=numberStack.pop();
                result=one+two;
                break;
            }
            case "-":
            {
                double two=numberStack.pop();
                double one=numberStack.pop();
                result=one-two;
                break;
            }
        }
        numberStack.push(result);
    }

    /**
     * 该方法用于实现一个符号表
     * @return
     */
    private static Map<String,Integer> getMap()
    {
        Map<String,Integer> temp=new HashMap<String,Integer>();
        //定义各个运算符的优先级,其中，x和÷字符用于兼容
        temp.put("*", 2);
        temp.put("/", 2);
        temp.put("×", 2);
        temp.put("÷", 2);
        temp.put("+", 1);
        temp.put("-",1);
        return temp;
    }
    /**
     * 该方法用于整合以上各个方法，用于提供一个对外的接口
     */
    public void arrange()
    {
        String input=getInput();
        input =deleteBlank(input);
        System.out.print("运行结果为:" + counter(input));
    }
}

