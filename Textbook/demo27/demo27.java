package demo27;

class Person
{
	public Person()
	{
        System.out.println("无参1调用");
    }
	public Person(int a)
	{
        System.out.println("无参2");
    }
	public Person(int a,int b)
	{
        System.out.println("无参3调用");
    }
	
}
class demo27 
{
	public static void main(String args[])
	{
		Person per=new Person(12,2);
		
	}

}
