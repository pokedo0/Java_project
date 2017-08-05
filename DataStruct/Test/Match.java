package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
import java.util.Scanner;

/**
 * 该类用于实现对括号的匹配问题的操作
 * 用于判断输入的括号是否匹配的问题
 * @author 学徒
 *
 */

public class Match
{
    public void matchesSymbol()
    {
        boolean match=false;
        Stack<String> stack=new Stack<String>();
        System.out.print("请输入一系列括号:");
        String inputString=null;
        while(true)
        {
            inputString=getInputString();
            if(inputString==null||deleteBlank(inputString).equals(""))
            {
                System.out.print("请输入一系列括号:");
                continue;
            }
            else
            {
                break;
            }
        }
        //去除空字符
        inputString=deleteBlank(inputString);
        //当括号成对出现的时候
        if(inputString.length()%2==0)
        {
            match=true;
            for(int i=0;i<inputString.length();i++)
            {
                //当为左括号时，将其压入栈中,否则将从栈中弹出
                if (String.valueOf(inputString.charAt(i)).matches("[（(\\[{【]"))
                {
                    stack.push(String.valueOf(inputString.charAt(i)));
                }
                else
                {
                    if(!stack.isEmpty())
                    {
                        String value=stack.pop();
                    }
                    else
                    {
                        match=false;
                        break;
                    }
                }
            }
        }
        if(!match||!stack.isEmpty())
        {
            System.out.println("括号不匹配");
        }
        else
        {
            System.out.println("括号匹配成功");
        }
    }

    //该方法用于获得输入的字符串
    private  String getInputString()
    {
        Scanner in =new Scanner(System.in);
        String str=null;
        if(in.hasNextLine())
        {
            str=in.nextLine();
        }
        return str;
    }

    //该方法用于对输入的字符串进行去除空字符的处理
    private String deleteBlank(String inputString)
    {
        inputString=inputString.replaceAll(" ", "");
        return inputString;
    }
}
