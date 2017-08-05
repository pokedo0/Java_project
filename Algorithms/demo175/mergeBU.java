package Algorithms.demo175;

import Algorithms.Base.Base;

/**
 * Created by pokedo on 2017/1/24.
 */
public class mergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz){
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                //验证Math.min(lo + sz + sz - 1, N - 1)的必要性
//                System.out.println("sz="+sz+"   merge("+lo+", mid ,"+(lo+sz+sz-1)+")");
                System.out.println("sz="+sz+"   merge("+lo+", mid ,"+Math.min(lo + sz + sz - 1, N - 1)+")");
            }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0)
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }

    public static void main(String args[]) {
        String str = Base.readString("Algorithms/algs4-data/tiny.txt");
        String[] a = str.split(" ");
        sort(a);
        for (String i : a)
            System.out.print(i + " ");
    }

}
