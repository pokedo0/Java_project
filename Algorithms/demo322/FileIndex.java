package Algorithms.demo322;

import Algorithms.Base.Base;
import Algorithms.demo281.RedBlackBST;

import java.io.File;
import java.util.HashSet;

/**
 * Created by pokedo on 2017/2/15.
 */
public class FileIndex {
    public static void main(String args[]) {
        RedBlackBST<String, HashSet<File>> st = new RedBlackBST<>();
        String filename = "ex1.txt|ex2.txt|ex3.txt|ex4.txt";
        String[] arr = filename.split("\\|");
        //每个file = 每个文件
        for (String name : arr) {
            filename = "Algorithms/algs4-data/" + name;
            File file = new File(filename);
            String[] temp = Base.readString(filename).split("\\s");
            //读取每个文件的内容
            for (String word : temp) {
                if (!st.contains(word))
                    st.put(word, new HashSet<>());
                HashSet<File> set = st.get(word);
                set.add(file);
            }
        }
        String key = "was";
        System.out.println(key + "   " + st.get(key));
    }
}
