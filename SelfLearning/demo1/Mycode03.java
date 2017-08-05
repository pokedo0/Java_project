package SelfLearning.demo1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by pokedo on 2017/7/22.
 */
public class Mycode03 {
    public static void main(String args[]) {
        Calendar c = new GregorianCalendar();
        c.set(2016, 10, 13, 15, 26); //如果不设置时分秒，则为实际的系统时间
        c.set(Calendar.YEAR, 2017);
        Date d = c.getTime(); //getTime()返回一个日期
        System.out.println(d);
        c.setTime(new Date());
        c.add(Calendar.YEAR, 3);
        System.out.println(c);
    }
}

