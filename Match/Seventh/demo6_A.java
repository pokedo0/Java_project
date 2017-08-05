package Match.Seventh;

/**
 * 寒假作业

 现在小学的数学题目也不是那么好玩的。
 看看这个寒假作业：

 □ + □ = □
 □ - □ = □
 □ × □ = □
 □ ÷ □ = □

 (如果显示不出来，可以参见【图1.jpg】)

 每个方块代表1~13中的某一个数字，但不能重复。
 比如：
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

 以及：
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

 就算两种解法。（加法，乘法交换律后算不同的方案）

 你一共找到了多少种方案？
 */
public class demo6_A {
    static int[] a;
    static boolean[] marked;
    static int N;

    public static void main(String args[]) {
        a = new int[13];
        marked = new boolean[14];
        dfs(1);
        System.out.println(N);
    }

    private static void dfs(int cur) {
        if (cur == 13) {
            N++;
            print();
            return;
        }
        for (int i = 1; i <= 13; i++) {
            if (!marked[i]) {
                a[cur] = i;
                marked[i] = true;
                if (check(cur))
                    dfs(cur + 1);
                a[cur] = 0;
                marked[i] = false;
            }
        }
    }

    //分阶段进行验证
    private static boolean check(int cur) {
        if (cur >= 3 && a[1] + a[2] != a[3])
            return false;
        if (cur >= 6 && a[4] - a[5] != a[6])
            return false;
        if (cur >= 9 && a[7] * a[8] != a[9])
            return false;
        if (cur >= 12 && (double) a[10] / a[11] != a[12])
            return false;
        return true;
    }

    private static void print() {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }
}
