package Algorithms.BinarySearch;

import Algorithms.Base.Base;

import java.util.*;

/**
 * Created by pokedo on 2017/1/14.
 */
public class BinarySearch {
    //¶ş·Ö²éÕÒ
    public static int rank(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (key > arr[mid])
                lo = mid + 1;
            else if (key < arr[mid])
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] Whitelist = Base.readInts("Algorithms/algs4-data/tinyT.txt");
        int[] W = Base.readInts("Algorithms/algs4-data/tinyW.txt");
        Arrays.sort(Whitelist);
        for (int i = 0; i < W.length; i++) {
            if (rank(W[i], Whitelist) < 0)
                System.out.println(W[i]);
        }
    }
}
