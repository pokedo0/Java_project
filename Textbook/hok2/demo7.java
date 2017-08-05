package hok2;
import java.util.*;
class Goods
{
	String name,color;
	float price;
	public Goods(String name,String color,float price)
	{
		this.name=name;
		this.color=color;
		this.price=price;
	}
	void Show()
	{
		System.out.println("name    color    price");
		System.out.println(name+"    "+color+"    "+price);
	}
}

public class demo7 
{

	public static void main(String[] args) 
	{
		Goods []g=new Goods[3];
		g[0]=new Goods("blouses","black",32.5f);
		g[1]=new Goods("Tshirt","black",30.5f);
		g[2]=new Goods("Knit","yellow",9.6f);
		System.out.println("please input the name of goods");
		Scanner reader=new Scanner(System.in);
		String temp=reader.nextLine();
		if(temp.equals("blouses"))
			g[0].Show();
		else if(temp.equals("Tshirt"))
			g[1].Show();
		else if(temp.equals("Knit"))
			g[2].Show();
		
	}
	

}
