package DataStruct.Sixth;

import java.util.Scanner;
import java.util.Stack;

/* 邻接表实现：
第一行为结点数，第二行为边数，复制下面的字段至控制台，构造一个邻接表
6
10
0 1 7
0 2 1
0 3 5
1 2 6
1 4 3
3 2 7
3 5 2
4 2 6
4 5 7
5 2 4
 */
public class Prim2 {
    static WeightGraph G;
    static int V;
    static int E;
    static int idx;
    //保存{V-U} 至 {U} 的下标
    static int[] adjvex;
    //保存相关顶点{V-U} 至 {U} 的权值
    static int[] lowcost;
    //保存树的边的两边顶点 和 边权值
    static Object[][] tree;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        scanner.nextLine();
        E = scanner.nextInt();
        scanner.nextLine();
        G = new WeightGraph(V, E);
        adjvex = new int[V];
        lowcost = new int[V];
        //树的 点-点-权值
        tree = new Object[V - 1][3];
        for (int i = 0; i < E; i++) {
            String[] str = scanner.nextLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            int l = Integer.parseInt(str[2]);
            G.addEdge(v, w, l);
        }

        System.out.println("邻接表：");
        for (Stack<Edge> st : G.adjs()) {
            for (Edge e : st)
                System.out.print(e.weight() + " ");
            System.out.println();
        }
        System.out.println();

        int u = 0;
        Object[][] tree = prim(G, u);

        for (Object[] b : tree)
            System.out.println(b[0] + "-" + b[1] + "  val: " + b[2]);

    }

    //从 u 开始构建树，返回一个tree二维数组
    private static Object[][] prim(WeightGraph G, int u) {
        //对lowcost, adjvex 初始化操作
        for (int i = 0; i < V; i++) {
            lowcost[i] = Integer.MAX_VALUE;
            adjvex[i] = u;
        }
        //u点权值为0
        lowcost[u] = 0;
        //对u相邻的结点，进行lowcost,adjvex的赋值
        for (Edge e : G.adj(u)) {
            lowcost[e.other(u)] = e.weight();
            adjvex[e.other(u)] = u;
        }

        //这里i表示对剩下的 {U-V} 进行构造树的操作
        for (int i = 0; i < V - 1; i++) {
            idx = getMinNum(lowcost);  //找到最小权值的下标

            //生成树的边放入数组中
            tree[i][0] = idx;   //点
            tree[i][1] = adjvex[idx];   //此边另一个点
            tree[i][2] = lowcost[idx];  //边的权值

            update(lowcost, adjvex);    //更新 {U} 的lowcast,adjvex
        }
        return tree;
    }

    //遍历 lowcast 找到最小权值的下标
    private static int getMinNum(int[] lowcost) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++)
            if (lowcost[i] != 0 && lowcost[i] < min) {
                min = lowcost[i];
                idx = i;
            }
        return idx;
    }

    //找到权值下标后，并入{U}中，并更新lowcast,adjvex
    private static void update(int[] lowcost, int[] adjvex) {
        //刚并入{U}的节点，权值更新为0
        lowcost[idx] = 0;
        //对idx相邻的节点进行更新
        for (Edge e : G.adj(idx)) {
            int v = e.other(idx);
            if (lowcost[v] != 0 && e.weight < lowcost[v]) {
                lowcost[v] = e.weight;
                adjvex[v] = idx;
            }
        }
    }
}
