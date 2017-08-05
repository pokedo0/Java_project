package DataStruct.Fourth;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    Node head = new Node();
    Node last = new Node();
    int N;

    @Override
    public Iterator<T> iterator() {
        return new ListIterable();
    }

    private class ListIterable implements Iterator {
        Node current = head.next;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            T t = current.item;
            current = current.next;
            return t;
        }
    }

    private class Node {
        Node next;
        T item;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }
    }

    public void enqueue(T item) {
        Node node = new Node(item);
        if (head.next == null) {
            head.next = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
    }

    public T dequeue() {
        T t = head.next.item;
        head.next = head.next.next;
        N--;
        return t;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        for (int w : queue)
            System.out.println(w);
    }
}
