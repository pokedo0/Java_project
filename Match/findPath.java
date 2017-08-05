package Match;

import java.util.Stack;

//从左上角入口到右下角出口一共多少种走法
public class findPath {
    static boolean[][] marked;
    static int[][] a;
    static int n;
    static int m;
    static int count;
    static Stack<Node> stack = new Stack<>();
    static int[][] next = {
            {0, 1},
            {1, 0}
    };

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        n = 5;
        m = 5;
        a = new int[n][m];
        marked = new boolean[n][m];
        int x = 0;
        int y = 0;
        dfs(x, y);
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        marked[x][y] = true;
        a[x][y] = 1;
        if (x == n - 1 && y == m - 1) {
            print(a);
            count++;
            return;
        }
        for (Node w : adj(x, y)) {
            if (!marked[w.x][w.y]) {
                dfs(w.x, w.y);
                a[w.x][w.y] = 0;
                marked[w.x][w.y] = false;
            }
        }
    }

    private static void print(int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static Stack<Node> adj(int x, int y) {
        //返回一个新栈，不然以前的栈会被改变
        stack = new Stack<>();
        for (int[] b : next) {
            int x1 = b[0] + x;
            int y1 = b[1] + y;
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || marked[x1][y1])
                continue;
            stack.add(new Node(x1, y1));
        }
        return stack;
    }
}
