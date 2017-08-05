package Algorithms.demo1;

/**
 * Created by pokedo on 2017/1/12.
 */
public class demo1 {
    //是否为素数
    public static boolean isPrime(int N) {
        if (N < 2)
            return false;
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    public static double osqrt(double c, double e) {
        double low = 0;
        double high = c;
        double guess, e0;
        int count = 0;
        do {
            guess = (high + low) / 2;
            if (guess * guess > c) {
                high = guess;
                e0 = guess * guess - c;
            } else {
                low = guess;
                e0 = c - guess * guess;
            }
            count++;
        } while (e0 > e);
        System.out.println("times:" + count);
        return guess;
    }

    //计算平方根(牛顿迭代法)
    public static double sqrt(double c) {
        int count = 0;
        if (c < 0)
            return Double.NaN;
        double err = 1e-15;  //err误差范围
        double t = c;
        //Math.abs(t - c / t) == t-(c/t + t )/ 2.0 ;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
            count++;
        }
        System.out.println("times:" + count);
        return t;
    }

    public static void main(String args[]) {
        int a = 2;
        System.out.println("素数:" + isPrime(a));
        System.out.println("二分法平方根" + osqrt(a, 0.001));
        System.out.println("牛顿法平方根:" + sqrt(a));
    }
}
