package demo8_13;   //多重继承
interface face1
{
	abstract void show1();
}
interface face2
{ 
	abstract void show2();
}
class Student implements face1,face2
{
    public void show1()                    //必须使用public
    {
        System.out.println("调用show1");
    }
	public void show2()
	{
        System.out.println("调用show2");
    }
}
public class demo8_13 
{
	public static void main(String args[])
	{
		Student stu=new Student();
		stu.show1();
		stu.show2();
	}
}
