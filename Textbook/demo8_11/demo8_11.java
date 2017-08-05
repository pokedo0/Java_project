package demo8_11;        //接口基本实现与利用

interface Person
{
    int age = 20;        //默认public  staic final

    abstract void show();  //默认使用public abstract修饰，子类方法必须显式使用public
}
class Student implements Person
{
	int grade=10;

    public void show()        //必须使用public
    {
		System.out.println("age:"+age+"  grade:"+grade);
	}
}

public class demo8_11 
{
	public static void main(String args[])
	{
		Student stu=new Student();
		stu.show();
	}
}
