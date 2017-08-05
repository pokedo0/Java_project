package hok1;

class Complex   //复数
{
	private int a,b;
	void show()
	{
		if(b>=0)
			System.out.println("Number:"+a+"+"+b+"i");
		else
			System.out.println("Number:"+a+""+b+"i");
	}

    public Complex(int a, int b)        //构造函数并初始化
    {
		this.a=a;
		this.b=b;
	}
	void change(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	void plus(Complex cm)  //+
	{
		int b=this.b+cm.b;
		System.out.println(b);
		if(b>=0)
			System.out.println(this.a+cm.a+"+"+b+"i");
		else
			System.out.println(this.a+cm.a+""+b+"i");
	}
	void minus(Complex cm)  //-
	{
		int b=this.b-cm.b;
		System.out.println(b);
		if(b>=0)
			System.out.println(this.a-cm.a+"+"+b+"i");
		else
			System.out.println(this.a-cm.a+""+b+"i");
	}
	void multip(Complex cm)  //*
	{
		int d=this.a*cm.a-this.b*cm.b;
		int e=this.b*cm.a+this.a*cm.b;
		if(e>=0)
			System.out.println(d+"+"+e+"i");
		else
			System.out.println(d+""+e+"i");	
	}
	void division(Complex cm)	//  /
	{
		int e=this.b*cm.a-this.a*cm.b;
		int de=cm.a*cm.a+cm.b*cm.b;
		if((e/de)>=0)
			System.out.println((this.a*cm.a+this.b*cm.b)/de+"+"+e/de+"i");
		else
			System.out.println((this.a*cm.a+this.b*cm.b)/de+""+e/de+"i");
	}
}

public class demo3
{
	public static void main(String args[])
	{
		Complex cm1=new Complex(10,-12);
		Complex cm2=new Complex(2,6);
		cm2.change(5,-5);
		cm1.plus(cm2);
		cm2.show();
	}
}
