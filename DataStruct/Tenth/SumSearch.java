package DataStruct.Tenth;

import java.util.Arrays;

/**
 * Created by pokedo on 2017/5/16.
 */
public class SumSearch {
    public static void main(String args[]) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++)
            a[i] = i + 1;
        Arrays.sort(a);
        sumsearch1(a, 100);
    }

    //O(n)时间查找,设置两个lo,hi指针，逐步向中间靠拢查找两数之和sum
    public static void sumsearch1(int[] a, int sum) {
        int lo = 0;
        int hi = a.length - 1;
        int count = 0;
        boolean flag = false;
        while (lo < hi) {
            if (a[lo] + a[hi] > sum)
                hi--;
            else if (a[lo] + a[hi] < sum)
                lo++;
            else {
                flag = true;
                lo++;
                count++;
            }
        }
        if (flag)
            System.out.println("符合条件的对数为 : " + count);
        else
            System.out.println("没有符合条件的一对数");
    }

    //O(n^2)时间查找,暴力枚举
    public static void sumsearch2(int[] a, int sum) {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++)
                if (a[i] + a[j] == sum) {
                    flag = true;
                    count++;
                }
            if (a[i] >= sum)
                break;
        }
        if (flag)
            System.out.println("符合条件的对数为 : " + count);
        else
            System.out.println("没有符合条件的一对数");
    }

}

