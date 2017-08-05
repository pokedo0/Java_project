package demo12_9;
import java.util.*;
public class demo12_9 {
	public static void main(String args[])
	{
		HashSet <String> hs=new HashSet<String> ();
		ArrayList arr=new ArrayList();
		Scanner reader=new Scanner(System.in);
		while(true)
		{
			String a=reader.next();
			if(a.equals("quit"))
				break;
			arr.add(a);
		}
		for(Object a:arr.toArray())
		{
			if(!hs.add((String)a))
                System.out.println("元素" + a + "重复");
        }
        System.out.println("集合容量未" + hs.size() + "各元素为");
        Iterator it=hs.iterator();
		while(it.hasNext())
			System.out.print(it.next()+"   ");
	}
}
