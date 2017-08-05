package DataStruct.Fourth.BFS;

import DataStruct.Fourth.Graph.Graph;
import DataStruct.Fourth.Queue;
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
public class BFS {
    //记录结点是否来过,初始化为false
    static boolean[] remarked;
    static Graph G;
    //结点数
    static int V;
    //边数
    static int E;
    static Queue<Integer> queue;

    public static void main(String args[]) {
        //根据控制台输入字段构造图结构
        Scanner scanner = new Scanner(System.in);
        String[] s;
        V = scanner.nextInt();
        scanner.nextLine();
        E = scanner.nextInt();
        scanner.nextLine();
        G = new Graph(V, E);
        remarked = new boolean[V];
        queue = new Queue<Integer>();
        for (int i = 0; i < E; i++) {
            s = scanner.nextLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            G.addEdge(w, t);
        }
        int v = 0;
        //打印邻接表
        print(G);
        System.out.println("\n打印bfs(" + v + ")的队列过程 : ");
        bfs(v);
    }

    private static void print(Graph g) {
        System.out.println("G的邻接表：");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " : ");
            for (Object w : g.adj(i))
                System.out.print(w + " ");
            System.out.println();
        }
    }

    //bfs过程并打印队列过程
    public static void bfs(int v) {
        //第一个元素入列
        queue.enqueue(v);
        System.out.println(v);
        //记录该结点已来过
        remarked[v] = true;
        while (!queue.isEmpty()) {
            //出列首结点
            int t = queue.dequeue();
            //对出列结点的相邻结点入列
            for (Object w : G.adj(t))
                //如果相邻结点没来过，则入列，并标记为已来过
                if (!remarked((int) w)) {
                    remarked[(int) w] = true;
                    queue.enqueue((int) w);
                }
            //打印此时队列元素
            for (int i : queue)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    //判断该结点是否来过
    public static boolean remarked(int v) {
        return remarked[v];
    }
}
