package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
public class Queue<T>
{
    //获得一个双向链表对象，用于实现一个队列的操作
    DoubleLinkList<T> queue=new DoubleLinkList<T>();

    //用于向该队列中插入一个元素
    public void push(T data)
    {
        queue.insert(data);
    }

    //用于向该队列中弹出一个元素
    public T pop()
    {
        //该队列是为空时
        if(isEmpty())
        {
            return null;
        }
        return queue.delete();
    }

    //用于获取该队列的元素的个数
    public int size()
    {
        return queue.getCount();
    }

    //查看该队列中首元素的元素值，但不对该首元素进行删除操作
    public T getTop()
    {
        //当该队列不为空时，返回该元素，否则，返回null
        if(!isEmpty())
        {
            return queue.getLast();
        }
        return null;
    }

    //用于判断一个队列是否为空
    public boolean isEmpty()
    {
        return queue.getCount()==0;
    }
}
