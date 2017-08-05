package hok1;
class Archives
{
	protected int No,Age;
	protected String Name,Sex;
	void Show()
	{
		System.out.println("Name:"+Name+"\nNumber:"+No+"\nAge:"+Age+"\nSex:"+Sex);
	}
}
class Laborage extends Archives
{
	private int SSalary,Security,Fsalary;
	public Laborage(int No,String Name,String Sex,int Age,int SSalary,int Security)
	{
		this.No=No;
		this.Name=Name;
		this.Sex=Sex;
		this.Age=Age;
		this.SSalary=SSalary;
		this.Security=Security;
	}
	public void count()
	{
		Fsalary=SSalary-Security;
	}
	public void Display()
	{
		Show();
        System.out.println("应发工资:" + SSalary + "\n社保金:" + Security + "\n实发工资:" + Fsalary);
    }
}

public class demo2
{
	public static void main(String args[])
	{
        Laborage lab = new Laborage(1001, "张三", "男", 21, 2000, 100);
        lab.Display();
	}
	

}
