package Graph;

import java.util.Scanner;

/**
 * Created by pokedo on 2017/3/17.
 */
public class GraphTest {
    public static void main(String args[]) {
//        4
//        5
//        0 1
//        0 2
//        0 3
//        1 2
//        2 3
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        scanner.nextLine();
        int e = scanner.nextInt();
        scanner.nextLine();
        Graph G = new Graph(v);
        for (int i = 0; i < e; i++) {
            String[] s = scanner.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            G.addEdge(a, b);
        }
//        System.out.println("degree : " + degree(G, 0));
        BreadthFirstSearch dfs = new BreadthFirstSearch(G, 0);
        System.out.println(dfs.hasPathTo(3));
        for (int t : dfs.pathTo(3))
            if (t == 3)
                System.out.print(t);
            else
                System.out.print(" - " + t);
        //ÊÇ·ñÁ¬Í¨
        CC c = new CC(G);
        for (int i = 0; i < G.V(); i++)
            System.out.println(c.id(i));
    }

    public static int degree(Graph G, int V) {
        int degree = 0;
        for (int w : G.adj(V))
            degree++;
        return degree;
    }
}
