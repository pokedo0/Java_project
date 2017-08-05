package demo8_10;
abstract class Person
{
	int age,grade;
	public Person()
	{}

    public Person(int age, int grade)    //有参构造方法，如上文无无参构造方法，则必须被继承
    {
		this.age=age;
		this.grade=grade;
	}
	abstract void show();
}

class A extends Person
{
	int height;
	public A(int age,int grade,int height)
	{
		super(age,grade);
		this.height=height;
	}
	void show()
	{
        System.out.println("age :" + age + "  grade：" + grade + "  height" + height);
    }
}

public class demo8_10 
{
	public static void main(String args[])
	{
		A stu=new A(10,20,50);
		stu.show();
	}

}
