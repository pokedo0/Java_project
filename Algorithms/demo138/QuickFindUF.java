package Algorithms.demo138;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by pokedo on 2017/1/21.
 */
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;
        else
            for (int i = 0; i < id.length; i++)
                if (id[i] == pID)
                    id[i] = qID;
        count--;
    }

    public static void main(String args[]) {
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File("Algorithms/algs4-data/mediumUF.txt")));
            BufferedReader reader = new BufferedReader(read);
            int N = Integer.parseInt(reader.readLine());
            QuickFindUF UF = new QuickFindUF(N);
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
            System.out.println(UF.count + "components");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
