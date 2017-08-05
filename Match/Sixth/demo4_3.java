package Match.Sixth;

/**
 * Created by pokedo on 2017/4/2.
 */
public class demo4_3 {

    public static void main(String args[]) {
        int[] a = new int[15];
        a[1] = 7;
        a[2] = 4;
        a[9] = 7;
        a[7] = 4;
        //n为要填写的数字
        dfs(a, 1);
    }

    //n按数字 1-7(除4,7) dfs(),每次都要检查1-14的位置,看哪个位置适合填写
    private static void dfs(int[] a, int n) {
        if (n == 4)
            dfs(a, n + 1);
        //注意到7的时候就输出
        if (n == 7)
            print(a);
        for (int i = 3; i <= 14; i++) {
            //注意三个条件,当前位置==0,后面对应位置==0,不越界
            if (i + n + 1 <= 14 && a[i] == 0 && a[i + n + 1] == 0) {
                a[i] = a[i + n + 1] = n;
                dfs(a, n + 1);
                a[i] = a[i + n + 1] = 0;
            }
        }
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }
}
