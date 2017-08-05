package demo8_7;
class Person
{	
}

class Student extends Person
{}

class demo8_7
{
	public static void main(String args[])
	{
		Person per=new Person();
		Student stu=new Student();
		Object obj=stu; 		//obj����ָ��stu�Ķ���
		System.out.println("����stu�������ǣ�"+stu.getClass().getName());
		System.out.println("����stu���������ǣ�"+stu.getClass().getSuperclass());
		System.out.println("stu����Student�ࣿ"+(obj instanceof Person)); //�ж�obj�Ƿ�����Person��
	}
	

}
