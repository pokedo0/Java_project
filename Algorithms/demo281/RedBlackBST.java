package Algorithms.demo281;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by pokedo on 2017/2/13.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return
                x.color == RED;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = put(h.left, key, val);
        else if (cmp > 0)
            h.right = put(h.right, key, val);
        else
            h.val = val;
        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }
        return null;
    }

    public Key min() {
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    public Key max() {
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

    public boolean contains(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp<0)
                x = x.left;
            else if(cmp>0)
                x = x.right;
            else
                return true;
        }
        return false;

    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }


    public static void main(String args[]) {
        RedBlackBST<String, Integer> st = new RedBlackBST<>();
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
        System.out.println("st.min() : " + st.min());
        System.out.println("st.max() : " + st.max());
//        System.out.println("st.select(4) : " + st.select(4));
//        System.out.println("st.rank(\"X\") : " + st.rank("X"));
//        System.out.println("st.floor(\"X\") : " + st.floor("X"));
    }


}
