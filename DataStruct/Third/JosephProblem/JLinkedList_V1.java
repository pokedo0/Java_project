package DataStruct.Third.JosephProblem;

/**
 * Created by pokedo on 2017/3/15.
 */
public class JLinkedList_V1 {
    private Node head = new Node();
    private Node last = new Node();
    //count记录剩下人数
    private static int count;

    //单向不循环链表
    private class Node {
        int item;
        Node next;

        public Node() {
        }

        public Node(int item) {
            this.item = item;
        }
    }

    public void add(int item) {
        Node node = new Node(item);
        if (head.next == null) {
            head.next = node;
            last = node;
            last.next = head.next;
        } else {
            last.next = node;
            last = node;
        }
        count++;
    }

    public int size() {
        return count;
    }

    public static void main(String args[]) {
        //总人数
        int N = 50;
        //固定步长
        int STEP = 7;
        //当前步数
        int j = 1;
        JLinkedList_V1 list = new JLinkedList_V1();
        for (int i = 0; i < N; i++)
            list.add(i + 1);
        //p指向链表第一个结点
        Node p = list.head.next;
        //单链表时候，当步数为第六步时候进行删除结点操作
        while (list.size() != 1) {
            //当步数不为第六步时，p指向下一个结点
            if (j != STEP - 1) {
                if (p.next != null)
                    p = p.next;
                else
                    p = list.head.next;
                j++;
                //当步数为第六步
            } else if (j == STEP - 1) {
                //当p指向最后一个结点，删除第一个结点
                if (p.next == null) {
                    System.out.println("index : " + list.head.next.item);
                    list.head.next = list.head.next.next;
                    p = list.head.next;
                } else if (p.next.next != null) {
                    System.out.println("index : " + p.next.item);
                    p.next = p.next.next;
                    p = p.next;
                    //p指向倒数第二个结点，删除最后一个结点
                } else if (p.next.next == null) {
                    System.out.println("index : " + p.next.item);
                    p.next = p.next.next;
                    p = list.head.next;
                }
                //步数重置为1,当前人数-1
                j = 1;
                count--;
            }
        }
        System.out.println("Survivor : " + list.head.next.item);
    }
}
