package demo10_9;
import java.io.*;
public class demo10_9 {

	public static void main(String[] args) throws IOException
	{
		try
		{
            InputStreamReader isr = new InputStreamReader(System.in);        //创建标准输入流对象
            BufferedReader inp = new BufferedReader(isr);                    //创建缓冲流对象对接输入流
            String sdir = "d:\\lib";                        //文件夹路径
            File fdir1=new File(sdir);
			if(fdir1.exists()&&fdir1.isDirectory())
			{
                System.out.println("文件夹：" + sdir + "已经存在");
                for(int i=0;i<fdir1.list().length;i++)
					System.out.println(fdir1.list()[i]);
                File fdir2 = new File("d:\\lib\\temp");        //创建文件对象指向 对应路径
                if (!fdir2.exists())            //如果指定文件不存在
                    fdir2.mkdir();
                System.out.println("\n建立新文件夹后的列表： ");
                for(int i=0;i<fdir1.list().length;i++)
					System.out.println(fdir1.list()[i]);
			}
            System.out.println("请输入该文件夹中一个文件名:");
            String sfile = inp.readLine();        //输入文件名并读取
            File ffile = new File(fdir1, sfile);    //创建文件对象并导入输入的路径
            if(ffile.isFile())
			{
                System.out.println("文件名:" + ffile.getName());
                System.out.println("所在文件夹:" + ffile.getPath());
                System.out.println("文件大小：" + ffile.length() + "字节");
            }
            if (inp != null)        //只能输入一次, 后结束
                inp.close();
		}
		catch(IOException e)
		{System.out.println(e.toString());}
	}

}
