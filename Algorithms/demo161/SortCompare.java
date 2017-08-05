package Algorithms.demo161;

import Algorithms.demo156.Selection;
import Algorithms.demo157.Insertion;
import Algorithms.demo163.Shell;

import java.util.Random;

/**
 * Created by pokedo on 2017/1/22.
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        long start = System.currentTimeMillis();
        if (alg.equals("Insertion"))
            Insertion.sort(a);
        if (alg.equals("Selection"))
            Selection.sort(a);
        if(alg.equals("Shell"))
            Shell.sort(a);
//        if(alg.equals("Insertion"))
//            Insertion.sort(a);
//        if(alg.equals("Insertion"))
//            Insertion.sort(a);
//        if(alg.equals("Insertion"))
//            Insertion.sort(a);
//        if(alg.equals("Insertion"))
//            Insertion.sort(a);
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for(int i =0 ;i<N;i++)
                a[i] = new Random(System.currentTimeMillis()).nextDouble();
            total+=time(alg,a);
        }
        return total;
    }

    public static void main(String args[]){
        String alg1  =  "Insertion";
        String alg2  =  "Shell";
        double t1 = timeRandomInput(alg1,1000,100);
        double t2 = timeRandomInput(alg2,1000,100);
        System.out.println("t1: "+t1);
        System.out.println("t2: "+t2);
        System.out.println(alg2+" is "+t1/t2+" times faster than "+alg1);
    }
}
