package Match;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class adv_147_2 {
    static int n;
    static int m;
    static Queue<Node> queue = new LinkedList<>();
    static boolean[][] marked;
    //用一个Node二维数组保存路径
    static Node[][] edgeTo;
    static int[][] next = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    static Stack<Node> stack = new Stack<>();

    //用一个Node节点保存(x,y)信息
    static private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int[][] a = new int[n][m];
        marked = new boolean[n][m];
        edgeTo = new Node[n][m];
        for (int i = 0; i < n; i++) {
            str = scanner.nextLine().split("");
            for (int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(str[j]);
        }

        bfs(a, 0, 0);

        stack.clear();
        //打印路径
        for (Node w = new Node(n - 1, m - 1); w != null; w = edgeTo[w.x][w.y])
            stack.push(w);
        while(!stack.isEmpty()){
            Node w = stack.pop();
            int x = w.x;
            int y = w.y;
            System.out.print(" ( " + x + "," + y + " ) ");
        }
    }

    private static void bfs(int[][] a, int x, int y) {
        queue.add(new Node(x, y));
        marked[0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node w : adj(a, node.x, node.y)) {
                queue.add(w);
                marked[w.x][w.y] = true;
                edgeTo[w.x][w.y] = node;
            }
        }
    }

    //查找附近符合条件邻接点
    private static Stack<Node> adj(int[][] a, int x, int y) {
        stack.clear();
        for (int[] b : next) {
            int x1 = b[0] + x;
            int y1 = b[1] + y;
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || marked[x1][y1] || a[x1][y1] == 1)
                continue;
            stack.add(new Node(x1, y1));
        }
        return stack;
    }
}
