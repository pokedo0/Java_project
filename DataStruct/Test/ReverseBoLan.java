package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 该类用于实现中序表达式转为后序表达式并进行运算的封装
 * 即逆波兰算法的类的封装
 * @author 学徒
 *
 */
public class ReverseBoLan
{
    //该符号表用于定义运算符的优先级
    private Map<String,Integer> table=getMap();
    //该字符串为用于匹配数字的
    private String rexNumber="\\d+";
    private String rexOperator = "[(（+\\-*/×÷）)]";
    //该字符串为用户输入的中序表达式
    private String input;
    //该栈对象用于存储运算符和括号(左括号)
    private Stack<String> save=new Stack<String>();
    /**
     * 该方法用于将中序表达式转化为后序表达式，并对其转化后的表达式以字符串的形式进行返回
     * @return 后序表达式
     */
    public String reverse()
    {
        //result变量用于存储结果
        String result="";
        //将输入的中序表达式中的数字存储到number数组中
        String[] number=input.split(rexOperator);
        int order=0;
        int i=0;
        while(i<input.length())
        {
            //获得当前字符
            String thisString=String.valueOf(input.charAt(i));
            //当前该字符为运算符或者括号时,即当前该字符不为数字时
            if(thisString.matches(rexOperator))
            {
                //当当前字符不为左括号或者右括号时(即为运算符)
                if (!thisString.matches("[()（）]"))
                {
                    //用于记录栈顶元素的优先级
                    int temporary=0;
                    //获取当前字符的优先级
                    int present=table.get(thisString);
                    //当操作数的栈不为空的时候
                    if(!save.isEmpty())
                    {
                        //查看栈顶元素的字符以及其优先级
                        String top=save.getTop();
                        if (!top.matches("[(（]"))
                        {
                            temporary=table.get(top);
                        }
                    }
                    //当栈顶元素的操作符的优先级比当前操作符的优先级还要高或者相同时，对其进行弹出操作，直到栈顶元素的优先级比当前操作符的优先级要低
                    if(temporary>=present)
                    {
                        while(!save.isEmpty()&&table.get(save.getTop())>=present)
                        {
                            result+=" "+save.pop();
                        }
                    }
                    save.push(thisString);
                }
                //当当前的字符为左括号的时候，直接将其压入栈中
                else if (thisString.matches("[(（]"))
                {
                    save.push(thisString);
                }
                //当当前的字符为右括号的时候，将其栈中的元素一直弹出，直至遇到左括号结束，并将左括号弹出
                else
                {
                    while (!save.getTop().matches("[(（]"))
                        result+=" "+save.pop();
                    save.pop();
                }
                i++;
            }
            //当前该字符为数字的时候
            if(thisString.matches(rexNumber))
            {
                //用于存储数字数组中的数字字符串
                String numberString=null;
                do
                {
                    numberString=number[order];
                    //当数字字符串中的数字不为空时(由于可能会是空字符串的出现)，将整个中序表达式的字符串的指针进行向右移动
                    if(!numberString.trim().equals(""))
                    {
                        i+=numberString.length();
                        order++;
                        break;
                    }
                    else
                    {
                        order++;
                    }
                }while(true);
                result+=" "+numberString;
            }
        }
        //将栈中剩余的字符进行弹出
        while(!save.isEmpty())
        {
            result+=" "+save.pop();
        }
        return result;
    }
    /**
     * 该方法用于设置实例变量input的值
     * @param input 为中序表达式
     */
    public void setInput(String input)
    {
        //去掉输入的字符串中存在的所有的空字符
        input=input.replaceAll(" ", "");
        //去掉中序表达式字符串中各种杂七杂八的字符
        input = input.replaceAll("[^+\\-*/×÷\\.\\d()（）]", "");
        this.input=input;
    }
    /**
     * 该方法用于将后序表达式的结果进行计算，得出其最终结果
     * 返回最终计算的结果。
     * 输入的参数为前面带空格的，数字和运算符之间带空格的后序表达式
     *
     */

    public double counter(String input)
    {
        //去掉其首尾空格
        input=input.trim();
        //该栈用于存储下数字
        Stack<String> numbers=new Stack<String>();
        //用于记录下数字使用
        String n="";
        //用于循环遍历每一个字符
        for(int i=0;i<input.length();i++)
        {
            String ch=String.valueOf(input.charAt(i));
            //当前的字符为空字符的时候，遍历下一个字符
            if(ch.equals(" "))
            {
                //将数字字符串存入栈中并遍历下一个字符
                numbers.push(n);
                n="";
                continue;
            }
            //当为数字的时候，对其进行组装，将其组装成字符串
            else if(ch.matches("[0-9\\.]"))
            {
                n+=ch;
            }
            //当其为运算符的时候，对其栈中的前两个数字字符串进行弹出，并将运算结果压入栈中
            else
            {
                switch(ch)
                {
                    case "×":
                    case "*":
                    {
                        double two=Double.parseDouble(numbers.pop());
                        double one=Double.parseDouble(numbers.pop());
                        double result=one*two;
                        n=String.valueOf(result);
                        break;
                    }
                    case "÷":
                    case "/":
                    {
                        double two=Double.parseDouble(numbers.pop());
                        double one=Double.parseDouble(numbers.pop());
                        double result=one/two;
                        n=String.valueOf(result);
                        break;
                    }
                    case "+":
                    {
                        double two=Double.parseDouble(numbers.pop());
                        double one=Double.parseDouble(numbers.pop());
                        double result=one+two;
                        n=String.valueOf(result);
                        break;
                    }
                    case "-":
                    {
                        double two=Double.parseDouble(numbers.pop());
                        double one=Double.parseDouble(numbers.pop());
                        double result=one-two;
                        n=String.valueOf(result);
                        break;
                    }
                }
            }
        }
        //将最后计算的结果放入栈中
        numbers.push(n);
        double result=Double.parseDouble(numbers.pop());
        return result;
    }

    //该方法用于实现一个符号表
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
}

