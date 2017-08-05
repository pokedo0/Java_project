package Match;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pokedo on 2017/4/3.
 */
public class adv_147 {
    static int n;
    static int m;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] marked;
    static int edgeTo[];
    static int[][] next = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    static Stack<Integer> stack = new Stack<>();

//    static private class Node {
//        int ahead;
//        int num;
//
//        public Node(int num) {
//            this.num = num;
//        }
//
//        public Node(int num, int ahead) {
//            this.num = num;
//            this.ahead = ahead;
//        }
//    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int[][] a = new int[n][m];
        marked = new boolean[n * m];
        edgeTo = new int[n * m];
        for (int i = 0; i < n; i++) {
            str = scanner.nextLine().split("");
            for (int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(str[j]);
        }
        bfs(a);
        for (int x = n * m - 1; x != 0; x = edgeTo[x])
            stack.push(x);
        stack.push(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            int x = i / n;
            int y = i % m;
            System.out.print(" ( " + x + "," + y + " ) ");
        }
    }

    private static void bfs(int[][] a) {
        queue.add(0);
        marked[0] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i : adj(a, num)) {
                edgeTo[i] = num;
                queue.add(i);
                marked[i] = true;
            }
        }
    }

    private static Stack<Integer> adj(int[][] a, int cur) {
        int x = cur / m;
        int y = cur % m;
        int x1 = 0;
        int y1 = 0;
        stack.clear();
        for (int[] b : next) {
            x1 = b[0] + x;
            y1 = b[1] + y;
            //TODO µ±Ç°³¤¶È
            int len = x1 * n + y1;
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || a[x1][y1] == 1 || marked[len])
                continue;
            stack.add(len);
        }
        return stack;
    }

}
