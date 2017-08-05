package demo12_3;
class GenMet<T>
{
	private T t;
	public T getObj()
	{
		return t;
	}
	public void setObj(T t)
	{
		this.t=t;
	}
	public<U> void display(U u)
	{
        System.out.println("泛型类的类型参数T:" + t.getClass().getName());
        System.out.println("泛型方法的类型参数U:" + u.getClass().getName());
    }
}

public class demo12_3 {
	public static void main(String args[])
	{
		GenMet<String> gen=new GenMet<String>();
        gen.setObj(new String("444444"));        //设置泛型T
        System.out.println(gen.getObj());
        System.out.println("第一次输出:");
        gen.display("我是文本");            //设置泛型U
        System.out.println("第二次输出");
        gen.display(8.0f);
	}

}
