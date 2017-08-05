package component_test;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class demo
{
	public static  void main(String args[])
	{
		Date day=new Date();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   System.out.println(df.format(day));
	}
}