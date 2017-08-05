package DataStruct.Seventh;

import java.util.Scanner;

/*第一行为结点数，第二行为边数，复制下面的字段至控制台，构造一个邻邻接矩阵
6
8
0 2 1
0 4 3
0 5 10
4 5 6
4 3 2
3 5 1
2 3 5
1 2 5
 */
public class Floyd {
    static int[][] D;     //保存权值
    static int[][] path;  //保存路径
    static int start;
    static int end;
    static int E;
    static int V;
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        scanner.nextLine();
        E = scanner.nextInt();
        scanner.nextLine();
        Graph G = new Graph(V, E);
        D = G.arcs();
        path = new int[V][V];
        for (int i = 0; i < E; i++) {
            String[] str = scanner.nextLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            G.addEdge(v, w, weight);
        }

        Floyd(G);   //多源点求最短路径

        //多源点求最短路径，从start = 0 - V 到 end = 0 - V 的最短路径并打印
        for (start = 0; start < V; start++) {
            System.out.println("start : " + start);
            for (end = 0; end < V; end++) {
                System.out.print("val: " + D[start][end] + "  \t");
                findpath(end);
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void Floyd(Graph G) {
        for (int i = 0; i < G.V; i++) //初始化path[]数组
            for (int j = 0; j < V; j++) {
                if (D[i][j] == INF) ///表示  i -> j 不可达
                    path[i][j] = -1;
                else                //表示 i -> j 前驱为 i
                    path[i][j] = i;
            }

        for (int k = 0; k < G.V; k++) //假设只经过k=v0 - vk-1 个顶点。
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++) //假设D[i][j] > D[i][2] + D[2][j] ,2换成k
                    if (D[i][j] > D[i][k] + D[k][j] && D[i][k] < INF && D[k][j] < INF) {
                        D[i][j] = D[i][k] + D[k][j];
                        path[i][j] = path[k][j];    //i -> j 路径更新为 k -> j的路径（肯定包含k）
                    }
    }

    //打印路径
    public static void findpath(int w) {
        if (w == -1) {
            System.out.print("Unavaliable to ");
            return;
        }
        if (w == start && start == end) {
            System.out.print(w);
            return;
        }
        if (w == start) {
            System.out.print(w + "->");
            return;
        }
        findpath(path[start][w]);
        if (w == end)
            System.out.print(w);
        else
            System.out.print(w + "->");
    }

}
