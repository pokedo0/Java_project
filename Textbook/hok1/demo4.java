package hok1;            //用主类来输入一个人的各项信息，然后能够输出该人是否有资格参加此次大赛。
import java.util.*;
class Person
{
	public int age;
	public String marriage,sex,country,scholar;
	void judgement()
	{
        if (marriage.indexOf("未") == -1 && age >= 16 && age <= 25 &&
                country.equals("中国") && scholar.equals("大专") ||
                scholar.equals("本科") || scholar.equals("博士") ||
                scholar.equals("硕士") && sex == "女") {
            System.out.println("通过！");
        }
		else
            System.out.println("不通过!");
    }
}

public class demo4 
{
	public static void main(String args[])
	{
		final int N=10;
		Person[] per=new Person[N];
		for(int i=0;i<N;i++)
		{
			per[i]=new Person();
			Scanner reader=new Scanner(System.in);
			System.out.println("please input age:");
			per[i].age=reader.nextInt();
			//reader.next();
			System.out.println("please input sex:");
			per[i].sex=reader.next();
			System.out.println("please input country:");
			per[i].country=reader.next();
			System.out.println("please input marriage:");
			per[i].marriage=reader.next();
			System.out.println("please input scholar:");
			per[i].scholar=reader.next();
			per[i].judgement();
		}
		
	}
	
}
