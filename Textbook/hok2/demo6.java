package hok2;
import java.util.*;

class Stu                //学生类
{
	String name;
	float grade,cadre,activity;
}

class Sort_down                //降序排列
{
    void Show(Stu a[])        //输出前三名同学
    {
		int j=0;
        System.out.println("\n前三名学生成绩分别是:");
        for(;j<3;j++)
			System.out.println(a[j].name+"   "+(a[j].grade+a[j].cadre+a[j].activity));
	}

    void Exchange(Stu a[], int i, int j)    //交换类数组
    {
        Stu temp;    //Stu类做临时变量
        temp=a[j];
		 a[j]=a[i];
		 a[i]=temp;
	}
	public void Down(Stu a[])		
	{
		int j=0;
		int i=a.length;
		int index=0;
		while(i!=1)
		{
            for (j = 1; j < i; j++)            //从第一位开始到最后一位比较
            {
				if(a[index].grade+a[index].cadre+a[index].activity
                        >= a[j].grade + a[j].cadre + a[j].activity)        //找最小值下标
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


public class demo6 {

	public static void main(String[] args) 
	{
		Scanner reader=new Scanner(System.in);
        System.out.println("Input the number of Students:");    //输入学生数量
        int num=reader.nextInt();
		reader.nextLine();
        Stu[] stu = new Stu[num];            //学生类数组
        for(int i=1;i<=num;i++)
		{
			stu[i-1]=new Stu();
            System.out.println("第" + i + "位学生");
            System.out.println("姓名:");
            stu[i-1].name=reader.nextLine();
            System.out.println("学习总成绩:");
            stu[i-1].grade=reader.nextFloat();
			reader.nextLine();
            //干部
            System.out.println("学生干部奖励分:（填写学生干部信息，如不是干部填写 无）");
            String b1=reader.nextLine();
            if (b1.equals("校级学生干部") || b1.equals("校级干部"))
                stu[i-1].cadre=5;
            else if (b1.equals("系部学生干部") || b1.equals("系部干部"))
                stu[i-1].cadre=3;
            else if (b1.equals("班级学生干部") || b1.equals("班级干部"))
                stu[i-1].cadre=1;
            else if (b1.equals("无"))
                stu[i-1].cadre=0;
            //表现分
            System.out.println("表现分:(填写参加何学校活动，如没有填写无)");
            String c1=reader.nextLine();
			int times;
            if (c1.equals("校级活动")) {
                System.out.println("次数:");
                times=reader.nextInt();
				stu[i-1].activity=times*2;
				reader.nextLine();
			} else if (c1.equals("系级活动")) {
                System.out.println("次数:");
                times=reader.nextInt();
				stu[i-1].activity=times*1;
				reader.nextLine();
			} else if (c1.equals("无"))
                stu[i-1].activity=0;
		}
		Sort_down p=new Sort_down();
		p.Down(stu);

	}

}
