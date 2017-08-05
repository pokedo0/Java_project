package hok2;
abstract class Geometry
{
	abstract float getArea();
	abstract float getPerimeter();
	final float pi=3.14f;
}
class Circle extends Geometry
{
	float r;
	public Circle(float r)
	{
		this.r=r;
	}
	float getArea()
	{
		return pi*r*r;
	}
	float getPerimeter()
	{
		return 2*pi*r;
	}
}
class Regular_triangle
{
	float h;
	public Regular_triangle(float h)
	{
		this.h=h;
	}
	float getArea()
	{
		return (float) (h*h*Math.sqrt(3)/4);
	}
	float getPerimeter()
	{
		return 3*h;
	}
}
class Rectangle extends Geometry
{
	float a,b;
	public Rectangle(float a,float b)
	{
		this.a=a;
		this.b=b;
	}
	float getArea()
	{
		return a*b;
	}
	float getPerimeter()
	{
		return 2*(a+b);
	}
}



public class demo3 {

	public static void main(String[] args) 
	{
		Circle C=new Circle(4);
		Regular_triangle R=new Regular_triangle(3.5f);
		Rectangle Re=new Rectangle(4,3.5f);
		System.out.println("The area of circle is "+C.getArea());
		System.out.println("The perimeter of circle is "+C.getPerimeter());
		System.out.println("The area of Regular_triangle is "+R.getArea());
		System.out.println("The perimeter of Regular_triangle is "+R.getPerimeter());
		System.out.println("The area of Rectangle is "+Re.getArea());
		System.out.println("The perimeter of Rectangle is "+Re.getPerimeter());
		
	}
	

}
