package DataStruct.Tenth;

/**
 * Created by pokedo on 2017/5/16.
 */
public class SequenceSearch {
    public static void main(String args[]) {
        int[] a = {2, 3, 6, 5, 9, 2, 4, 5};
        System.out.println(sequencesearch(a, 8));
    }

    //顺序查找
    public static int sequencesearch(int[] a, int num) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == num)
                return i;
        return -1;
    }
}
