package Algorithms.demo323;

import Algorithms.Base.Base;
import Algorithms.demo301.LinearProbingHashST;

/**
 * Created by pokedo on 2017/2/15.
 */
public class SparseVector {
    private LinearProbingHashST<Integer, Double> st;

    public SparseVector() {
        st = new LinearProbingHashST<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.contains(i))
            return 0.0;
        else
            return st.get(i);
    }

    public double dot(double[] x) {
        double sum = 0.0;
        for (int i : st.keys())
            sum += this.get(i) * x[i];
        return sum;
    }

    public static void main(String args[]) {
        String[] arr = Base.readStrings("Algorithms/algs4-data/vector1.txt");
        int N = arr.length;
        //初始化vector数组
        SparseVector[] a = new SparseVector[N];
        for (int i = 0; i < N; i++) {
            a[i] = new SparseVector();
            String[] str = arr[i].split("\\s");
            for (int j = 0; j < N; j++) {
                double num = Double.parseDouble(str[j]);
                //遍历稀疏矩阵，a[i].put 对应位置的元素
                if (num != 0.0) 
                    a[i].put(j, num);
            }
        }

        //初始化向量组
        arr = Base.readStrings("Algorithms/algs4-data/vector2.txt");
        N = arr.length;
        double[] x = new double[N];
        for (int i = 0; i < N; i++) {
            double num = Double.parseDouble(arr[i]);
            x[i] = num;
        }

        double b[] = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i].dot(x);
            System.out.println(b[i]);
        }
    }
}
