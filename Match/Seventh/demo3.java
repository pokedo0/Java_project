package Match.Seventh;


//凑算式
//
//        B      DEF
//        A + --- + ------- = 10
//        C      GHI
//
//        （如果显示有问题，可以参见【图1.jpg】）
//
//
//        这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
//
//        比如：
//        6+8/3+952/714 就是一种解法，
//        5+3/1+972/486 是另一种解法。
//
//        这个算式一共有多少种解法？
//
//result : 2

public class demo3 {
    static int N = 0;

    public static void allrange(int[] a, int idx) {
        int len = a.length;
        if (idx == len) {   //idx到最后一位，只有一个元素，输出
            if (fun(a)) {
                N++;
                print(a);
            }
        }
        for (int i = idx; i < len; i++) {
            swap(a, idx, i);    //将idx后的每个元素都逐个交换到idx位置上
            allrange(a, idx + 1);   //当idx位置确定后，往idx后面递归
            swap(a, idx, i);    //换过去后再还原
        }
    }

    private static boolean fun(int[] a) {
        //直接转换成double去算
        if (a[0] + (double) a[1] / a[2] + (double) (a[3] * 100 + a[4] * 10 + a[5]) / (a[6] * 100 + a[7] * 10 + a[8]) == 10)
            return true;
        return false;
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        allrange(a, 0);
        System.out.println(N);
    }
}
