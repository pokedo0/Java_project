package Algorithms.demo321;


import Algorithms.demo281.RedBlackBST;
import edu.princeton.cs.algs4.Queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by pokedo on 2017/2/15.
 */
public class LookupIndex {
    public static void main(String args[]) {
        RedBlackBST<String, Queue<String>> ST = new RedBlackBST<>();
        RedBlackBST<String, Queue<String>> TS = new RedBlackBST<>();
        String filename = "Algorithms/algs4-data/movies.txt";
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File(filename)));
            BufferedReader reader = new BufferedReader(read);
            String line = "";

            while ((line = reader.readLine()) != null) {
                String regex = "/";
                String[] arr = line.split(regex);
                String key = arr[0];
                for(int i = 1; i<arr.length;i++){
                    String val = arr[i];
                    if(!ST.contains(key))
                        ST.put(key, new Queue<>());
                    if(!TS.contains(val))
                        TS.put(val, new Queue<>());
                    ST.get(key).enqueue(val);
                    TS.get(val).enqueue(key);
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        String key1 = "Brown, Bryan (I)";
        String key2 = "Tin Men (1987)";
        if(TS.get(key1) != null)
             System.out.println(key1+"    "+TS.get(key1));
        if(ST.get(key2) != null)
            System.out.println(key2+"    "+ST.get(key2));
    }
}
