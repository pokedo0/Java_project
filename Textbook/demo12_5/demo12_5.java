package demo12_5;
class GeneralType<T>
{
	T obj;
	public void setObj(T obj)
	{
		this.obj=obj;
	}
	public T getObj()
	{
		return obj;
	}

    //传入参数只能是String或其子类
    public static void showObj(GeneralType<? extends String> o)
	{
        System.out.println("给出的值是:" + o.getObj());
    }
}
public class demo12_5 {
	public static void main(String args[])
	{
		GeneralType<String> n=new GeneralType <String>();
        n.setObj("尼玛");
        GeneralType.showObj(n);
		GeneralType<Double> num=new GeneralType<Double>();
		num.setObj(25.0);
        System.out.println("数值型值" + num.getObj());
    }
}
