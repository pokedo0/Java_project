package demo12_1;

public class demo12_1 <T>
{
	private T obj;
	public T getObj()
	{
		return obj;
	}
	public void setObj(T obj)
	{
		this.obj=obj;
	}
	public static void main(String args[])
	{
		demo12_1<String> name=new demo12_1<String>();
		demo12_1<Integer> age=new demo12_1<Integer>();
        name.setObj("ÄáÂê");
        System.out.println("ĞÕÃû:" + name.getObj());
        age.setObj(25);
        System.out.println("ÄêÁä:" + age.getObj());
    }

}
