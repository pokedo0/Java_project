package DataStruct.Sixth;

import java.util.Scanner;

/*
第一行为结点数，第二行为边数，复制下面的字段至控制台。
mian会读取每条边的信息，并全部加入优先队列中。
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
public class Kruskal {
    static int V;
    static int E;
    static MinQueue<Edge> pq;   //优先队列，默认从小至大排序
    static UF uf;   //判断树是否有回路

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        scanner.nextLine();
        E = scanner.nextInt();
        scanner.nextLine();
        pq = new MinQueue<>();
        uf = new UF(V);
        for (int i = 0; i < E; i++) {
            String[] str = scanner.nextLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            int l = Integer.parseInt(str[2]);
            pq.add(new Edge(v, w, l));
        }
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) //如果此边的两点都已经连通，说明会产生回路
                continue;
            uf.union(v, w); //此边加入树中，并联合v,w
            System.out.println(v + "-" + w + "  val: " + e.weight());
        }
    }
}
