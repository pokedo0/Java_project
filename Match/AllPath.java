package Match;

import java.util.Stack;

/**
 * Created by pokedo on 2017/4/5.
 */
public class AllPath {
    static int[][] a;
    static boolean[][] marked;
    static Stack<Node> stack = new Stack<>();
    static int N;
    static int n;
    static int m;
    static int[][] next = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
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
        n = 3;
        m = 4;
        a = new int[n][m];
        marked = new boolean[n][m];
        dfs(0, 0, 0);
        System.out.println(N);
    }

    //x,y坐标，num (x,y)要填写的数字
    private static void dfs(int x, int y, int num) {
        a[x][y] = num;
        marked[x][y] = true;
        if (num == n * m - 1) {
            print(a);
            N++;
            return;
        }
        for (Node w : adj(x, y)) {
            if (!marked[w.x][w.y]) {
                dfs(w.x, w.y, num + 1);
                a[w.x][w.y] = 0;
                marked[w.x][w.y] = false;
            }
        }
    }

    private static Stack<Node> adj(int x, int y) {
        stack = new Stack<Node>();
        for (int[] b : next) {
            int x1 = b[0] + x;
            int y1 = b[1] + y;
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || marked[x1][y1])
                continue;
            stack.add(new Node(x1, y1));
        }
        return stack;
    }

    private static void print(int[][] a) {
        for (int[] b : a) {
            for (int i : b)
                System.out.printf(i + "\t");
            System.out.println();
        }
        System.out.println();
    }
}
