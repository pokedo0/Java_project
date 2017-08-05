package Graph;

import java.util.Stack;

/**
 * Created by pokedo on 2017/3/28.
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Stack<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Stack[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Stack<Edge>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].push(e);
        adj[w].push(e);
        E++;
    }

    public Iterable<Edge> adj(int V) {
        return adj[V];
    }

    public Iterable<Edge> edges() {
        Stack<Edge> b = new Stack<Edge>();
        for (int v = 0; v < V; v++)
            for (Edge e : adj[v])
                if (e.other(v) > v)
                    b.push(e);
        return b;
    }
}
