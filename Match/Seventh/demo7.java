package Match.Seventh;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pokedo on 2017/3/31.
 */
public class demo7 {
    static int len = 5;
    //marked,在bfs中记录访问轨迹，判断连通数
    static boolean[] marked = new boolean[12];
    static Queue<Integer> queue = new LinkedList<>();
    static int count;

    public static void main(String args[]) {
        boolean[][] a = new boolean[3][4];
        dfs(a, 0, 0);
        System.out.println(count);
    }

    //组合！不是排列
    private static void dfs(boolean[][] a, int cur, int rest) {
        if (cur == len) {
            if (connected(a)) {
                print(a);
                count++;
            }
            return;
        }

        for (int i = rest; i < 12; i++) {
            int j = i / 4;
            int k = i % 4;
            a[j][k] = true;
            dfs(a, cur + 1, i + 1);
            a[j][k] = false;
        }
    }

    //是否连通
    private static boolean connected(boolean[][] a) {
        int result = 0;
        //在a[]中从0-12寻找一个符合要求的方格，并以此方格为起点，进行bfs()
        for (int i = 0; i < 12; i++) {
            int a1 = i / 4;
            int b1 = i % 4;
            //返回result连通数结果
            if (a[a1][b1]) {
                result = bfs(a, i);
                break;
            }
        }
        if (result == len)
            return true;
        return false;
    }

    private static int bfs(boolean[][] a, int i) {
        //每次bfs重新初始化marked
        marked = new boolean[12];
        queue.add(i);
        marked[i] = true;
        //mcout计算当前起点连通数
        int mcout = 1;
        while (!queue.isEmpty()) {
            i = queue.poll();
            int a1 = i / 4;
            int b1 = i % 4;
            //取上下左右的相邻点
            for (int j = -1; j <= 1; j++)
                for (int k = -1; k <= 1; k++) {
                    if (Math.abs(j - k) != 1)
                        continue;
                    if (a1 + j < 0 || a1 + j > 2 || b1 + k < 0 || b1 + k > 3)
                        continue;
                    if (a[a1 + j][b1 + k]) {
                        i = (a1 + j) * 4 + b1 + k;
                        //当该位置没被访问过才add()
                        if (!marked[i]) {
                            marked[i] = true;
                            queue.add(i);
                            mcout++;
                        }
                    }
                }
        }
        return mcout;
    }

    private static void print(boolean[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++)
                if (a[i][j])
                    System.out.print(" + ");
                else
                    System.out.print(" - ");
            System.out.println();
        }
        System.out.println();
    }
}
