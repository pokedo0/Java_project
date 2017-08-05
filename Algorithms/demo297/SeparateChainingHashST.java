package Algorithms.demo297;

import Algorithms.demo236.SequentialSearchST;
import edu.princeton.cs.algs4.Queue;


/**
 * Created by pokedo on 2017/2/14.
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    public SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    public boolean contains(Key key) {
        if (get(key) == null)
            return false;
        else
            return true;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < st.length; i++)
            for (Key key : st[i].keys())
                queue.enqueue(key);
        return queue;
    }

    public static void main(String args[]) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
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
    }


}
