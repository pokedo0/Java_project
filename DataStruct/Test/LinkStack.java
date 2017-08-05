package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
//用于实现一个单向链表的插入删除，以及查看头元素的值的操作
class LinkStack<T>
{
    //变量Node用于实现指向链表的开头处
    private Node<T> head=null;
    //变量count用于记录下链表的长度
    private int count=0;

    //用于实现节点类
    class Node<E>
    {
        //用于存储数据和存储指向下一个节点的指针
        E value;
        Node<E> next;
    }

    //用于获取链表的长度
    public int getCount()
    {
        return this.count;
    }

    //将新元素插入链表头中
    public void insert(T value)
    {
        Node<T> news =new Node<T>();
        news.value=value;
        if(head!=null)
        {
            Node<T> temp=head;
            head=news;
            news.next=temp;
        }
        else
        {
            head=news;
        }
        this.count++;
    }

    //将元素从链表头中进行删除,并返回节点的元素值
    public T delete()
    {
        Node<T> temp=this.head;
        Node<T> temps=this.head.next;
        head=temps;
        temp.next=null;
        this.count--;
        return temp.value;
    }

    //获得头元素的值，当不对其进行删除
    public T getValue()
    {
        return this.head.value;
    }
}

