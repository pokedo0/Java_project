package Match.Seventh;

/**
 * 密码脱落
 * <p>
 * X星球的考古学家发现了一批古代留下来的密码。
 * 这些密码是由A、B、C、D 四种植物的种子串成的序列。
 * 仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。
 * 由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。
 * <p>
 * 你的任务是：
 * 给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子。
 * <p>
 * 输入一行，表示现在看到的密码串（长度不大于1000）
 * 要求输出一个正整数，表示至少脱落了多少个种子。
 * <p>
 * 例如，输入：
 * ABCBA
 * 则程序应该输出：
 * 0
 * <p>
 * 再例如，输入：
 * ABDCDCBABC
 * 则程序应该输出：
 * 3
 * <p>
 * //思路 ：result = 逆序最长公共子序列.len() - 初始序列.len()
 */
public class demo9_CA {
    public static void main(String args[]) {
        String s1 = "ABDCDCBABC";
        StringBuilder b = new StringBuilder();
        //s2是s1的倒序
        for (int i = s1.length() - 1; i >= 0; i--)
            b.append(s1.charAt(i));
        String s2 = b.toString();

        //LCS
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++)
            dp[i][0] = 0;
        for (int i = 0; i < len2; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1]);


        System.out.println(len1 - dp[len1][len2]);
    }

    private static int Max(int i, int j) {
        if (i >= j)
            return i;
        return j;
    }
}
