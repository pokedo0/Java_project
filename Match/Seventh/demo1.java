package Match.Seventh;

//煤球数目
//
//有一堆煤球，堆成三角棱锥形。具体：
//第一层放1个，
//第二层3个（排列成三角形），
//第三层6个（排列成三角形），
//第四层10个（排列成三角形），
//....
//如果一共有100层，共有多少个煤球？
//
//请填表示煤球总数目的数字。
public class demo1 {
    public static void main(String args[]) {
        System.out.println(fun2(100));
    }

    //第n层个数
    static int fun(int n) {
        return (1 + n) * n / 2;
    }

    //前n层个数
    private static int fun2(int n) {
        if (n == 1)
            return 1;
        return fun2(n - 1) + fun(n);
    }
}
