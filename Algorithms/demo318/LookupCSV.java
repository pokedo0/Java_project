package Algorithms.demo318;

import Algorithms.Base.Base;
import Algorithms.demo281.RedBlackBST;

/**
 * Created by pokedo on 2017/2/15.
 */
public class LookupCSV {
    public static void main(String agrs[]){
        RedBlackBST<String, String> ST = new RedBlackBST<>();
        String filename = "Algorithms/algs4-data/ip.csv";
        String[] arr = Base.readStrings(filename);
        for(String str : arr){
            String[] temp = str.split(",");
            ST.put(temp[0],temp[1]);
        }
        String key = "zedo.com";
        System.out.println(key+"     "+ST.get(key));
    }
}
