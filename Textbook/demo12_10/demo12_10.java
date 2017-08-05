package demo12_10;
import java.util.*;
public class demo12_10 {

	public static void main(String args[])
	{
		HashSet<String> hs=new HashSet<String>();
		hs.add("4");
		hs.add("3");
        hs.add("我");
        hs.add("1");
		TreeSet<String> ts=new TreeSet<String>(hs);
        System.out.println("树集合:" + ts);
        System.out.println("树集合第一个元素:" + ts.first());
        System.out.println("树集合最后一个元素:" + ts.last());
        System.out.println("树集合haedSet(3):" + ts.headSet("3"));
        System.out.println("树集合tailSet(4):" + ts.tailSet("4"));
        System.out.println("树集合ceiling(2):" + ts.lower("2"));
    }
}
