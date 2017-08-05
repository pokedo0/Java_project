package Algorithms.demo236;

import java.util.Iterator;

/**
 * Created by pokedo on 2017/2/5.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int size;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
            size++;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key))
                return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public int size() {
        return size;
    }

    public Iterable<Key> keys() {
        return new ListIterator();
    }

    private class ListIterator implements Iterable<Key> {
        @Override
        public Iterator<Key> iterator() {
            return new Iterator<Key>() {
                private Node current = first;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public Key next() {
                    Key key = current.key;
                    current = current.next;
                    return key;
                }
            };
        }
    }


    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            size--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public static void main(String args[]) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST();
        st.put("S", 0);
        st.put("E", 1);
        st.put("A", 2);
        st.put("E", 3);
        st.put("B", 3);
        st.put("G", 3);
        for (String word : st.keys()) {
            System.out.println(word + "    " + st.get(word));
        }
    }


}
