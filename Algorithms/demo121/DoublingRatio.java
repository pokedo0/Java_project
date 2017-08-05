package Algorithms.demo121;

import Algorithms.demo109.ThreeSum;
import Algorithms.demo120.ThreeSumFast;

import java.util.Random;

/**
 * Created by pokedo on 2017/1/18.
 */
public class DoublingRatio {
    public static double timeTrial(int N) {
        int MAX = 10000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            //生成-MAX ~ MAX的一个随机整数
            int rand = -MAX + new Random(System.currentTimeMillis()).nextInt(2 * MAX);
            a[i] = rand;
        }
        long start = System.currentTimeMillis();
        int cnt = ThreeSum.count(a);
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }

    public static void main(String args[]) {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.println("N:" + N + "  " + "time: " + time + "  " + "ratio: " + time / prev);
            prev = time;
        }
    }

}
