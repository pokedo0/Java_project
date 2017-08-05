package demo8_5;
class Person
{
	int age;
	void show()
	{
        System.out.println("父类中的show()");
    }
}
class Student extends Person
{
	int grade;
	void show()
	{
        System.out.println("覆盖的父类方法 show()");
    }
	void subshow()
	{
        System.out.println("子类中的subshow()");
    }
}

public class demo8_5
{
	public static void main(String args[])
	{
        Person per = new Student();  //父类的对象访问子类对象，只限于覆盖的情况发生
        per.show();
	}
}
