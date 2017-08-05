package Match.Sixth;

/**
 * 今有7对数字：两个1，两个2，两个3，...两个7，把它们排成一行。
 * 要求，两个1间有1个其它数字，两个2间有2个其它数字，以此类推，两个7之间有7个其它数字。如下就是一个符合要求的排列：
 * <p>
 * 17126425374635
 * <p>
 * 当然，如果把它倒过来，也是符合要求的。
 * <p>
 * 请你找出另一种符合要求的排列法，并且这个排列法是以74开头的。
 */
public class demo4_2 {
    static boolean[] marked = new boolean[7];
    static int[] num = new int[14];

    public static void main(String args[]) {
        int[] a = new int[7];
        for (int i = 0; i < 7; i++)
            a[i] = i + 1;
        num[0] = 7;
        num[8] = 7;
        num[1] = 4;
        num[6] = 4;
        dfs(a, 0);
    }

    //按cur位置 dfs(),每次dfs()后，都要从1-7中寻找可填数字，找不到合适的，
    // 返回上个位置再找另一个合适的数字
    private static void dfs(int[] a, int cur) {
        if (cur == 14) {
            print();
            return;
        }
        if (cur == 0 || cur == 8 || cur == 1 || cur == 6 || num[cur] != 0) {
            dfs(a, cur + 1);
        }
        for (int i = 0; i < 7; i++) {
            //当 当前位置需要填写4|7，直接continue;
            if (i == 3 || i == 6)
                continue;
            if (!marked[i]) {
                //当前位置
                if (cur + i + 1 + 1 >= 14 || num[cur] != 0 || num[cur + i + 1 + 1] != 0)
                    continue;
                num[cur] = a[i];
                num[cur + i + 1 + 1] = a[i];
                marked[i] = true;
                dfs(a, cur + 1);
                //该位置不符合时，需要重新置零
                num[cur] = 0;
                num[cur + i + 1 + 1] = 0;
                marked[i] = false;
            }
        }
    }

    private static void print() {
        for (int i : num)
            System.out.print(i + " ");
        System.out.println();
    }


}
