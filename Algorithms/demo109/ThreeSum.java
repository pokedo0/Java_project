package Algorithms.demo109;

import Algorithms.Base.Base;

/**
 * Created by pokedo on 2017/1/18.
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String args[]) {
        int[] a = Base.readInts("Algorithms/algs4-data/4Kints.txt");
        System.out.println("result:"+count(a));
//        System.out.println(-3+new Random().nextInt(2*3));
    }
}
