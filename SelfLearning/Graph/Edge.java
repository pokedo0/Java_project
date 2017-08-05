package Graph;

/**
 * Created by pokedo on 2017/3/28.
 */
public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int v2) {
        if (v2 == v)
            return w;
        return v;
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight > that.weight)
            return 1;
        else if (this.weight < that.weight)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
