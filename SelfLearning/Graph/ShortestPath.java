package Graph;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pokedo on 2017/3/29.
 */
public class ShortestPath {
    public static void main(String args[]) {
//        4
//        5
//        0 1   .35
//        0 2   .28
//        3 0   .37
//        1 2   .19
//        2 3   .24

        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();

        scanner.nextLine();
        int e = scanner.nextInt();
        scanner.nextLine();
        EdgeWeightDigraph G = new EdgeWeightDigraph(v);
        for (int i = 0; i < e; i++) {
            String[] s = scanner.nextLine().split("\\s");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            double w = Double.parseDouble(s[2]);
            DirectedEdge edge = new DirectedEdge(a, b, w);
            G.addEdge(edge);
        }
        int s = 0;
        DijkstraSP sp = new DijkstraSP(G, s);

        for (int t = 0; t < G.V(); t++) {
            System.out.print(s + " to " + t);
            System.out.print("( " + sp.distTo(t) + " )");
            if (sp.hasPathTo(t))
                for (DirectedEdge edge : sp.pathTo(t))
                    System.out.print(" " + edge.toString() + "  ");
            System.out.println();
        }
    }
}
