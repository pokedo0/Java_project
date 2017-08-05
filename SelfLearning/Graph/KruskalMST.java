package Graph;


import DataStruct.Fourth.Queue;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by pokedo on 2017/3/29.
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        //保存树的边
        mst = new Queue<Edge>();
        //保存未检查的边
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //所有边add进pq中
        for (Edge e : G.edges())
            pq.add(e);
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            //检查连通性
            if (uf.connected(v, w))
                continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        Stack<Edge> stack = new Stack<>();
        for (Edge e : mst)
            if (e != null)
                stack.push(e);
        return stack;
    }

    public double weight() {
        double sum = 0;
        for (Edge e : mst)
            if (e != null)
                sum += e.weight();
        return sum;
    }
}
