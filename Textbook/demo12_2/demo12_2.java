package demo12_2;

public class demo12_2 
{
	public static void main(String args[])
	{
		Integer[] num={1,2,3,4,5};
		String[] str={"red","orange","yellow","green","blue"};
		demo12_2.display(num);
		demo12_2.display(str);
	}
	public static <E> void display(E[] list)
	{
		for(int i=0;i<list.length;i++)
			System.out.print(list[i]+"  ");
		System.out.println();
	}

}
