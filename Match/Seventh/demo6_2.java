package Match.Seventh;

/**
 * Created by pokedo on 2017/3/31.
 */
public class demo6_2 {
    //总方格数目
    static int len = 12;
    //0-9个数字
    static boolean[] remarked = new boolean[10];
    static int count;
    static int[][] next = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };

    public static void main(String args[]) {
        double start = System.currentTimeMillis();
        int[][] a = new int[3][4];
        //都初始化为-2
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                a[i][j] = -2;
        dfs(a, 0);
        System.out.println(count);
        double end = System.currentTimeMillis();
        System.out.println("time : " + (end - start) / 1000);
    }

    private static void dfs(int[][] a, int cur) {
        if (cur == len) {
            print(a);
            count++;
            return;
        }
        //当cur位置为不可填方格时，直接跳过
        if (cur == 0 || cur == 11) {
            dfs(a, cur + 1);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!remarked[i]) {
                remarked[i] = true;
                a[cur / 4][cur % 4] = i;
                //当cur位置的数没有相邻，则进入下一个位置进行dfs()
                if (!isNeighbor(a, cur))
                    dfs(a, cur + 1);
                //无论有无相邻数，都要复原cur的数据
                a[cur / 4][cur % 4] = -2;
                remarked[i] = false;
            }
        }
    }

    private static void print(int[][] a) {
        for (int[] arr : a) {
            for (int i : arr)
                if (i == -2)
                    System.out.print(" * ");
                else
                    System.out.print(" " + i + " ");
            System.out.println();
        }
        System.out.println();
    }

    //检验相邻数字,传入cur当前要检查的位置
    public static boolean isNeighbor(int[][] a, int cur) {
        int i = cur;
        if (i == 0 || i == 11)
            return false;
        int x = i / 4;
        int y = i % 4;
        for (int[] b : next) {
            int x1 = b[0] + x;
            int y1 = b[1] + y;
            //越界，跳过
            if (x1 < 0 || x1 >= 3 || y1 < 0 || y1 >= 4)
                continue;
            //当为相邻数时，返回true
            if (Math.abs(a[x1][y1] - a[x][y]) == 1)
                return true;
        }
        return false;
    }
}
