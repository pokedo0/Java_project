package Match.Seventh;

/**
 * 骰子游戏
 * <p>
 * 我们来玩一个游戏。
 * 同时掷出3个普通骰子（6个面上的数字分别是1~6）。
 * 如果其中一个骰子上的数字等于另外两个的和，你就赢了。
 * <p>
 * 下面的程序计算出你能获胜的精确概率（以既约分数表示）
 * <p>
 * <p>
 * public class Main
 * {
 * public static int gcd(int a, int b)
 * {
 * if(b==0) return a;
 * return gcd(b,a%b);
 * }
 * <p>
 * public static void main(String[] args)
 * {
 * int n = 0;
 * for(int i=0; i<6; i++)
 * for(int j=0; j<6; j++)
 * for(int k=0; k<6; k++){
 * if(________________________________) n++;   //填空位置
 * }
 * <p>
 * int m = gcd(n,6*6*6);
 * System.out.println(n/m + "/" + 6*6*6/m);
 * }
 * }
 */
public class demo5_JC {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                for (int k = 0; k < 6; k++) {
                    if (i + 1 == j + k + 1 + 1 || j + 1 == i + k + 1 + 1 || k + 1 == j + i + 1 + 1) n++;   //填空位置
                }

        int m = gcd(n, 6 * 6 * 6);
        System.out.println(n / m + "/" + 6 * 6 * 6 / m);
    }
}

/*
此题的答案是：i + j+2 == k+1 || i + k+2 == j+1 || k + j+2 == i+1，
许多人都将答案写成了"i + j == k || i + k == j || k + j == i"。
既约分数就是最简分数的意思，分析可得：“能获胜的精确概率=获胜的情况总数 / 总情况数”，同时
掷出3个骰子一共会有6*6*6种情况，根据“int m = gcd(n,6*6*6);”可以得出n就是“获胜的情况总
数”，gcd()该方法是为了求出它们的最大公约数，然后写出既约分数。三层for循环就代表了骰子的点
数，但是这里有一个“陷阱”，就是for循环表示出来的骰子点数为0~5，但是真实的骰子点数为1~6，两
者算出来的结果是截然不同的！所以我们需要将i、k、j分别加1。
 */

