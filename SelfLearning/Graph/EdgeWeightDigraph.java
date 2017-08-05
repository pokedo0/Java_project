package Graph;

import java.util.Stack;

/**
 * Created by pokedo on 2017/3/29.
 */
public class EdgeWeightDigraph {
    private int V;
    private int E;
    private Stack<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Stack[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Stack<DirectedEdge>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj[v])
                stack.push(e);
        return stack;
    }
}
