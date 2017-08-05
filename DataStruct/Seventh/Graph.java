package DataStruct.Seventh;

public class Graph {//图的邻接矩阵结构
    int V;
    int E;
    int[][] arc;

    public Graph(int V, int E) {
        this.E = E;
        this.V = V;
        arc = new int[V][V];
        //初始化矩阵
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (i == j)
                    arc[i][j] = 0;
                else
                    arc[i][j] = Integer.MAX_VALUE;
    }

    public int arc(int v, int w) {
        return arc[v][w];
    }

    public int[][] arcs() {
        return arc;
    }

    public void addEdge(int v, int w, int weight) {
        arc[v][w] = weight;
    }

}
