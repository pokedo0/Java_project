package Algorithms.demo301;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by pokedo on 2017/2/14.
 */
public class LinearProbingHashST<Key, Value> {
    private final static int INIT_CAP = 4;
    private int N;
    private int M = 4;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        this(INIT_CAP);
    }

    public LinearProbingHashST(int cap) {
        //初始化变量时候记得赋值
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];
        M = cap;
        N = 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size(){
        return this.N;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void delete(Key key) {
        if (get(key) == null)
            return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        N--;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        if (N > 0 && N == M / 8)
            resize(M / 2);
    }

    public void put(Key key, Value val) {
        if (N >= M / 2)
            resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                queue.enqueue(keys[i]);
        return queue;
    }

    public static void main(String args[]) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();
        st.put("S", 0);
        st.put("E", 1);
        st.put("A", 2);
        st.put("E", 5);
        st.put("B", 3);
        st.put("G", 3);
        st.delete("e");

        for (String word : st.keys()) {
            System.out.println(word + "    " + st.get(word));
        }
    }

}
