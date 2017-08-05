package DataStruct.Ninth;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    static int maxlen;  //当前数组中最大数的最长位数

    public static void main(String args[]) {
        int[] a = {0, 5, 3, 9, 7, 100, 3, 2, 2, 6, 5, 3, 9};
        radixsort(a);
        print(a);
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void radixsort(int[] a) {
        //temp 邻接表，元素为0-9，每个元素为一个queue,按顺序存入基数
        Queue<Integer>[] temp = new Queue[10];
        for (int i = 0; i < temp.length; i++)
            temp[i] = new LinkedList<Integer>();

        maxlen = getMaxLength(a);
        for (int k = 0; k < maxlen; k++) {  //基数需要排序maxlen次
            for (int i = 0; i < a.length; i++) {
                int idx = getNum(a, i, k);
                temp[idx].add(a[i]);
            }

            int j = 0;  //temp中排好序后，按顺序将数据存入a[]中
            for (int i = 0; i < temp.length; i++)
                while (!temp[i].isEmpty())
                    a[j++] = temp[i].poll();
        }
    }

    //得到当前数组中最大数的最长位数，比如最大数是300,则返回3
    private static int getMaxLength(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++)
            if (a[max] < a[i])
                max = i;
        return (a[max] + "").length();
    }

    /**
     * @param a
     * @param i    a[]的第i个位置的数字
     * @param digs a[i]的第digs位数
     * @return 返回a[]数组中第i个位置的数字的第digs位的单个数字, 默认0为最低位数
     */
    private static int getNum(int[] a, int i, int digs) {
        String num = String.valueOf(a[i]);
        int len = maxlen;
        if (num.length() < maxlen)
            len = num.length();
        char c;
        try {
            c = (num + "").charAt(len - digs - 1);
        } catch (Exception e) {
            return 0;
        }
        return Integer.parseInt(c + "");
    }
}
