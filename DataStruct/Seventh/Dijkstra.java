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
public class Dijkstra {
    static boolean[] marked;
    static int[] D;    //保存权值
    static int[] path;
    static int E;
    static int V;
    static int start;
    static int end;
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        scanner.nextLine();
        E = scanner.nextInt();
        scanner.nextLine();
        Graph G = new Graph(V, E);
        D = new int[V];
        marked = new boolean[V];
        path = new int[V];
        for (int i = 0; i < E; i++) {
            String[] str = scanner.nextLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            G.addEdge(v, w, weight);
        }
        //起点为start
        start = 1;

        Dijkstra(G, start);
        for (int i = 0; i < V; i++) {
            end = i;
            System.out.print("val: " + D[i]+"  \t");
            findpath(end);
            System.out.println("");
        }
    }

    //打印路径
    private static void findpath(int w) {
        if (w == start && start == end) {
            System.out.print(w);
            return;
        }
        if (w == start) {
            System.out.print(w + "->");
            return;
        }
        if (path[w] == INF) {
            System.out.print("Unavaliable to " + w);
            return;
        }
        findpath(path[w]);
        if (w == end)
            System.out.print(w);
        else
            System.out.print(w + "->");
    }

    public static void Dijkstra(Graph G, int st) {
        //初始化
        for (int i = 0; i < V; i++) {
            int len = G.arc(st, i);
            if (len < INF)  //对st附近点，如果直连，则path[]赋值为st,否则为INF
                path[i] = st;
            else
                path[i] = INF;
            D[i] = len;
        }
        D[st] = 0;
        marked[st] = true;

        //对余下的V-1个进行求最短路径，i表示次数
        for (int i = 1; i < V; i++) {
            int idx = getMin(D);    //得到D[]的最小权值 顶点
            marked[idx] = true;

            //对当前最小点idx处附近 比较 最短路径
            for (int j = 0; j < V; j++) {
                int len = G.arc(idx, j);

                if (!marked[j] && len < INF && D[idx] < INF && D[idx] + len < D[j]) {
                    D[j] = D[idx] + len;
                    //更新路径
                    path[j] = idx;
                }
            }
        }
    }

    //得到当前D[]中权值最小的下标idx
    public static int getMin(int[] D) {
        //必须有min变量比较
        int min = INF;
        int idx = 0;
        for (int i = 0; i < V; i++) {
            if (!marked[i])
                if (D[i] < min) {
                    idx = i;
                    min = D[idx];
                }
        }
        return idx;
    }
}
