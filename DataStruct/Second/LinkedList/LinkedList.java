package DataStruct.Second.LinkedList;

import java.util.Iterator;

public class LinkedList<T extends Comparable> implements Iterable<T> {
    private Node head = new Node();
    private Node last = new Node();
    private int N;

    private class Node {
        Node next;
        T item;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }
    }

    public int size() {
        return N;
    }

    public void add(T item) {
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

    public boolean isEmpty() {
        if (head.next != null)
            return false;
        else
            return true;
    }


    /**
     * 二步长倒序 a,b距离间隔一个node
     */
    public void reverse2() {
        Node a = head;
        Node b = a.next.next;
        while (a != last && a.next != last) {
            a.next.next = b.next;
            b.next = a.next;
            a.next = b;

            a = b.next;
            if (a.next != null)
                b = a.next.next;
            else
                break;
        }
    }

    /**
     * 完全倒序
     * 方法3：从第2个节点到第N个节点，依次逐节点插入到
     * 第1个节点(head节点)之后，最后将第一个节点挪到新表的表尾。
     */
    public void reverseAll() {
        Node a = head.next;
        Node b;
        while (a.next != null) {
            b = a.next;
            a.next = b.next;
            b.next = head.next;
            head.next = b;
        }
        last = a;
    }

    /**
     * 两条list合成一条list,按升序合并
     * 理想情况下的list1,list2应已排序好
     *
     * @param list1
     * @param list2
     * @return LinkedList
     */
    public LinkedList<T> combine(LinkedList<T> list1, LinkedList<T> list2) {
        LinkedList<T> list = new LinkedList<T>();
        //p ,q 按顺序保存list1,list2的结点
        Node p = list1.head.next;
        Node q = list2.head.next;
        //a,b保存 p,q的值
        T a = null;
        T b = null;
        while (true) {
            if (p != null)
                a = p.item;
            else
                a = null;
            if (q != null)
                b = q.item;
            else
                b = null;
            //当a<b或list2为空时,插入 list1 结点的值
            if (a != null && b != null && a.compareTo(b) < 0 || b == null && a != null) {
                list.add(a);
                p = p.next;
            } else if (a != null && b != null && a.compareTo(b) > 0 || a == null && b != null) {
                //当a>b或list1为空时,插入 list2 结点的值
                list.add(b);
                q = q.next;
            } else if (a != null && b != null && a.compareTo(b) == 0) {
                //a==b时 list1,list2的结点都插入
                list.add(a);
                list.add(b);
                p = p.next;
                q = q.next;
            } else
                break;
        }
        return list;
    }

    //得到迭代器,方便遍历
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head.next;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        System.out.println("list :");
        Iterator<Integer> ite = list.iterator();
        while (ite.hasNext())
            System.out.print(ite.next() + " ");
        list.reverse2();
        System.out.println("\nreverse2():");
        ite = list.iterator();
        while (ite.hasNext()) {
            System.out.print(ite.next() + " ");
        }
        list.reverseAll();
        System.out.println("\nreverseAll():");
        ite = list.iterator();
        while (ite.hasNext())
            System.out.print(ite.next() + " ");
        //重新倒序得到原来的list
        list.reverseAll();
        list.reverse2();

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(9);
        list2.add(10);
        list2.add(11);
        System.out.println();
        System.out.println("\nlist2 : ");
        Iterator<Integer> ite2 = list2.iterator();
        while (ite2.hasNext()) {
            System.out.print(ite2.next() + " ");
        }

        System.out.println("\nlist3 Combine(list, list2) : ");
        //list3保存合并后的新链表
        LinkedList<Integer> list3 = new LinkedList<>();
        list3 = list3.combine(list, list2);
        Iterator<Integer> ite3 = list3.iterator();
        while (ite3.hasNext())
            System.out.print(ite3.next() + " ");
    }
}
