package shiyan1;

class summer            //夏季电费
{
	float util,num;

    public summer(float util, float num)        //构造函数，输入单价和耗电量
    {
		this.util=util;
		this.num=num;
        System.out.println("夏季电费是：" + num * util);
    }
}

class winter            //冬季电费
{
	float util,num;

    public winter(float util, float num)        //构造函数，输入单价和耗电量
    {
		this.util=util;
		this.num=num;
        System.out.println("冬季电费是：" + num * util);
    }
}
public class demo3 {
	public static void main(String[] args) 
	{
        summer s1 = new summer(0.49f, 125);    //创建新对象
        winter s2 = new winter(0.49f, 125 + 20);    //创建新对象
    }
}
