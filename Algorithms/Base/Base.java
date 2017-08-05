package Algorithms.Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pokedo on 2017/1/16.
 */
public class Base {
    public static String[] readStrings(String filename) {
        String[] arr = {""};
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File(filename
            )));
            BufferedReader reader = new BufferedReader(read);
            ArrayList<String> list = new ArrayList<>();
            String str = null;
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
            reader.close();
            arr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static String readString(String filename) {
        String line = "";
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File(filename)));
            BufferedReader reader = new BufferedReader(read);
            String str = null;
            while ((str = reader.readLine()) != null)
                line += str+" ";
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public static int[] readInts(String filename) {
        String[] Strarr = readStrings(filename);
        int[] arr = new int[Strarr.length];
        for (int i = 0; i < Strarr.length; i++) {
            //如果有空格，去除空格后再转换
            arr[i] = Integer.parseInt(Strarr[i].trim());
        }
        return arr;
    }

    public static void main(String args[]) {
        System.out.println(Base.readString("Algorithms/algs4-data/words3.txt"));
    }
}
