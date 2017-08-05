package Algorithms.demo196;

import Algorithms.Base.Base;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Transaction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by pokedo on 2017/1/28.
 */
public class TopM {
    public static void main(String args[]) {
        int M = 5;
        MinPQ<Transaction> pq = new MinPQ<>(M);
        String[] arr = Base.readStrings("Algorithms/algs4-data/tinyBatch.txt");
        Transaction[] tra = new Transaction[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Transaction temp = new Transaction(arr[i]);
            tra[i] = temp;
            pq.insert(temp);
            if (pq.size() > M)
                pq.delMin();
        }
        //遍历输出结果
        Iterator<Transaction> iterator = pq.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        //Sort by Count
//        Insertion.sort(tra,new Transaction.HowMuchOrder());
//        Arrays.sort(tra,new Transaction.HowMuchOrder());
//        for(Transaction trasact: tra)
//            System.out.println(trasact.toString());

//        Stack<Transaction> stack = new Stack<>();
//        while(!pq.isEmpty())
//            stack.push(pq.delMin());
//        for(Transaction t: stack)
//            System.out.println(t);
    }
}
