package Algorithms.demo206;

import Algorithms.Base.Base;


/**
 * Created by pokedo on 2017/1/29.
 */
public class Sinksort {
    public static void sort(Comparable[] a) {
        //µ±a[0] = null Ê±£¬N = a.length-1;
        int N = a.length - 1;
        for (int k = N / 2; k >= 1; k--)
            sink(a, k, N);
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void swim(Comparable[] a, int k) {
        while (k > 1 && a[k / 2].compareTo(a[k]) < 0) {
            exch(a, k / 2, k);
            k = k / 2;
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && a[j].compareTo(a[j + 1]) < 0)
                j++;
            if (a[j].compareTo(a[k]) <= 0)
                break;
            exch(a, k, j);
            k = j;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String args[]) {
        String temp = Base.readString("Algorithms/algs4-data/tiny.txt");
        String[] arr = temp.split(" ");
        int N = arr.length;
        String[] str = new String[N + 1];
        for (int i = 0; i < arr.length; i++) {
            str[i + 1] = arr[i];
        }
        sort(str);
        for (String s : str)
            System.out.print(s + "  ");
    }
}


