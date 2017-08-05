package demo8_2;

class Person
{
	
	public Person()
	{
        System.out.println("父类无参");
    }
	
	int age,grade;
	public Person(int age,int grade)
	{
        System.out.println("父类有参");
        this.age=age;
		this.grade=grade;
	}

}

class Student extends Person
{
	
	public Student()
	{
        System.out.println("子类无参调用");
    }
	int department;
	public Student(int age,int grade,int department)
	{
		super(age,grade);
        System.out.println("子类有参调用");
        this.department=department;
	}
	void show()
	{
		System.out.println("age is:"+age+"    grade is:"
				+grade+"   department is"+department);
	}
}

class demo8_2 
{
	public static void main(String args[])
	{
		Student stu1=new Student();
		Student stu2=new Student(10,20,30);
		stu1.show();
		stu2.show();
	}
}
