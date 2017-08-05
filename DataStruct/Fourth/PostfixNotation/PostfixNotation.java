package DataStruct.Fourth.PostfixNotation;

import DataStruct.Fourth.Stack;

import java.math.BigDecimal;
import java.util.HashMap;

public class PostfixNotation {
    //分配符号优先级
    static HashMap<String, Integer> map = new HashMap<>();
    //判断是否为运算符数据
    static String[] test = {"+", "-", "*", "/", "%", "(", ")"};

    public static void main(String args[]) {
        String s = "(5-(3-5 * 2))";
        System.out.print(s + " = ");
        map.put("(", 0);
        map.put(")", 1);
        map.put("+", 2);
        map.put("-", 2);
        map.put("*", 3);
        map.put("/", 3);
        map.put("%", 3);
        double res = 0;
        try {
            Stack<String> stack = Reverse(s);
            res = Calculate(stack);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nException:(Here are some reasons)");
            System.out.println("1.输入格式不对");
            System.out.println("2.暂不支持负数写法，如-5,-2");
            System.out.println("2.被除数不能为0");
        }
        System.out.println(res);
    }

    /***
     * @param s 需要计算的字符串
     * @return 一个包含后缀表达式的栈
     */
    private static Stack<String> Reverse(String s) {
        Stack<String> val = new Stack<>();
        Stack<String> opt = new Stack<>();
        //i用于遍历s所有字符
        int i = 0;
        //sb用于合并运算符之间的操作数
        StringBuilder sb = new StringBuilder("");
        //x是s的每个单个字符串
        String x = null;
        while (i != s.length()) {
            x = String.valueOf(s.charAt(i));
            //当x为数字
            if (!isOperator(x)) {
                //只有当x为运算符时候才跳出循环
                while (!isOperator(x)) {
                    sb.append(x);
                    i++;
                    if (i == s.length())
                        break;
                    x = String.valueOf(s.charAt(i));
                }
                //val栈push一个完整的数字
                val.push(new String(sb));
                //重置sb的值
                sb = new StringBuilder("");
            }
            //当x为运算符时
            if (isOperator(x)) {
                //如果opt栈为空，运算符直接入栈
                if (opt.isEmpty())
                    opt.push(x);
                    //如果opt栈非空
                else {
                    //x为"("，直接入栈
                    if (x.equals("("))
                        opt.push(x);
                        //其他情况按照优先级来入栈，出栈
                    else {
                        while (!opt.isEmpty() && map.get(x) <= map.get(opt.peek()))
                            val.push(opt.pop());
                        opt.push(x);
                    }
                    //当x为")"时，按照优先级的方式处理是，直到栈顶遇到了"("，")"就入栈，
                    // 因此此时栈顶为")"，所以需要pop()掉"("和")"
                    if (opt.peek().equals(")")) {
                        opt.pop();
                        opt.pop();
                    }
                }
                i++;
            }
            //遍历完s，opt栈还有剩余元素，全部入栈到val
            if (i == s.length() && !opt.isEmpty()) {
                while (!opt.isEmpty())
                    val.push(opt.pop());
            }
        }
        //逆向返回一个后缀栈，因为之前val保存的后缀表达式栈的元素是逆序的。
        while (!val.isEmpty())
            opt.push(val.pop());
        return opt;
    }

    /**
     * @param x 需要判断的字符串
     * @return 当为运算符时返回true，否则false
     */
    private static boolean isOperator(String x) {
        for (String s : test)
            if (x.equals(s))
                return true;
        return false;
    }

    /**
     * @param stack 传入一个后缀表达式的栈
     * @return 返回最后结果
     */
    private static double Calculate(Stack<String> stack) {
        //val栈，用于计算
        Stack<Double> val = new Stack<>();
        BigDecimal a;
        BigDecimal b;
        //当后缀表达式的栈不为空的时候
        while (!stack.isEmpty()) {
            String x = stack.peek();
            //当x不为运算符，直接进栈val
            if (!isOperator(x))
                val.push(Double.valueOf(stack.pop()));
                //当x为运算符，从val栈pop()出两个数后进行计算，再push()回去
            else {
                b = BigDecimal.valueOf(val.pop());
                a = BigDecimal.valueOf(val.pop());
                switch (x) {
                    case "+":
                        val.push(a.add(b).doubleValue());
                        break;
                    case "-":
                        val.push(a.subtract(b).doubleValue());
                        break;
                    case "*":
                        val.push(a.multiply(b).doubleValue());
                        break;
                    case "/":   //四舍五入
                        val.push(a.divide(b, 5, BigDecimal.ROUND_HALF_EVEN).doubleValue());
                        break;
                    case "%":
                        val.push(a.doubleValue() % b.doubleValue());
                        break;
                }
                stack.pop();
            }
        }
        return val.pop();
    }
}
