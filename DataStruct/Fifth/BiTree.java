package DataStruct.Fifth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
//测试时候复制一下两例到控制台可测试
//第一行为节点数，第二行指出整颗树的根节点
//剩余的行，按照树的层次结构，从上到下，从左往右，
//第一个是根节点，第二个是此节点的左孩子，第三个是此节点的右孩子
//只要一个节点非空，都要写入下列数据中，如 D ^ ^,说明D是一个叶节点
4
A
A B C
B ^ D
C ^ ^
D ^ ^

6
A
A B C
B ^ D
C E ^
E F ^
F ^ ^
D ^ ^
 */
public class BiTree {
    static Adjacencylist list;
    //分支节点数
    static int count;
    //叶节点数
    static int leavecnt;

    //bfs层次建树
    private static Node bfs(String node) {
        //根结点start
        Node start = list.findNode(node);
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            //当栈顶为空结点时，直接出栈,continue
            if (queue.peek() == null) {
                queue.poll();
                continue;
            }
            //对每次出栈的节点先修正建立起其左右孩子，再入栈修正后的左右孩子
            Node root = list.findNode((String) queue.poll().data);
            root.left = list.findNode((String) root.left.data);
            root.right = list.findNode((String) root.right.data);
            queue.add(root.left);
            queue.add(root.right);
        }
        return start;
    }

    //先根遍历
    public static void preTraverse(Node root) {
        if (root != null) {
//            count++;
            System.out.println(root.data);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    //统计分支节点数,统计叶节点数
    public static void getCount(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leavecnt++;
                return;
            }
            count++;
            getCount(root.left);
            getCount(root.right);
        }
    }

    //bfs层次遍历
    private static void bfsTraverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null)
                continue;
            System.out.println(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        //节点数目
        int V = scanner.nextInt();
        scanner.nextLine();
        //从RootStr这个节点开始建树
        String RootStr = scanner.nextLine();

        //建立邻接表
        list = new Adjacencylist(V);
        for (int i = 0; i < V; i++) {
            String[] str = scanner.nextLine().split(" ");
            String root = str[0];
            String left = str[1];
            String right = str[2];
            list.addEdge(root, left, right);
        }
        //返回建树后的一个根节点
        Node root = bfs(RootStr);
        System.out.println("前根遍历 :");
        preTraverse(root);
        System.out.println("\n广度遍历 :");
        bfsTraverse(root);
        getCount(root);
        System.out.println("\n叶结点个数:");
        System.out.println(leavecnt);
        System.out.println("\n结点数:");
        System.out.println(count);
    }
}

