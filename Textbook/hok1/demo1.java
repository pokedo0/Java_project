package hok1;
import java.util.*;

class Ad1  //通讯录类
{
	String name,email,address;
	int phone;
}
public class demo1 
{
	public static void main(String args[])
	{
		Ad1 ad=new Ad1();
		Scanner reader=new Scanner(System.in);
		System.out.println("input the name:");
		ad.name=reader.nextLine();
		System.out.println("input the phone number:");
		ad.phone=reader.nextInt();
        reader.nextLine();                //注意加上nextline读取换行符
        System.out.println("input the E-mail:");
		ad.email=reader.nextLine();
		System.out.println("input the address:");
		ad.address=reader.nextLine();
		System.out.println("The information:");
		System.out.println("Name:"+ad.name);
		System.out.println("Phone number:"+ad.phone);
		System.out.println("E-mail:"+ad.email);
		System.out.println("Address:"+ad.address);
	}
}
