package DataStruct.Sixth;

//优先队列，队列内的Edge元素根据权值降序排序
public class MinQueue<T extends Comparable> {
    private static int count;

    private class Node {
        Node next;
        Node pre;
        T edge;

        public Node(T e) {
            edge = e;
        }

        public Node() {
        }
    }

    Node head;
    Node last;

    public MinQueue() {
        head = new Node();
        last = head;
    }

    public void add(T e) {
        Node node = new Node(e);
        if (isEmpty()) {
            node.pre = head;
            head.next = node;
            last = node;
        } else {
            Node p;
            for (p = head.next; p != null; p = p.next)
                if (e.compareTo(p.edge) <= 0) {
                    p.pre.next = node;
                    node.pre = p.pre;
                    node.next = p;
                    p.pre = node;
                    break;
                }
            if (p == null) {
                last.next = node;
                node.pre = last;
                last = node;
            }
        }
        count++;
    }

    public T poll() {
        Node node = head.next;
        head.next = head.next.next;
        count--;
        return node.edge;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
