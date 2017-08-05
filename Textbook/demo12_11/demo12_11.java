package demo12_11;
import java.util.*;
public class demo12_11 {

	public static void main(String args[])
	{
		Map <String,String> hm=new HashMap<String,String>();
        hm.put("006", "唐僧");
        hm.put("008", "孙悟空");
        hm.put("009", "猪八戒");
        hm.put("007", "沙和尚");
        hm.put("010", "白龙马");
        System.out.println("哈希映射中内容如下:\n" + hm);
        hm.remove("010");
		Set keys=hm.keySet();
		Iterator it=keys.iterator();
        System.out.println("HashMap类实现map映射，无序");
        while(it.hasNext())
		{
			String xh=(String)it.next();
			String name=(String)hm.get(xh);
			System.out.println(xh+"   "+name);
		}
		TreeMap<String,String>tm=new TreeMap<String,String>();
		tm.putAll(hm);
		Iterator iter=tm.keySet().iterator();
        System.out.println("TreeMap类实现的map映射，升序");
        while(iter.hasNext())
		{
			String xh=(String) iter.next();
			String name=(String)hm.get(xh);
			System.out.println(xh+"  "+name);
		}
	}
	
}
