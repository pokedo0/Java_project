package DataStruct.Fifth;

/**
 * Created by pokedo on 2017/4/17.
 */
public class Node {
    Object data;
    Node left;
    Node right;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
