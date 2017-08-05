package Algorithms.demo157;

import Algorithms.Base.Base;

/**
 * Created by pokedo on 2017/1/22.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    public static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main(String args[]) {
        String str = Base.readString("Algorithms/algs4-data/words3.txt");
        String[] a = str.split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
