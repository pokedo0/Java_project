package DataStruct.Fourth.Bracket;

import DataStruct.Fourth.Stack;

public class Bracket {
    public static void main(String args[]) {
        String s = "[ { { } } ] ( { { } } )";
        System.out.println(s);
        Stack<String> stack = new Stack<>();
        //对s字符串进行遍历
        for (String temp : s.split(" "))
            //当右括号与栈顶的符号匹配时,pop()栈顶元素，
            //否则push()右括号进去，如栈中含有右括号，最后一定不匹配
            switch (temp) {
                case "]":
                    if (stack.peek().equals("["))
                        stack.pop();
                    else
                        stack.push(temp);
                    break;
                case "}":
                    if (stack.peek().equals("{"))
                        stack.pop();
                    else
                        stack.push(temp);
                    break;
                case ")":
                    if (stack.peek().equals("("))
                        stack.pop();
                    else
                        stack.push(temp);
                    break;
                default:
                    stack.push(temp);
                    break;
            }

        if (stack.isEmpty())
            System.out.println("括号匹配！");
        else {
            System.out.println("括号不匹配！\n");
        }
    }
}
