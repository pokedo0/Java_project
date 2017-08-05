package SelfLearning.demo1;


/**
 * Created by pokedo on 2017/3/6.
 */
public class demo2 {
    public static void main(String args[]) throws Exception {
        int[] a = {0, 0, 1, 1, 3, 5, 6, 8, 9, 9, 10, 12};
//        insert(a);
//        shell(a);
//        bubble(a);
//        select(a);
//        quick(a);
//        merge_sort(a);
        System.out.println(search(a, 3543));
    }

    private static int search(int[] a, int s) {
        int lo = 0;
        int hi = a.length - 1;
        while (true) {
            if (lo >= hi)
                return -1;
            int mid = (lo + hi) / 2;
            if (a[mid] == s)
                return mid;
            if (a[mid] < s)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
    }

    private static void merge_sort(int[] a) {
        mergesort(a, 0, a.length - 1);
        print(a);
    }

    private static void mergesort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        mergesort(a, lo, mid);
        mergesort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] temp = new int[hi + 1];
        int i = lo;
        int j = mid + 1;
        for (int t = lo; t <= hi; t++)
            temp[t] = a[t];
        while (true) {
            if (lo > hi)
                break;
            if (i > mid)
                a[lo++] = temp[j++];
            else if (j > hi)
                a[lo++] = temp[i++];
            else if (temp[i] < temp[j])
                a[lo++] = temp[i++];
            else
                a[lo++] = temp[j++];
        }
    }

    private static void quick(int[] a) {
        quicksort(a, 0, a.length - 1);
        print(a);
    }

    private static void quicksort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = partition(a, lo, hi);
        quicksort(a, lo, mid - 1);
        quicksort(a, mid + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[--j] > v && j > lo)
                continue;
            while (a[++i] < v && i < hi)
                continue;
            if (i >= j)
                break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static void select(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[min] > a[j])
                    min = j;
            exchange(a, i, min);
        }
        print(a);
    }

    private static void bubble(int[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] > a[j + 1])
                    exchange(a, j, j + 1);
        print(a);
    }

    private static void shell(int[] a) {
        int[] temp = {7, 3, 5, 1};
        for (int h : temp) {
            for (int i = 0; i < a.length; i++)
                for (int j = i; j >= h; j -= h)
                    if (a[j - h] > a[j])
                        exchange(a, j - h, j);
        }
        print(a);
    }


    private static void insert(int[] a) {
        for (int i = 1; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (a[j] > a[i])
                    exchange(a, i, j);
        print(a);
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
    }

}
