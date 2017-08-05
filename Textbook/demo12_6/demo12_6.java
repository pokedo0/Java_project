package demo12_6;

//定义一个泛型类，并在该类里利用类型参数声明数组
public class demo12_6 <T>
{
	private T[] array;

    public void setT(T[] array)    //设置T类型数组
    {
		this.array=array;
	}
	public T[] getT()
	{
		return array;
	}
	public static void main(String args[])
	{
		demo12_6<String> a=new demo12_6<String>();
        String[] array = {"红色", "橙色", "绿色"};
        a.setT(array);
		for(int i=0;i<a.getT().length;i++)
		{
			System.out.print(a.getT()[i]+"  ");
		}
	}
}
