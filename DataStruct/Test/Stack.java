package DataStruct.Test;

/**
 * Created by pokedo on 2017/4/10.
 */
/**
 * 该类用于封装一个栈的实现
 * ps:用单向链表进行实现
 * @author 学徒
 *用于实现操作获取栈顶的值和出栈及入栈操作
 */
public class Stack<T>
{
    LinkStack<T> stack=new LinkStack<T>();

    //实现其入栈操作
    public void push(T value)
    {
        stack.insert(value);
    }

    //实现其出栈操作,当栈中元素为空的时候，返回null
    public T pop()
    {
        if(stack.getCount()==0)
        {
            return null;
        }
        return stack.delete();
    }

    //实现查看栈顶元素的操作,当栈顶为空时，返回null
    public T getTop()
    {
        return stack.getValue();
    }

    //用于判断当前栈是否为空
    public boolean isEmpty()
    {
        return stack.getCount()==0;
    }

    //获取当前栈中元素的数目
    public int size()
    {
        return stack.getCount();
    }
}
