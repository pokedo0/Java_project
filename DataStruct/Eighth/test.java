package DataStruct.Eighth;

import java.util.Arrays;

import static DataStruct.Eighth.BubbleSort.bubblesort;
import static DataStruct.Eighth.InsertSort.insertsort;
import static DataStruct.Eighth.QuickSort.quicksort;
import static DataStruct.Eighth.SelectSort.selectsort;
import static DataStruct.Eighth.ShellSort.shellsort;

public class test {
    public static void main(String args[]) {
        int[] a;
        a = getData(100, 0);
        System.out.println("100正序 : ");
        timing(a);
        a = getData(100, 1);
        System.out.println("100逆序 : ");
        timing(a);
        a = getData(100, 2);
        System.out.println("100乱序 : ");
        timing(a);
        a = getData(1000, 0);
        System.out.println("1000正序 : ");
        timing(a);
        a = getData(1000, 1);
        System.out.println("1000逆序 : ");
        timing(a);
        a = getData(1000, 2);
        System.out.println("1000乱序 : ");
        timing(a);
        a = getData(1000000, 0);
        System.out.println("1000000正序 : ");
        timing(a);
        a = getData(1000000, 1);
        System.out.println("1000000逆序 : ");
        timing(a);
        a = getData(1000000, 2);
        System.out.println("1000000乱序 : ");
        timing(a);
    }

    private static void timing(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        double start;
        double end;
        start = System.currentTimeMillis();
        bubblesort(a);
        end = System.currentTimeMillis();
        System.out.println("BubbleSort\t" + (end - start) / 1000);
        a = Arrays.copyOf(arr, arr.length);

        start = System.currentTimeMillis();
        selectsort(a);
        end = System.currentTimeMillis();
        System.out.println("SelectSort\t" + (end - start) / 1000);
        a = Arrays.copyOf(arr, arr.length);

        start = System.currentTimeMillis();
        insertsort(a);
        end = System.currentTimeMillis();
        System.out.println("InsertSort\t" + (end - start) / 1000);
        a = Arrays.copyOf(arr, arr.length);

        start = System.currentTimeMillis();
        shellsort(a);
        end = System.currentTimeMillis();
        System.out.println("ShellSort\t" + (end - start) / 1000);
        a = Arrays.copyOf(arr, arr.length);

        start = System.currentTimeMillis();
        quicksort(a);
        end = System.currentTimeMillis();
        System.out.println("QuickSort\t" + (end - start) / 1000);
        a = Arrays.copyOf(arr, arr.length);

        System.out.println();
    }


    /**
     * 返回一组测试数据
     *
     * @param cout 生成数组长度
     * @param mode 0 - 正序
     *             1 - 逆序
     *             其他 - 乱序
     * @return 一个数组
     */
    private static int[] getData(int cout, int mode) {
        int[] a = new int[cout];
        if (mode == 0)  //正序
            for (int i = 0; i < cout; i++)
                a[i] = i;
        else if (mode == 1) //逆序
            for (int i = 0; i < cout; i++)
                a[i] = cout - i;
        else {  //乱序
            a = getData(cout, 0);
            for (int i = 0; i < a.length; i++) {
                int j = (int) (Math.random() * cout);
                exchange(a, i, j);
            }
        }
        return a;
    }

    //测试是否已排好序,逆序，正序，常数都算有序
    private static boolean isSort(int[] a) {
        boolean uflag = false;
        boolean dflag = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                dflag = true;
            else if (a[i] < a[i + 1])
                uflag = true;
            else if (a[i] == a[i + 1])
                continue;
            if (uflag && dflag)
                return false;
        }
        return true;
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void exchange(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
