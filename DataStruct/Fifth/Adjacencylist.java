package DataStruct.Fifth;

import java.util.HashMap;
public class Adjacencylist {
    //节点数
    static int V;
    //邻接表
    static Node[] nodes;
    //存放邻接表中对于值的下标
    static HashMap<String, Integer> map = new HashMap<>();
    static int count = 0;

    public Adjacencylist(int v) {
        V = v;
        nodes = new Node[V];
    }

    //在邻接表数组中增加对应的节点，这个节点还分配好了左右孩子
    public void addEdge(String root, String left, String right) {
        nodes[getValue(root)] = new Node(root, new Node(left), new Node(right));
    }

    //得到这个S对于节点所在邻接表的下标
    public int getValue(String s) {
        if (map.containsKey(s))
            return map.get(s);
        map.put(s, count);
        return count++;
    }

    //返回邻接表中值为root对应的node
    public Node findNode(String root) {
        if(root.equals("^"))
            return null;
        return nodes[getValue(root)];
    }
}
