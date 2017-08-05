package Algorithms.demo252;

import com.sun.javafx.image.BytePixelSetter;
import edu.princeton.cs.algs4.Queue;


/**
 * Created by pokedo on 2017/2/8.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
//        非递归
//        Node x = root;
//        while (x != null) {
//            int cmp = key.compareTo(x.key);
//            if (cmp < 0)
//                x = x.left;
//            else if (cmp > 0)
//                x = x.right;
//            else return x.val;
//        }
//        return null;
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = x.key.compareTo(key);
        if (cmp < 0)
            return get(x.right, key);
        else if (cmp > 0)
            return get(x.left, key);
        else
            return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
        //非递归
//        Node x = root;
//        while(x.left != null){
//            x = x.left;
//        }
//        return x.key;

    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
//        非递归
//        Node x = root;
//        while(x.right != null){
//            x = x.right;
//        }
//        return x.key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
//        非递归
//        Node x = root;
//        Node t = null;
//        while (x != null) {
//            int cmp = key.compareTo(x.key);
//            if (cmp == 0)
//                return x.key;
//            else if (cmp < 0) {
//                x = x.left;
//            } else {
//                t = x;
//                x = x.right;
//            }
//        }
//        if (t != null)
//            return t.key;
//        else
//            return null;

    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key select(int k) {
//        return select(root, k).key;
        Node x = root;
        while (x != null) {
            int t = size(x.left);
            if (t > k)
                x = x.left;
            else if (t < k) {
                k = k - t - 1;
                x = x.right;
            } else return x.key;
        }
        return null;
    }

    private Node select(Node x, int k) {
        if (x == null)
            return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x;
    }

    public int rank(Key key) {
        return rank(key, root);
//          非递归
//        Node x = root;
//        int temp = 0;
//        while (x != null) {
//            int cmp = key.compareTo(x.key);
//            if (cmp < 0)
//                x = x.left;
//            else if (cmp > 0) {
//                temp += size(x.left) + 1;       //保存temp
//                x = x.right;
//            } else return size(x.left) + temp;
//        }
//        return (temp + 0);      //找不到对应key时，要返回key前面的元素数量
    }

    private int rank(Key key, Node x) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
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
        BST<String, Integer> st = new BST<>();
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
        System.out.println("st.select(4) : " + st.select(4));
        System.out.println("st.rank(\"X\") : " + st.rank("X"));
        System.out.println("st.floor(\"X\") : " + st.floor("X"));
    }

}

