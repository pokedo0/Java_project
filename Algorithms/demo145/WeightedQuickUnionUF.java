package Algorithms.demo145;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by pokedo on 2017/1/21.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int count;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
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
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (sz[pRoot] > sz[qRoot]) {
            sz[pRoot] += sz[qRoot];
            id[qRoot] = pRoot;
        } else if (sz[pRoot] <= sz[qRoot]) {
            sz[qRoot] += sz[pRoot];
            id[pRoot] = qRoot;
        }
        count--;
    }

    public static void main(String args[]) {
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File("Algorithms/algs4-data/mediumUF.txt")));
            BufferedReader reader = new BufferedReader(read);
            int N = Integer.parseInt(reader.readLine());
            WeightedQuickUnionUF UF = new WeightedQuickUnionUF(N);
            String str;
            while ((str = reader.readLine()) != null) {
                String num[] = str.split(" ");
                int p = Integer.parseInt(num[0]);
                int q = Integer.parseInt(num[1]);
                if (UF.connected(p, q))
                    continue;
                else
                    UF.union(p, q);
                System.out.println(p + "  " + q);
            }
            System.out.println(UF.count() + "components");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
