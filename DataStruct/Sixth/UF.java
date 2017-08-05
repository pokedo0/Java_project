package DataStruct.Sixth;

/**
 * 判断连通性 test
 */
public class UF {
    int[] id;
    int count;

    public UF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        if (proot != qroot)
            id[proot] = qroot;
    }
}
