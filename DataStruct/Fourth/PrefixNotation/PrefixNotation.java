package DataStruct.Fourth.PrefixNotation;

import DataStruct.Fourth.Stack;

import java.math.BigDecimal;
import java.util.HashMap;

public class PrefixNotation {
    //分配符号优先级
    static HashMap<String, Integer> map = new HashMap<>();
    //判断是否为运算符数据
    static String[] test = {"+", "-", "*", "/", "%", "(", ")"};

    public static void main(String args[]) {
        String s = "(2+3*3-1/35-((3+25)/2.5))";
        System.out.print(s + " = ");
        map.put("(", 0);
        map.put(")", 1);
        map.put("+", 2);
        map.put("-", 2);
        map.put("*", 3);
        map.put("/", 3);
        map.put("%", 3);
        double result = 0;
        try {
            result = fun(s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nException:(Here are some reasons)");
            System.out.println("1.输入格式不对");
            System.out.println("2.暂不支持负数写法，如-5,-2");
            System.out.println("2.被除数不能为0");
        }
        System.out.println(result);
    }

    /**
     * @param s 需要计算的字符串
     * @return 最后计算结果
     */
    private static double fun(String s) {
        Stack<Double> val = new Stack<>();
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
                val.push(Double.valueOf(new String(sb)));
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
                        //对于出栈的运算符，直接pop()出来在val栈进行运算
                        while (!opt.isEmpty() && map.get(x) <= map.get(opt.peek()))
                            cal(val, opt.pop());
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
        }
        //遍历完s，opt栈还有剩余元素，直接pop()出来在val栈进行运算
        while (!opt.isEmpty())
            cal(val, opt.pop());
        return val.pop();
    }

    /**
     * 计算方法：val中pop()两个数出来计算，得到结果再push()回去
     * @param val val栈用于保存操作数
     * @param x  返回最后结果
     */
    private static void cal(Stack<Double> val, String x) {
        BigDecimal b = BigDecimal.valueOf(val.pop());
        BigDecimal a = BigDecimal.valueOf(val.pop());
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
            case "/":
                val.push(a.divide(b, 5, BigDecimal.ROUND_HALF_EVEN).doubleValue());
                break;
            case "%":
                val.push(a.doubleValue() % b.doubleValue());
                break;
        }
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
}
