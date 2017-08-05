package Match;
/*
将num[]上每位数都轮流与a[]上每位数字赋值一次，并在remarked[]相应位置记录为true，
执行dfs(cur+1)，在下一位进行同样操作，遍历a[]，当对应位置的remarked[]为false，
可以进行赋值。
 */
public class Range {
    //数据源
    static int[] a = {1, 2, 3, 4};
    //从中选k个数
    static int k;
    //num[]用于存放数据
    static int[] num;
    static int len;
    static int count;
    //记录当前dfs()中对应位置的a[i]是否被访问过
    static boolean[] remarked;

    //cur为num[]上的第cur个位置
    public static void dfs(int cur) {
        //当cur==要从中选取的个数时，打印结果
        if (cur == k) {
            print();
            count++;
            return;
        }
        //每次都对a[]进行遍历，未访问过则在当前位置num[]赋值
        for (int i = 0; i < len; i++) {
            if (!remarked[i]) {
                num[cur] = a[i];
                remarked[i] = true;
                dfs(cur + 1);
                remarked[i] = false;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < k; i++)
            System.out.print(num[i]);
        System.out.println();
    }

    public static void main(String args[]) {
        k = 2;
        len = a.length;
        num = new int[k];
        remarked = new boolean[len];
        dfs(0);
        System.out.println(count);
    }
}
