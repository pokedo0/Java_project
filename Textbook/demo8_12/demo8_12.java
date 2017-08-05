package demo8_12;        //接口的继承
interface face1
{
	abstract void show1();
}
interface face2
{
	abstract void show2();
}
interface face3 extends face1,face2
{
	abstract void show3();
}
class Student implements face3
{
    public void show1()                    //必须使用public
    {
        System.out.println("调用show1");
    }
	public void show2()
	{
        System.out.println("调用show2");
    }
	public void show3()
	{
        System.out.println("调用show3");
    }
}

public class demo8_12
{
	public static void main(String args[])
	{
		Student stu=new Student();
		stu.show1();
		stu.show2();
		stu.show3();
	}
}
