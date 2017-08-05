package DataStruct.Third.DuLinkedListCom;

/**
 * 双向链表合并多项式
 * Created by pokedo on 2017/3/18.
 */
public class DuLinkedListCom {
    Node head = new Node();
    Node last = new Node();
    int N;

    //双向链表
    private class Node {
        Node pre;
        Node next;
        //系数
        double coefficient;
        //指数
        int index;

        public Node() {
        }

        public Node(double coefficient, int index) {
            this.coefficient = coefficient;
            this.index = index;
        }
    }


    public void add(double cofficient, int index) {
        Node node = new Node(cofficient, index);
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            last = node;
        } else {
            last.next = node;
            node.pre = last;
            last = node;
        }
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        if (head.next != null)
            return false;
        return true;
    }

    //打印链表值
    public void show() {
        if (head.next == null) {
            System.out.println("No element");
            return;
        }
        for (Node p = head.next; p != null; p = p.next) {
            System.out.print(p.coefficient + "x^" + p.index + " ");
        }
    }

    //倒序打印链表值
    public void ReverseShow() {
        if (head.next == null) {
            System.out.println("No element");
            return;
        }
        for (Node p = last; p != head; p = p.pre) {
            System.out.print(p.coefficient + "x^" + p.index + " ");
        }
    }

    //合并链表list1, list2, 返回新的list
    public DuLinkedListCom combine(DuLinkedListCom list1, DuLinkedListCom list2) {
        //p,q遍历指向list1,list2的结点
        Node p = list1.head.next;
        Node q = list2.head.next;
        DuLinkedListCom list = new DuLinkedListCom();
        /**
         * @idx1 p的指数
         * @idx2 q的指数
         * @cof1 p的系数
         * @cof2 q的系数
         */
        int idx1;
        int idx2;
        double cof1;
        double cof2;
        while (true) {
            //当p,q当前不为空
            if (p != null && q != null) {
                idx1 = p.index;
                idx2 = q.index;
                cof1 = p.coefficient;
                cof2 = q.coefficient;
                if (idx1 > idx2) {
                    list.add(cof2, idx2);
                    q = q.next;
                }
                else if (idx1 < idx2) {
                    list.add(cof1, idx1);
                    p = p.next;
                } else {
                    //如果p,q的指数相同，合并系数
                    list.add(cof1 + cof2, idx1);
                    p = p.next;
                    q = q.next;
                }
                //p为空，q不为空
            } else if (p == null && q != null) {
                idx2 = q.index;
                cof2 = q.coefficient;
                list.add(cof2, idx2);
                q = q.next;
                //p不为空，q为空
            } else if (p != null && q == null) {
                idx1 = p.index;
                cof1 = p.coefficient;
                list.add(cof1, idx1);
                p = p.next;
            } else
                break;
        }
        return list;
    }

    public static void main(String args[]) {
        DuLinkedListCom list1 = new DuLinkedListCom();
        System.out.print("list1 : ");
        list1.add(-1, 1);
        list1.add(2, 2);
        list1.add(-3, 3);
        list1.add(4, 5);
        list1.add(1, 7);
        list1.show();

        System.out.println();
        System.out.print("list2 : ");
        DuLinkedListCom list2 = new DuLinkedListCom();
        list2.add(1, 1);
        list2.add(2, 2);
        list2.add(3, 4);
        list2.add(4, 6);
        list2.show();

        System.out.println();
        System.out.print("list3 : ");
        DuLinkedListCom list3 = new DuLinkedListCom();
        list3 = list3.combine(list1, list2);
        list3.show();
        System.out.println("\nReverse : ");
        System.out.print("list3 : ");
        list3.ReverseShow();
    }
}
