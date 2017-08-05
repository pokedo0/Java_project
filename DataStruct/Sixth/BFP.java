package DataStruct.Sixth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 第一行为结点数，第二行为边数，复制下面的字段至控制台，构造一个邻接表
6
8
0 1
0 5
1 2
1 3
1 4
2 5
2 3
3 4
 */
public class BFP {
    //记录该每个顶点到起点的路径
    static int[] edgeTo;
    //记录访问过的顶点
    static boolean[] marked;
    //顶点数
    static int V;
    //边数
    static int E;
    static Graph G;
    //路径起点
    static int start;
    //路径终点
    static int end;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        scanner.nextLine();
        E = scanner.nextInt();
        scanner.nextLine();
        edgeTo = new int[V];
        marked = new boolean[V];
        G = new Graph(V, E);
        for (int i = 0; i < E; i++) {
            String[] str = scanner.nextLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            G.addEdge(a, b);
        }
        //起点为5
        start = 5;
        //bfs构建邻接表
        bfs(start);
        //从起点到任何顶点的路径
        System.out.println("from " + start + " to anywhere");
        for (int i = 0; i < V; i++) {
            end = i;
            findPath(end);
            System.out.println();
        }
    }

    //进行广度遍历，并保存路径
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        marked[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int w : G.adj(t)) {
                if (!marked[w]) {
                    edgeTo[w] = t;  //对邻近节点的edgeTo[]中保存上个节点的路径
                    queue.add(w);
                    marked[w] = true;
                }
            }
        }
    }

    //递归打印路径
    public static void findPath(int w) {
        //当w==起点==终点
        if (w == start && w == end) {
            System.out.print(w);
            return;
        }
        //当w==起点
        if (w == start) {
            System.out.print(w + "->");
            return;
        }
        findPath(edgeTo[w]);
        //当w==终点
        if (w == end)
            System.out.print(w);
            //当w!=终点
        else
            System.out.print(w + "->");
    }
}

