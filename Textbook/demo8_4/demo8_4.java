package demo8_4;

class Person
{
	protected int age,grade;
	public Person(int age,int grade)
	{
		this.age=age;
		this.grade=grade;
	}
	void show()
	{
        System.out.println("父类方法show");
    }
}
class Student extends Person
{
	int department;
	public Student(int age,int grade,int department)
	{
		super(age,grade);
		this.department=department;
	}

    void show()                //覆盖了父类的方法
    {
        System.out.println("子类方法show " + "age:" + age + "  grade:" + grade + " department:" + department);
    }
}
public class demo8_4 
{	
	public static void main(String args[])
	{
	Student stu=new Student(20,70,10);
	stu.show();
	}
}

