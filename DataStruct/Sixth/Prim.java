package DataStruct.Sixth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
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
public class Prim {
    //最小生成树的顶点
    static boolean[] marked;
    //最小生成树的边
    static Queue<Edge> mst;
    static MinQueue<Edge> pq;
    static WeightGraph G;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        scanner.nextLine();
        int E = scanner.nextInt();
        scanner.nextLine();
        G = new WeightGraph(V, E);
        pq = new MinQueue<>();
        mst = new LinkedList<>();
        marked = new boolean[G.V()];
        for (int i = 0; i < E; i++) {
            String[] str = scanner.nextLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            int l = Integer.parseInt(str[2]);
            G.addEdge(v, w, l);
        }

        visit(0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
//            System.out.println(e.weight());
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.add(e);
            if (!marked[w])
                visit(w);
            if (!marked[v])
                visit(v);
        }
    }

    private static void visit(int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) {
                pq.add(e);
                System.out.println(e.weight());
            }
    }
}
