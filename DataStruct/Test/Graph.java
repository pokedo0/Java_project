package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
import java.util.Scanner;


/**
 * 该类用于封装对一个图的操作
 * 采用链表数组的方式表示一个图
 * @author 学徒
 *
 */
public class Graph
{
    //该数组用于表示一个图
    int[][] graph;
    //存储下节点的数目
    private int length;
    /**
     * 用于创建一个图
     * @param length 节点的数目
     */
    public	Graph(int length)
    {
        this.length=length;
        graph=new int[length][];
    }
    /**
     * 该方法用于设置节点所关联的节点
     * @param length 关联的节点的数目 取值范围为[0,this.length)
     * @param order 关联的那个节点的标号，取值范围为[0,this.length)
     * @return 返回一个布尔变量 true为执行成功，false为执行失败
     */
    public boolean setNode(int order,int length)
    {
        //执行的结果
        boolean result=true;
        Scanner in =new Scanner(System.in);
        //将关联的节点存储进数组中
        if(order<this.length&&length>0&&length<this.length)
            graph[order]=new int[length];
        else
            return false;
        //输出提示语句
        System.out.println("请输入各个关联的节点的标号:");
        //获取输入的值，并将值存入对应的数组中
        for(int tem=0;tem<length&&in.hasNextInt();tem++)
        {
            int temps=in.nextInt();
            if(temps<this.length&&temps>=0)
                graph[order][tem]=temps;
            else
            {
                result=false;
                break;
            }
        }
        return result;
    }
    /**
     * 对一个图进行深度优先的方式进行遍历
     * @return 遍历之后的结果
     */
    public String depthFirst()
    {
        //该栈用于暂时存储遍历过的节点
        Stack<Integer> s=new Stack<Integer>();
        //该布尔数组用于记录是否入过栈，为false时，其表示未曾入过栈，当为true时，表示入过栈
        boolean[] res=new boolean[this.length];
        s.push(0);
        res[0]=true;
        //用于记录下未曾入过栈的节点的数目
        int temp=res.length-1;
        //用于保存结果
        String result="";
        //用于保存暂时的结果
        String tempString="";
        //当所有的节点均入过栈的时候，结束循环
        //查看栈顶元素的节点标号
        int z=s.getTop();
        while(temp!=0)
        {
            int tem=0;
            for(;tem<graph[z].length;tem++)
            {
                //遍历到相关元素未曾入过栈的时候，将其压入栈中
                if(!res[graph[z][tem]])
                {
                    s.push(graph[z][tem]);
                    res[graph[z][tem]]=true;
                    temp--;
                    break;
                }
            }
            //当其未找到一个未曾入过栈的元素的时候，对元素从栈中进行弹出操作
            if(tem==graph[z].length)
            {
                z=s.pop();
                tempString+=" "+z;
                //当栈中的内容全部弹出的时候，将所获得的字符串进行倒置
                if(s.isEmpty())
                {
                    tempString=reverseString(tempString);
                    result+=tempString;
                    tempString="";
                }
            }
            else
            {
                z=s.getTop();
            }
        }
        //当该栈不为空的时候，对其进行出栈操作
        while(!s.isEmpty())
        {
            tempString+=" "+s.pop();
        }
        tempString=reverseString(tempString);
        result+=tempString;
        return result;
    }
    /**
     * 该方法用于倒置一个字符串
     * @param string 将要进行倒置的字符串
     * @return 倒置之后的字符串
     *
     */
    public String reverseString(String string)
    {
        String result="";
        for(int temp=string.length()-1;temp>=0;temp--)
        {
            result+=string.charAt(temp);
        }
        return result;
    }


    /**
     * 对一个图进行广度优先的方式进行遍历
     * @return 遍历之后的结果
     */
    public String scopeFirst()
    {
        //该队列用于存储被遍历的元素
        Queue<Integer> q=new Queue<Integer>();
        //该布尔数组用于记录下各个节点是否已经被存入队列当中过，false表示未入队列，true表示已入队列
        boolean[] res=new boolean[this.length];
        res[0]=true;
        //将第一个元素存入队列中
        q.push(0);
        //该整型用于记录下未曾入过队列的节点的数目
        int temp=this.length-1;
        //用于存储结果
        String result="";
        //当所有的节点都入过队列时，结束广度遍历
        while(temp!=0)
        {
            int z=q.pop();
            for(int temps=0;temps<graph[z].length;temps++)
            {
                //当节点未曾入过队列时
                if(!res[graph[z][temps]])
                {
                    q.push((graph[z][temps]));
                    res[graph[z][temps]]=true;
                    temp--;
                }
            }
            result+=" "+z;
        }
        //将队列中的节点的标号弹出
        while(!q.isEmpty())
        {
            result+=" "+q.pop();
        }
        return result;
    }
}
