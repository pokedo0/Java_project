package DataStruct.Fourth.Graph;

import DataStruct.Fourth.Stack;

//图结构
public class Graph {
    //图的结点数
    int V;
    //图的边数
    int E;
    //邻接表
    Stack<Integer>[] stacks;
    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        stacks = new Stack[V];
        for (int i = 0; i < V; i++)
            stacks[i] = new Stack<>();
    }

    //添加两结点之间的边
    public void addEdge(int w, int t){
        stacks[w].push(t);
        stacks[t].push(w);
    }

    //获得v结点相邻的所有结点，返回一个包含所有结点的stack
    public Stack adj(int v){
        return stacks[v];
    }
}
