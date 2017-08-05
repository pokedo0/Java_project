package Graph;

import edu.princeton.cs.algs4.IndexMinPQ;
import java.util.Stack;

/**
 * Created by pokedo on 2017/3/28.
 */
public class PrimMST {
    //v距离树的最短边
    private Edge[] edgeTo;
    //这条最短边的权重
    private double[] distTo;
    //在树中的顶点被记录为true
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<>(G.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty())
            visit(G, pq.delMin());
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            //另一端顶点在树中，会构成环/平行边
            if (marked[w])
                continue;
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.changeKey(w, e.weight());
                else
                    pq.insert(w, e.weight());
            }
        }
    }

    public Iterable<Edge> edges() {
        Stack<Edge> stack = new Stack<>();
        for (Edge e : edgeTo)
            if (e != null)
                stack.push(e);
        return stack;
    }

    public double weight() {
        double sum = 0;
        for (Edge e : edgeTo)
            if (e != null)
                sum += e.weight();
        return sum;
    }
}
