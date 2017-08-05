package demo8_3;
class Person
{
	protected int age,grade;
	public Person(){}
	public void show()
	{
		System.out.println("age is :"+age+"  grade is:"+grade);
	}
}

class Student extends Person
{
    //int age=15; 		//新添加一个与父类成员变量同名age的变量，则下文必须用super.访问父类变量
    //super.age=29;   	//错误，不能在方法外赋值
    public Student()
	{
        age = 25;            //访问父类成员并赋值，如果子类中定义了相同名字
        //的成员变量,则必须通过super.xx访问父类成员
        System.out.println("age is:"+age);
		show();
	}
	public void test()		
	{
        super.age = 10;    //同样访问父类成员并赋值
        System.out.println("age is:"+age);
	}
}

public class demo8_3 
{
	public static void main(String args[])
	{
		Student stu=new Student();
		stu.test();

	}
}
