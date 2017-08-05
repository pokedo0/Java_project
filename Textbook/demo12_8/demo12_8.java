package demo12_8;
import java.util.*;
public class demo12_8 {
	public static void main(String args[])
	{
		ArrayList<Integer> al=new ArrayList<Integer>();
        for (int i = 1; i < 5; i++)    //向数组列表中添加元素
        {
			al.add(i);
		}
        System.out.println("数组列表的原始数据" + al);
        ListIterator<Integer> listIter=al.listIterator();
		listIter.add(0);
        System.out.println("添加数据后数组列表" + al);
        if(listIter.hasNext())
		{
			int i=listIter.nextIndex();
			listIter.next();
            //注意，remove() 和 set(Object) 方法不是 根据光标位置定义的；它们是根据对调用 next() 或 previous() 所返回的最后一个元素的操作定义的。
            listIter.set(9);
            System.out.println("修改后数组列表：" + al);
        }
		listIter=al.listIterator(al.size());
        System.out.println("反向遍历数组列表：");
        while(listIter.hasPrevious())
			System.out.print(listIter.previous()+"  ");
		
	}
	
}
