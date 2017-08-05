package Graph;
import java.util.Scanner;

/**
 * Created by pokedo on 2017/3/28.
 */
public class EWGtest {
    public static void main(String args[]) {
//        4
//        5
//        0 1   .35
//        0 2   .28
//        0 3   .37
//        1 2   .19
//        2 3   .24

        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();

        scanner.nextLine();
        int e = scanner.nextInt();
        scanner.nextLine();
        EdgeWeightedGraph G = new EdgeWeightedGraph(v);
        for (int i = 0; i < e; i++) {
            String[] s = scanner.nextLine().split("\\s");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            double w = Double.parseDouble(s[2]);
            Edge edge = new Edge(a, b, w);
            G.addEdge(edge);
        }

        KruskalMST mst = new KruskalMST(G);
        for (Edge edge : mst.edges())
            System.out.println(edge.toString());
        System.out.println(mst.weight());

//        for (int i = 0; i < G.V(); i++)
//            for (Edge edge : G.adj(i))
//                System.out.println(edge.toString());
    }
}
