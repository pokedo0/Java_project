package Match.Seventh;

/**
 * 网友年龄
 * <p>
 * 某君新认识一网友。
 * 当问及年龄时，他的网友说：
 * “我的年龄是个2位数，我比儿子大27岁,
 * 如果把我的年龄的两位数字交换位置，刚好就是我儿子的年龄”
 * <p>
 * 请你计算：网友的年龄一共有多少种可能情况？
 * <p>
 * 提示：30岁就是其中一种可能哦.
 */
public class demo1_CA {
    public static void main(String args[]) {
        for (int i = 27; i <= 99; i++) {
            int s1 = i / 10;
            int s2 = i % 10;
            int j = i - 27;
            if (j == (s2 * 10 + s1))
                System.out.println(s1 + "" + s2);

        }
    }
}
