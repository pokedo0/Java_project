package Match.Seventh;

/**
 * 平方怪圈

 如果把一个正整数的每一位都平方后再求和，得到一个新的正整数。
 对新产生的正整数再做同样的处理。

 如此一来，你会发现，不管开始取的是什么数字，
 最终如果不是落入1，就是落入同一个循环圈。

 请写出这个循环圈中最大的那个数字。
 */
public class demo3_JC {
    public static void main(String args[]) {
        int a = 122;
        String[] str = (a + "").split("");
        while (true) {
            int sum = 0;
            int t;
            for (String s : str) {
                t = Integer.parseInt(s);
                sum += t * t;
            }
            System.out.println(sum);
            str = (sum + "").split("");
        }
    }
}
