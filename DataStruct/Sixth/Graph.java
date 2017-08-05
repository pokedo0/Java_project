package DataStruct.Sixth;

import java.util.Stack;

public class Graph {
    int V;
    int E;
    int[][] arc;
    Stack[] adj;

    public Graph(int V, int E) {
        this.E = E;
        this.V = V;
        adj = new Stack[V];
        arc = new int[V][V];
        for (int i = 0; i < V; i++)
            adj[i] = new Stack();
    }

    public void addEdge(int w, int v) {
        adj[w].add(v);
        adj[v].add(w);
    }

    public Stack<Integer> adj(int w) {
        return adj[w];
    }
}
