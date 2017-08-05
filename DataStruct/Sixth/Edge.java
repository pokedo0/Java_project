package DataStruct.Sixth;

public class Edge implements Comparable<Edge> {
    //v,w为边的两个顶点，weight为权值
    int v;
    int w;
    int weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    //返回顶点v;
    public int either() {
        return v;
    }

    //返回相对于顶点t的另一个顶点;
    public int other(int t) {
        if (t == v)
            return w;
        return v;
    }

    @Override
    //实现Comparable接口，方便在MinQueue中直接比较大小
    public int compareTo(Edge that) {
        if (this.weight > that.weight)
            return 1;
        else if (this.weight < that.weight)
            return -1;
        else
            return 0;
    }
}
