package hok2;
abstract class Person
{
	abstract void Name();
	abstract void Food();
	abstract void Time();

}
class Chinese extends Person
{
	String name,time;
	public Chinese(String name,String time)
	{
		this.name=name;
		this.time=time;
	}
	void Time()
	{
        if (time.equals("早晨"))
            System.out.println(name + "到该吃" + "早餐" + "的时间了");
        if (time.equals("中午"))
            System.out.println(name + "到该吃" + "午餐" + "的时间了");
        else if (time.equals("晚上"))
            System.out.println(name + "到该吃" + "晚餐" + "的时间了");
    }
	void Name()
	{
        System.out.println("我是中国人！");
    }
	void Food()
	{
        if (time.equals("早晨"))
            System.out.println("中国人早餐吃包子，油条、粥和豆浆。");
        else if (time.equals("中午"))
            System.out.println("中国人午餐吃米饭、馒头、蔬菜、肉类。");
        else if (time.equals("晚上"))
            System.out.println("中国人晚餐吃粥、馒头、蔬菜和水果。");
    }
}
class Foreigners extends Person
{
	String name,time;
	public Foreigners(String name,String time)
	{
		this.name=name;
		this.time=time;
	}
	void Time()
	{
		if(time.equals("morning"))
            System.out.println(name + "到该吃" + "早餐" + "的时间了");
        if(time.equals("noon"))
            System.out.println(name + "到该吃" + "午餐" + "的时间了");
        else if(time.equals("night"))
            System.out.println(name + "到该吃" + "晚餐" + "的时间了");
    }
	void Name()
	{
        System.out.println("I am a British ！");
    }
	void Food()
	{
		if(time.equals("morning"))
            System.out.println("外国人早餐吃包加黄油、牛奶、火腿。");
        else if(time.equals("noon"))
            System.out.println("外国人午餐吃汉堡、炸马铃薯、蔬菜。");
        else if(time.equals("night"))
            System.out.println("外国人晚餐吃萨饼、蔬菜、牛肉、水果、甜品、面包。");
    }
}

public class demo4
{
	public static void main(String args[])
	{
        Chinese chinese = new Chinese("张小红", "晚上");
        chinese.Time();chinese.Name();chinese.Food();
		Foreigners foreigners=new Foreigners("Tom","noon");
		foreigners.Time();foreigners.Name();foreigners.Food();
	}
}


