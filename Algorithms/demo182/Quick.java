package Algorithms.demo182;

/**
 * Created by pokedo on 2017/1/24.
 */
public class Quick {
    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        //--j,所以j=h+1;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (a[++i].compareTo(v) < 0)
                if (i == hi)
                    break;
            while (v.compareTo(a[--j]) < 0)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        //此时i>=j,所以必须交换v,j
        exch(a, lo, j);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static Integer[] getData(int cout, int mode) {
        Integer[] a = new Integer[cout];
        if (mode == 0)
            for (int i = 0; i < cout; i++)
                a[i] = i;
        else if (mode == 1)
            for (int i = 0; i < cout; i++)
                a[i] = cout - i;
        else {
            a = getData(cout, 0);
            for (int i = 0; i < a.length; i++) {
                int j = (int) (Math.random() * cout);
                exch(a, i, j);
            }
        }
        return a;
    }
    public static void main(String args[]) {
//        String str = Base.readString("Algorithms/algs4-data/tiny.txt");
//        String[] a = str.split(" ");
//        Integer[] a = getData(100000,0);
        Integer[] a = {2, 1};
        sort(a);
        for (int i : a)
            System.out.print(i + " ");
    }

}
