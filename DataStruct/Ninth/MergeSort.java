package DataStruct.Ninth;

/**
 * Created by pokedo on 2017/5/10.
 */
public class MergeSort {
    public static void main(String args[]) {
        int[] a = {1, 2};
        mergesort(a);
        print(a);
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void mergesort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);           //对a[]进行切割,左半排序
        sort(a, mid + 1, hi);   //右半排序
        merge(a, lo, mid, hi);  //合并子序列,比如最开始子序列为:
        //merge(0,0,1) + merge(2,2,3) -> merge(0,1,3)
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] temp = new int[a.length];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            temp[k] = a[k];     //temp作临时数组，保存a[]的数据,
        // 因为下面的归并需要覆盖a[]自身的数据
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = temp[j++];
            else if (j > hi)
                a[k] = temp[i++];
            else if (temp[i] < temp[j])
                a[k] = temp[i++];
            else
                a[k] = temp[j++];
        }
    }
}
