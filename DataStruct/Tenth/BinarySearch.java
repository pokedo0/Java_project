package DataStruct.Tenth;

import java.util.Arrays;

/**
 * Created by pokedo on 2017/5/16.
 */
public class BinarySearch {
    public static void main(String args[]) {
        int[] a = {12, 23, 26, 37, 54, 60, 68, 75, 82, 96};
        System.out.println(binarysearch(a, 96));
    }

    //二分查找
    public static int binarysearch(int[] a, int num) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] < num)
                lo = mid + 1;
            else if (a[mid] > num)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
