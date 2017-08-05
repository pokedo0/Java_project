package hok2;
import java.util.*;
class User
{
	String account,password;
	protected  float money;
	public User(String account,String password,float money)  
	{
		this.account=account;
		this.password=password;
		this.money=money;
	}

    public void Show()                //显示余额
    {
		System.out.println("The rest of money:"+money+"\n");	
	}

    public void Save(float count)        //存钱
    {
		money+=count;
		System.out.println("Done!\n");
	}

    public void Withdraw(float count)    //取钱
    {
		money-=count;
		System.out.println("Done!\n");
	}

    public String GetAccount()            //返回账号供验证
    {
		return this.account;
	}

    public String GetPassword()            //返回密码供验证
    {
		return this.password;
	}
}

class SUser extends User
{
	public SUser(String account,String password,float money)
	{
		super(account,password,money);
	}

    public void Transfer(User user, float count)        //转账至普通账户
    {
		this.money-=count;
		System.out.println("Done!\n");
		user.money+=count;
	}

    public void Transfer(SUser user, float count)    //转账至VIP账户
    {
		this.money-=count;
		System.out.println("Done!\n");
		user.money+=count;
	}
}

public class demo2 {

	public static void main(String[] args)
	{
        User p1 = new User("112231", "11111", 800);            //创建并初始化账户名，密码，余额
        SUser p2=new SUser("112232","11111",800);
		Scanner reader=new Scanner(System.in);
        int sign = 0;                        //输入密码错误验证机制
        while(sign==0)
		{	
			System.out.println("Input the account:(Press 0 to exit)");
			String account=reader.nextLine();
            if (account.equals("0"))        //输入0则退出
            {
				sign=1;			
				break;
			}
			System.out.println("Input the password:");
			String password=reader.nextLine();
			
/* ****************************************************** guest用户  */
            if(account.equals(p1.GetAccount())&&password.equals(p1.GetPassword()))
			{
				System.out.println("Welcome!p1  type:guest\n");
                String choice = "1";            //方便进入循环而设的数
                while (!choice.equals("4") && !choice.equals("5"))            //输入4或5则退出当前小循环
                {
					System.out.println("Choose the function:");
					System.out.println("1.Save money           |2.Withdraw money");
					System.out.println("3.Account balance  ");
					System.out.println("4.Exit to logon screen |5.Exit the system");
					choice=reader.nextLine();
					switch(choice)
					{
						case "1":
						{
							System.out.println("please input the count:");
							float count=reader.nextFloat();
							p1.Save(count);
						};break;
						case "2":
						{
                            int temp = 0;                    //取钱有效性判断，不能透支
                            while(temp==0)
							{
								System.out.println("please input the count:");
								float count=reader.nextFloat();
								if(count<=p1.money)
									{
										p1.Withdraw(count);
                                        temp = 1;            //输入数目合理，退出循环
                                    }
								else
									System.out.println("The count is too lagre!");
							}
						};break;
						case "3":
							{
								p1.Show();
								System.out.println("Press any keys to continue!");
							}break;
						case "4":break;
						case "5":sign=1;break;
						default:System.out.println("Please input the number again!\n"
								+ "press any key to continue!");
					}
                    if (!choice.equals("4") && !choice.equals("5"))            //输入非4，5数字时候用来读取换行符
                        reader.nextLine();
				} 
			}
			
/*	*************************************************VIP账户(p2)    */
            else if(account.equals(p2.GetAccount())&&password.equals(p2.GetPassword()))
			{
				System.out.println("Welcome!p2  type:ViP\n");
                String choice = "1";                    //方便进入循环而设的数
                while (!choice.equals("5") && !choice.equals("6"))        //输入5或6则退出当前小循环
                {
					System.out.println("Choose the function:");
					System.out.println("1.Save money           |2.Withdraw money");
					System.out.println("3.Account balance      |4.Transfer  	");
					System.out.println("5.Exit to logon screen |6.Exit the system");
					choice=reader.nextLine();	
					switch(choice)
					{
						case "1":
						{
							System.out.println("please input the count:");
							float count=reader.nextFloat();
							p2.Save(count);
						};break;
						case "2":
						{
							System.out.println("please input the count:");
							float count=reader.nextFloat();
							p2.Withdraw(count);
						};break;
						case "3":
							{
								p2.Show();
								System.out.println("Press any keys to continue!");
							}break;
						case "4": {
                            int temp = 0;            //转账有效性判断
                            while(temp==0)
							{
								System.out.println("please input the account:");
								String id=reader.nextLine();
								if(id.equals("112231"))
								{
                                    temp = 1;        //合理账户并退出循环
                                    System.out.println("please input the count:");
									float count=reader.nextFloat();
									p2.Transfer(p1, count);
								}
                                if (id.equals("112232"))            //不能转账至当前账户
                                    System.out.println("You cannot transfer to yourself！");
                                else                            //输入账户不存在
                                    System.out.println("The account was not exist! input again!\n");
							}
						}
						case "5":break;
						case "6":sign=1;break;
						default:System.out.println("Please input the number again!\n"
								+ "press any key to continue!");
					}
                    if (!choice.equals("5") && !choice.equals("6"))    //输入非5，6数字时候用来读取换行符
                        reader.nextLine();
				}
			} else                //输入账户，密码不正确
                System.out.println("Wrong! please input correct account and password!\n");
        }//while括号
        System.out.println("The ATM system has stopped!");
    }//main函数括号
}

/*思路：创普通和VIP用户两个类，设定好各种功能，在主类中初始化账号密码，再由用户输入账号密码，
 * 	      由创建的账户个数决定if判断内容个数（代码长的主要原因），再输入各数字调用前两个类中的方法。
 * 
 * */
