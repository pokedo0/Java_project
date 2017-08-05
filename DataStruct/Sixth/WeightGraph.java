package DataStruct.Sixth;

import java.util.Stack;

//带权值图结构
//另外测试
class WeightGraph {
    int V;
    int E;
    int[][] arc;
    Stack<Edge>[] adj;

    public WeightGraph(int V, int E) {
        this.V = V;
        this.E = E;
        adj = new Stack[V];
        arc = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                arc[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++)
            adj[i] = new Stack<Edge>();
    }

    public void addEdge(int v, int w, int weight) {
        Edge e = new Edge(v, w, weight);
        adj[v].add(e);
        adj[w].add(e);
        arc[w][v] = weight;
        arc[v][w] = weight;
    }

    public Stack<Edge> adj(int v) {
        return adj[v];
    }

    public Stack[] adjs() {
        return adj;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

}
