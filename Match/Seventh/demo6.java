package Match.Seventh;


//因为全部方格都要填写，其实类似全排列，故dfs()中需要for(0-9)进行枚举，且不需要数组记录
//访问过的二维数组的位置
public class demo6 {
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
        a[0][0] = -2;
        a[2][3] = -2;
        dfs(a, 0);
        System.out.println(count);
        double end = System.currentTimeMillis();
        System.out.println("time : " + (end - start) / 1000);
    }

    private static void dfs(int[][] a, int cur) {
        if (cur == len) {
//            print(a);
            if (!isNeighbor(a))
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
                dfs(a, cur + 1);
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

    //检验相邻数字
    public static boolean isNeighbor(int[][] a) {
        //从头到尾进行遍历
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == 11)
                continue;
            int x = i / 4;
            int y = i % 4;
            for(int[] b : next) {
                int x1 = b[0] + x;
                int y1 = b[1] + y;
                //越界，跳过
                if(x1 < 0 || x1 >=3 || y1<0 || y1 >=4)
                    continue;
                //当为相邻数时，返回true
                if (Math.abs(a[x1][y1] - a[x][y]) == 1)
                        return true;
            }
        }
        return false;
    }
}
