package demo8_15;  //匿名内部类

public class demo8_15 
{
	public static void main(String args[])
	{

        new inner(5)    //不能定义构造方法，可定义一般方法
        {
					void setName(String name)
					{
						this.name=name;
						System.out.println("name is"+name);
					}
				}.setName(" test");			
	}
	static class inner
	{
		String name;
		public inner(int age)
		{
            System.out.println("调用内部类有参构造    age:" + age);
        }
	}
}