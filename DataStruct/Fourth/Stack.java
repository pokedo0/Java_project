package DataStruct.Fourth;

import java.util.Iterator;

public class Stack<T> implements Iterable<Integer> {
    Node head = new Node();
    Node last = new Node();

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {
        private Node current = head.next;

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
        T item;
        Node next;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }
    }

    public void push(T item) {
        Node node = new Node(item);
        node.next = head.next;
        head.next = node;
    }

    public T pop() {
        if (head.next != null) {
            T item = head.next.item;
            head.next = head.next.next;
            return item;
        } else throw new NullPointerException();
    }

    public T peek() {
        return head.next.item;
    }

    public boolean isEmpty() {
        return head.next == null;
    }
}
