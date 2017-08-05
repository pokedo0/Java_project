package Algorithms.demo239;


import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by pokedo on 2017/2/7.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }


    public BinarySearchST() {
        this(2);
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)     //TODO
            return vals[i];
            //i有可能越界==N,也有可能 i<N 而 keys[i]!=key
        else
            return null;
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val) {
        //改变数组长度
        if (N == keys.length)
            resize(keys.length * 2);

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key) {
        if (N == keys.length / 4)
            resize(keys.length / 2);
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            for (int j = i; j < N; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
        keys[N - 1] = null;
        vals[N - 1] = null;
        N--;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return keys[i];
        else
            return keys[i - 1];
    }


    public boolean contains(Key key) {
        return get(key) != null;
    }

    //返回keys，可用foreach遍历
    public Iterable<Key> keys() {
        return this.keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    private void resize(int max) {
        Key[] temp1 = (Key[]) new Comparable[max];
        Value[] temp2 = (Value[]) new Object[max];
        for (int i = 0; i < keys.length; i++) {
            temp1[i] = keys[i];
            temp2[i] = vals[i];
        }
        keys = temp1;
        vals = temp2;
    }

    public static void main(String args[]) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        st.put("S", 0);
        st.put("E", 1);
        st.put("A", 2);
        st.put("E", 3);
        st.put("B", 3);
        st.put("G", 3);
//        st.delete("E");
//        st.delete("S");
        for (String word : st.keys()) {
            System.out.println(word + "    " + st.get(word));
        }
        System.out.println("st.rank(\"X\") : " + st.rank("X"));
        System.out.println("st.floor(\"X\") : " + st.floor("X"));
    }

}
