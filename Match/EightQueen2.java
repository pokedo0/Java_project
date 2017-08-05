package Match;

/**
 * Created by pokedo on 2017/4/7.
 */
public class EightQueen2 {
    static int[] a;
    static boolean[] marked;
    static int N;

    //对1-8进行全排列
    //a[i]表示第i行的i皇后,因此不会出现横竖冲突问题
    public static void main(String args[]) {
        a = new int[9];
        marked = new boolean[9];
        dfs(1);
        System.out.println(N);
    }

    //当前行数
    private static void dfs(int cur) {
        if (cur == 9) {
            print();
            N++;
            return;
        }
        for (int i = 1; i <= 8; i++) {
            if (!marked[i]) {
                marked[i] = true;
                a[cur] = i;
                if (check(cur))
                    dfs(cur + 1);
                marked[i] = false;
                a[cur] = 0;
            }
        }
    }

    //检查对角皇后
    private static boolean check(int cur) {
        for (int i = 1; i < cur; i++)
            if (Math.abs(i - cur) == Math.abs(a[cur] - a[i]))
                return false;
        return true;
    }


    private static void print() {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();

        int n = a.length;
        for (int i : a) {
            if (i == 0)
                continue;
            for (int j = 1; j < n; j++) {
                if (j != i)
                    System.out.print("-" + " ");
                else
                    System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
