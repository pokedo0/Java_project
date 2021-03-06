package Algorithms.demo156;

import Algorithms.Base.Base;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pokedo on 2017/1/22.
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int min;
        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
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
