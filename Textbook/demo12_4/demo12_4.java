package demo12_4;
class GeneralType <T extends Number>
{
	T obj;
	public GeneralType(T obj)
	{
		this.obj=obj;
	}
	public T getObj()
	{
		return obj;
	}
}

public class demo12_4 {
	public static void main(String args[])
	{
		GeneralType<Integer> num=new GeneralType<Integer>(5);
        System.out.println("给出的参数:" + num.getObj());
    }

}
