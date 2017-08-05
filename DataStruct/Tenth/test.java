package DataStruct.Tenth;

import static DataStruct.Tenth.BinarySearch.binarysearch;
import static DataStruct.Tenth.SequenceSearch.sequencesearch;
import static DataStruct.Tenth.SumSearch.sumsearch1;
import static DataStruct.Tenth.SumSearch.sumsearch2;

/**
 * Created by pokedo on 2017/5/16.
 */
public class test {
    public static void main(String args[]) {
        int[] a = getDate();
        int num = 893;
        shuffle(a);
        System.out.println("无序顺序查找 " + num);
        System.out.println("position : " + sequencesearch(a, num));
        a = getDate();
        System.out.println("有序数组O(n)查找两数和 " + num);
        sumsearch1(a, num);
        System.out.println("有序数组O(n*n)查找两数和 " + num);
        sumsearch2(a, num);
        System.out.println("有序二分查找 " + num);
        System.out.println("position : " + binarysearch(a, num));
    }

    public static int[] getDate() {
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = i + 1;
        return a;
    }

    private static void shuffle(int[] a) {
        for (int i = 0; i < a.length; i++)
            exchange(a, i, (int) (Math.random() * 1000));
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
