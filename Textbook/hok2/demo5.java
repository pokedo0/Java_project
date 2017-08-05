package hok2;
interface Sort
{
	abstract void Up(int a[],int i);
	abstract void Down(int a[],int i);	
}

//
class Maopao implements  Sort
{

    void Exchange(int a[], int i, int j)            //交换
    {
		 int temp;
		 temp=a[j];
		 a[j]=a[i];
		 a[i]=temp;
	}
	public void Up(int a[],int i)
	{
		 int j=0;
		 while(i!=1)
		 {
			 for(j=0;j<i-1;j++)
			 {
				 if(a[j+1]<a[j])
				 {	 
					 Exchange(a,j+1,j);
				 }
			 } 
		 i--;j=0;
		 }
		 Show(a);
	}
	public void Down(int a[],int i)
	{
		 int j=0;
		 while(i!=1)
		 {
			 for(j=0;j<i-1;j++)
			 {
				 if(a[j+1]>a[j])
				 {	 
					 Exchange(a,j+1,j);
				 }
			 } 
		 i--;j=0;
		 }
		 Show(a);	
	}

    void Show(int a[])            //显示数组
    {
		int j=0;
		for(;j<a.length;j++)
		{
			System.out.print(a[j]+" ");
		}
	}
}
//
class Xuanze implements Sort
{
	void Show(int a[])
	{
		int j=0;
		for(;j<a.length;j++)
		{
			System.out.print(a[j]+" ");
		}
	}
	void Exchange(int a[],int i,int j)
	{
		 int temp;
		 temp=a[j];
		 a[j]=a[i];
		 a[i]=temp;
	}
	public void Up(int a[],int i)
	{
		int j=0;
		int index=0;
		while(i!=1)
		{
            for (j = 0; j < i; j++)            //从第一位开始到最后一位比较
            {
                if (a[index] <= a[j])        //找最大值下标
                {
					index=j;
				 }
			}
			i--;
			Exchange(a,index,i);
			index=0;
		}
		Show(a);
	}
	public void Down(int a[],int i)
	{
		int j=0;
		int index=0;
		while(i!=1)
		{
            for (j = 1; j < i; j++)            //从第一位开始到最后一位比较
            {
                if (a[index] >= a[j])        //找最小值下标
                {
					index=j;
				 }
			}
			i--;
			Exchange(a,index,i);
			index=0;
		}
		Show(a);
	}
}

public class demo5 {
	public static void main(String[] args) 
	{
		int a[]={5,6,8,8,1,2,9,9};
		Maopao p1=new Maopao();
        System.out.println("冒泡升序:");
        p1.Up(a,8);
        System.out.println("\n冒泡降序:");
        p1.Down(a,8);
		Xuanze p2=new Xuanze();
        System.out.println("\n选择升序:");
        p1.Up(a,8);
        System.out.println("\n降序升序:");
        p2.Down(a,8);
	}

}
