package Match.Seventh;

/**
 * 搭积木

 小明最近喜欢搭数字积木，
 一共有10块积木，每个积木上有一个数字，0~9。

 搭积木规则：
 每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
 最后搭成4层的金字塔形，必须用完所有的积木。

 下面是两种合格的搭法：

 0
 1 2
 3 4 5
 6 7 8 9

 0
 3 1
 7 5 2
 9 8 6 4

 请你计算这样的搭法一共有多少种？
 */
public class demo3_A {
    static int[][] a;
    static boolean[] marked;
    static int N;

    public static void main(String args[]) {
        a = new int[4][4];
        marked = new boolean[10];
        dfs(0);
        System.out.println(N);
    }

    private static void dfs(int cur) {
        if (cur == 16) {
            print();
            N++;
            return;
        }
        int x = cur / 4;
        int y = cur % 4;
        if (x < y)
            dfs(cur + 1);
        for (int i = 0; i <= 9; i++) {
            if (!marked[i]) {
                a[x][y] = i;
                marked[i] = true;
                if (check(cur))
                    dfs(cur + 1);
                a[x][y] = 0;
                marked[i] = false;
            }
        }
    }

    //全局判断
    private static boolean check() {
        for (int i = 0; i < 16; i++) {
            int x = i / 4;
            int y = i % 4;
            if (x < y)
                continue;
            if (x == 3)
                return true;
            if (a[x][y] > a[x + 1][y] || a[x][y] > a[x + 1][y + 1])
                return false;
        }
        return true;
    }

    //逐步判断
    private static boolean check(int cur) {
        int x = cur / 4;
        int y = cur % 4;
        if (x >= 1 && y >= 1 & (a[0][0] > a[1][0] || a[0][0] > a[1][1]))
            return false;
        if (x >= 2 && y >= 2 & (a[1][0] > a[2][0] || a[1][0] > a[2][1]
                || a[1][1] > a[2][1] || a[1][1] > a[2][2]))
            return false;
        if (x >= 3 && y >= 3 & (a[2][0] > a[3][0] || a[2][0] > a[3][1]
                || a[2][1] > a[3][1] || a[2][1] > a[3][2]
                || a[2][2] > a[3][2] || a[2][2] > a[3][3]))
            return false;
        return true;
    }


    private static void print() {
        for (int[] b : a) {
            System.out.println();
            for (int i : b)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
