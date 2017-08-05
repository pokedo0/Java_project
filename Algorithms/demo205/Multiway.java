package Algorithms.demo205;

import Algorithms.Base.Base;
import com.sun.deploy.util.ArrayUtil;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pokedo on 2017/1/28.
 */
public class Multiway {
    public static void main(String args[]) {
        String[] str1 = Base.readString("Algorithms/algs4-data/m1.txt").split(" ");
        String[] str2 = Base.readString("Algorithms/algs4-data/m2.txt").split(" ");
        String[] str3 = Base.readString("Algorithms/algs4-data/m3.txt").split(" ");
        //use arraylist to Combine muli-arrays
        List list = new ArrayList(Arrays.asList(str1));
        list.addAll(Arrays.asList(str2));
        list.addAll(Arrays.asList(str3));

        int N = list.size();
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);

        //±éÀúlist£¬pq²åÈëÔªËØ
        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).toString());
            pq.insert(i, list.get(i).toString());
        }

        while (pq.isEmpty())
            System.out.println(pq.minKey());
    }
}
