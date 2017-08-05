package demo8_14;   //内部类的使用
class outer
{
	int age=10;
	class inner
	{
		int grade=20;
		void show()
		{
            System.out.println("内部方法  引用外部变量age:" + age);
        }
	}
	void show()
	{
        inner inn = new inner();    //在外部类中可new出内部类对象
        inn.show();                    //调用内部类show方法
        System.out.println("外部方法 ");
    }
	
}
class demo8_14
{
	public static void main(String args[]) {                                            //在main方法中new出inner类的对象
        outer.inner inn = new outer().new inner();  /*开头的Out是为了标明需要生成的内
                                                    部类对象在哪个外部类当中*/
		inn.show();
		outer out=new outer();
		out.show();
	}
	
}

