package hok2;
class Car
{
	protected String color,type;
	public Car()
	{
		color="red";
		type="carriage";
	}
	public Car(String color,String type)
	{
		this.color=color;
		this.type=type;
	}
	void ShowColor()
	{
		System.out.println("Color is:"+color);
	}
	void ShowType()
	{
		System.out.println("Type is:"+type);
	}
}
class Car1 extends Car
{
	private String firm;
	public Car1(String color,String type,String firm)
	{
		super(color,type);
		this.firm=firm;
	}
	public Car1(String color)
	{
		this.color=color;
        firm = "¹ãÖÝ±¾Ìï";
    }
	public Car1()
	{
		this("yellow");
	}
	void ShowFirm()
	{
		System.out.println("Firm is:"+firm);	
	}
}
public class demo1 
{
	public static void main(String args[])
	{
        Car1 c1 = new Car1("bule", "car", "·áÌï");
        Car1 c2=new Car1("green");
		Car1 c3=new Car1();
		System.out.println("C1:");
		c1.ShowColor();
		c1.ShowType();
		c1.ShowFirm();
		System.out.println("C2:");
		c2.ShowColor();
		c2.ShowType();
		c2.ShowFirm();
		System.out.println("C3:");
		c3.ShowColor();
		c3.ShowType();
		c3.ShowFirm();
	}
	

}
