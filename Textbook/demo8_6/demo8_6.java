package demo8_6;
class Person
{
    public final void show()  //有final修饰
    {
        System.out.println("父类show");
    }
}
class Student extends Person
{
	final int a=6;
	public void set()
	{
        //a=7;  //错误，final型不能被赋值。
    }
    /*public final void show()  //错误，不能覆盖父类的方法
	{
	System.out.println();
	}*/
}

class demo8_6
{
	public static void main(String args[])
	{
		Student stu=new Student();
		System.out.println(stu.a);
	}
}
