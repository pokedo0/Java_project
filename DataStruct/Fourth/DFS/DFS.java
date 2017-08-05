package DataStruct.Fourth.DFS;

import DataStruct.Fourth.Graph.Graph;

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
public class DFS {
    //记录结点是否来过,初始化为false
    static boolean[] remarked;
    static Graph G;
    //结点数
    static int V;
    //边数
    static int E;
    //打印dfs()过程用
    static int temp = 0;

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
        for (int i = 0; i < E; i++) {
            s = scanner.nextLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            G.addEdge(w, t);
        }
        //打印邻接表
        print(G);
        int v = 2;

        //dfs过程
        System.out.println("\n打印dfs(" + v + ")递归过程 : ");
        dfs(v);
        for (int j = 0; j < temp; j++)
            System.out.print("|");
        temp--;
        System.out.println("done(" + v + ")");
    }

    //打印邻接表
    private static void print(Graph g) {
        System.out.println("G的邻接表：");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " : ");
            for (Object w : g.adj(i))
                System.out.print(w + " ");
            System.out.println();
        }
    }

    //dfs过程并打印出其递归轨迹
    public static void dfs(int v) {
        temp++;
        for (int j = 0; j < temp; j++)
            System.out.print("|");
        System.out.println("dfs(" + v + ")");
        remarked[v] = true;
        for (Object w : G.adj(v)) {
            if (remarked((int) w)) {
                for (int j = 0; j < temp; j++)
                    System.out.print("|");
                System.out.println("checked(" + w + ")");
            }
            if (!remarked((int) w)) {
                dfs((int) w);
                for (int j = 0; j < temp; j++)
                    System.out.print("|");
                temp--;
                System.out.println("done(" + w + ")");
            }
        }
    }

    //dfs简化，不打印递归过程
//    public static void dfs(int v) {
//        //记录该结点为true
//        remarked[v] = true;
//        //获得v结点的所有邻接结点,
//        for (Object w : G.adj(v))
//            //当该结点未记录时，从该结点进行dfs()
//            if (!remarked((int) w))
//                dfs((int) w);
//    }

    //判断该结点是否来过
    public static boolean remarked(int v) {
        return remarked[v];
    }
}
