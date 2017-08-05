package Algorithms.demo234;




import Algorithms.demo301.LinearProbingHashST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by pokedo on 2017/2/7.
 */
public class FrequencyCounter {
    public static void main(String args[]) {
        int minlength = 8;
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();
        double start = System.currentTimeMillis();

        //¶ÁÈ¡×Ö·û´®Ê±ºòÌ«Âý
//        String[] arr = Base.readString("Algorithms/algs4-data/tale.txt").split("\\s");
//        for (String word : arr) {
//            if (word.length() < minlength)
//                continue;
//            if (!st.contains(word))
//                st.put(word, 1);
//            else
//                st.put(word, st.get(word) + 1);
//        }

        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File("Algorithms/algs4-data/tale.txt")));
            BufferedReader reader = new BufferedReader(read);
            String line = "";
            String[] arr;
            while ((line = reader.readLine()) != null) {
                arr = line.split("\\s");
                for (String word : arr) {
                    if (word.length() < minlength)
                        continue;
                    if (!st.contains(word))
                        st.put(word, 1);
                    else
                        st.put(word, st.get(word) + 1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }
        double end = System.currentTimeMillis();
        System.out.println(max + " " + st.get(max));
        System.out.println("Time : " + (end - start) / 1000);
    }
}
