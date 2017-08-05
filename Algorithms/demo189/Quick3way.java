package Algorithms.demo189;

import Algorithms.Base.Base;

/**
 * Created by pokedo on 2017/1/24.
 */
public class Quick3way {
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String args[]) {
        String str = Base.readString("Algorithms/algs4-data/tiny.txt");
        String[] a = str.split(" ");
        sort(a, 0, a.length-1);
        for (String i : a)
            System.out.print(i + " ");
    }

}
