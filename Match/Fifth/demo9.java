package Match.Fifth;

import java.util.Scanner;

/**
 * X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
 * <p>
 * 地宫的入口在左上角，出口在右下角。
 * <p>
 * 小明被带到地宫的入口，国王要求他只能向右或向下行走。
 * <p>
 * 走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
 * <p>
 * 当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
 * <p>
 * 请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
 * <p>
 * 【数据格式】
 * <p>
 * 输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
 * <p>
 * 接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值
 * <p>
 * 要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。
 * <p>
 * 例如，输入：
 * 2 2 2
 * 1 2
 * 2 1
 * 程序应该输出：
 * 2
 * <p>
 * 再例如，输入：
 * 2 3 2
 * 1 2 3
 * 2 1 5
 * 程序应该输出：
 * 14
 */
public class demo9 {

    static int[][][][] dp;
    static int[][] val;
    static int n;
    static int m;
    static int k;
    static int N = 1000000007;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        k = Integer.parseInt(strs[2]);

        val = new int[n][m];
        //状态 : 位置(i,j) / 宝贝个数 / 当前携带宝贝最大价值
        //总价值并不重要，最大价值才重要，决定了下一步的传参
        dp = new int[n][m][13][13];
        for (int i = 0; i < n; i++) {
            strs = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++)
                val[i][j] = Integer.parseInt(strs[j]);
        }

        for (int[][][] t : dp)
            for (int[][] m : t)
                for (int[] c : m)
                    for (int i = 0; i < c.length; i++)
                        c[i] = -1;

        int res = dfs(0, 0, 0, -1);
        System.out.println(res);
    }
    //当前状态方程(当前方案个数) = 下一步取宝物产生的方案个数 + 下一步不取宝物产生的方案个数
    //dp(x,y,num,curmax) = dp(x+k,y+k,num+k,val[x][y]) + dp(x+k,y+k,num,curmax)

    //因为宝物的价值有可能为0，所以定义max时用最小值-1 。
    //但这就导致无法作为下标使用，所以我们用max+1代表下标。
    private static int dfs(int x, int y, int num, int curmax) {
        int s = 0;
        //经过当前位置的所有方案个数已经存在，直接返回
        if (dp[x][y][num][curmax + 1] != -1)
            return dp[x][y][num][curmax + 1];
        if (x == n - 1 && y == m - 1) {
            if (num == k)
                return dp[x][y][num][curmax + 1] = 1;
            else if (num == k - 1 && val[x][y] > curmax)
                return dp[x][y][num][curmax + 1] = 1;
            else
                return dp[x][y][num][curmax + 1] = 0;
        }
        //可以向下走
        if (x + 1 < n) {
            //可以取走当前宝物
            //状态方程 : 向下走时，当前的状态受 取宝物和不取宝物状态的影响
            //因为下一步取宝物的方案个数，或是下一步不取宝物的方案个数都对当前状态的方案
            //个数产生影响，因此相加
            //dp(x,y,num,curmax) = dp(x+1,y,num+1,val[x][y]) + dp(x+1,y,num,curmax)
            //
            if (val[x][y] > curmax) {
                s += dfs(x + 1, y, num + 1, val[x][y]);
                s %= N;
            }
            //未取走当前宝物
            s += dfs(x + 1, y, num, curmax);
             s %= N;
        }
        if (y + 1 < m) {
            if (val[x][y] > curmax) {
                s += dfs(x, y + 1, num + 1, val[x][y]);
                s %= N;
            }
            s += dfs(x, y + 1, num, curmax);
            s %= N;
        }
        return dp[x][y][num][curmax+1] = s;
    }
}
