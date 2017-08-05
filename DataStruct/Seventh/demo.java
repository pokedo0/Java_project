package DataStruct.Seventh;

import java.util.Scanner;

/*第一行为结点数，第二行为边数，复制下面的字段至控制台，构造一个邻邻接矩阵
4
7
0 1 15
0 2 3
1 0 10
1 2 2
2 3 2
3 1 8
3 2 4
 */
public class demo extends Floyd {
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

        System.out.println("最短路径:");
        int min = INF;
        int temp = 0;
        int idx = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(D[i][j] + "\t");
                temp += D[i][j];
            }
            if (temp < min) {
                min = temp;
                idx = i;
            }
            temp = 0;
            System.out.println();
        }
        switch (idx) {
            case 0:
                System.out.println("应设在A村");
                break;
            case 1:
                System.out.println("应设在B村");
                break;
            case 2:
                System.out.println("应设在C村");
                break;
            case 3:
                System.out.println("应设在D村");
                break;
        }
    }

    public static void Floyd(Graph G) {
        for (int i = 0; i < V; i++) //初始化path[]数组
            for (int j = 0; j < V; j++) {
                if (D[i][j] == INF) ///表示  i -> j 不可达
                    path[i][j] = -1;
                else                //表示 i -> j 前驱为 i
                    path[i][j] = i;
            }

        for (int k = 0; k < V; k++) //假设只经过k=v0 - vk-1 个顶点。
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++) //假设D[i][j] > D[i][2] + D[2][j] ,2换成k
                    if (D[i][j] > D[i][k] + D[k][j] && D[i][k] < INF && D[k][j] < INF) {
                        D[i][j] = D[i][k] + D[k][j];
                        path[i][j] = path[k][j];    //i -> j 路径更新为 k -> j的路径（肯定包含k）
                    }
    }
}
