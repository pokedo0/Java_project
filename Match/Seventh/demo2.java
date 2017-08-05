package Match.Seventh;

//生日蜡烛
//
//        某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
//
//        现在算起来，他一共吹熄了236根蜡烛。
//
//        请问，他从多少岁开始过生日party的？
//
//        请填写他开始过生日party的年龄数。

// result:26
public class demo2 {
    public static void main(String args[]) {
        int sum = 0;
        for (int i = 1; i < 200; i++)
            for (int j = i; j < 200; j++) {
                sum += j;
                if (sum == 236) {
                    System.out.println(i);
                    break;
                } else if(sum >236) {
                    sum = 0;
                    break;
                }
            }
    }
}
