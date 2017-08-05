package DataStruct.Test;

import java.util.Scanner;

/**
 * Created by pokedo on 2017/4/10.
 */
public class TestAll
{
    public static void main(String[] args)
    {
//        System.out.println("此处用于测试中序表达式转后序表达式并计算出其结果:");
//        Scanner in=new Scanner(System.in);
//        System.out.print("请输入一个算数表达式:");
//        String ins=in.nextLine();
//        ReverseBoLan b=new ReverseBoLan();
//        b.setInput(ins);
//        System.out.println("计算结果为:"+b.counter(b.reverse()));
//        System.out.println();
//        System.out.println("此处用于测试括号的匹配问题:");
//        Match m=new Match();
//        m.matchesSymbol();
//        System.out.println();
//        System.out.println("此处用于测试不用将中序表达式转为后序表达式就计算出算数表达式的结果:");
//        DoubleStack t=new DoubleStack();
//        t.arrange();
//        System.out.println();
        System.out.println("此处用于测试图的深度遍历和广度遍历的结果:");
        Graph g=new Graph(5);
        g.setNode(0, 3);
        g.setNode(1, 3);
        g.setNode(2, 3);
        g.setNode(3, 3);
        g.setNode(4,2);
        System.out.println("从标号为0节点开始进行深度优先的遍历的结果:" + g.depthFirst());
        System.out.println("从标号为0节点开始进行广度优先的遍历的结果:" + g.scopeFirst());
    }
}
