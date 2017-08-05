package Algorithms.demo120;

import Algorithms.Base.Base;
import Algorithms.BinarySearch.BinarySearch;

import java.util.Arrays;

/**
 * Created by pokedo on 2017/1/18.
 */
public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (BinarySearch.rank(-a[i] - a[j], a) > j)
                    cnt++;
        return cnt;
    }
    public static void main(String args[]){
        int[] a = Base.readInts("Algorithms/algs4-data/4Kints.txt");
        System.out.println(count(a));
    }
}
