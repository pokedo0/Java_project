package Algorithms.demo111;

import Algorithms.demo109.ThreeSum;

import java.util.Random;

/**
 * Created by pokedo on 2017/1/18.
 */
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            //Éú³É
            int rand = -MAX + new Random(System.currentTimeMillis()).nextInt(2 * MAX);
            a[i] = rand;
        }
        long start = System.currentTimeMillis();
        int cnt = ThreeSum.count(a);
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }

    public static void main(String args[]) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.println("N:" + N + "  " + "time: " + time);
        }
    }
}
