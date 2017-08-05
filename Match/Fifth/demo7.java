package Match.Fifth;

/**
 * A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
 要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。

 请填写出所有符合要求的排列中，字典序最小的那个。

 例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
 */
public class demo7 {
    public static void main(String args[]) {
        int[] num = new int[9];
        dfs(num, 1);
    }

    private static void dfs(int[] num, int cur) {
        if (cur == 5) {
            print(num);
            return;
        }
        for (int i = 1; i <= 8; i++) {
            if (num[i] == 0 && (i + cur + 1) <= 8 && num[i + cur + 1] == 0) {
                num[i] = cur;
                num[i + cur + 1] = cur;
                dfs(num, cur + 1);
                num[i] = 0;
                num[i + cur + 1] = 0;
            }
        }
    }

    private static void print(int[] num) {
        for (int i : num)
            System.out.print(i);
        System.out.println();
        //23421314 即2342A3A4
    }
}
