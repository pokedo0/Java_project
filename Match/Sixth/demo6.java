package Match.Sixth;

import java.util.Scanner;

/**
 * Created by pokedo on 2017/4/2.
 */
public class demo6 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] str = scanner.nextLine().split("");
            for (int j = 0; j < 9; j++)
                a[i][j] = Integer.valueOf(str[j]);
        }
        double start = System.currentTimeMillis();
        dfs(a, 0);

        double end = System.currentTimeMillis();
        System.out.println((end-start)/1000);

    }

    //思想 : 当成一个一维数组 从0-81开始排列，其实每个dfs()，每个位置都有0-9的填法
    //只是每填一次都check()一次，当所有数字都check()失败，则回溯到以前的位置，继续尝试其他位置
    private static void dfs(int[][] a, int cur) {
        if (cur == 81) {
            print(a);
            return;
        }
        int x = cur / 9;
        int y = cur % 9;
        //跳过默认已填数字
        if (a[x][y] != 0) {
            dfs(a, cur + 1);
            return;
        }
        //当for()中所有数字都遍历完，则回溯，否则可以继续走下一步
        for (int i = 0; i < 9; i++) {
            a[x][y] = i + 1;
            if (check(a, cur))
                dfs(a, cur + 1);
            a[x][y] = 0;
        }
    }

    private static boolean check(int[][] a, int cur) {
        int x = cur / 9;
        int y = cur % 9;
        int num = a[x][y];
        //检查横竖的数字
        for (int i = 0; i < 9; i++) {
            if (num == a[x][i] && i != y || num == a[i][y] && i != x)
                return false;
        }
        //检查小宫格的数字
        int x1 = x / 3 * 3;
        int y1 = y / 3 * 3;
        int t1 = x1 + 3;
        int t2 = y1 + 3;
        for (x1 = x / 3 * 3; x1 < t1; x1++)
            for (y1 = y / 3 * 3; y1 < t2; y1++)
                if (num == a[x1][y1] && x1 != x && y1 != y)
                    return false;
        return true;
    }

    private static void print(int[][] a) {
        for (int[] arr : a) {
            for (int i : arr)
                System.out.print(i);
            System.out.println();
        }
        System.out.println();
    }
}
