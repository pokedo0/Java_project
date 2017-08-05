package Match;

public class Allrange2 {
    static int N = 0;

    public static void allrange(int[] a, int idx) {
        int len = a.length;
        if (idx == len) {   //idxµ½×îºóÒ»Î»£¬Ö»ÓÐÒ»¸öÔªËØ£¬Êä³ö
            N++;
            print(a);
            return;
        }
        for (int i = idx; i < len; i++) {
            swap(a, idx, i);    //½«idxºóµÄÃ¿¸öÔªËØ¶¼Öð¸ö½»»»µ½idxÎ»ÖÃÉÏ
            allrange(a, idx + 1);   //µ±idxÎ»ÖÃÈ·¶¨ºó£¬ÍùidxºóÃæµÝ¹é
            swap(a, idx, i);    //»»¹ýÈ¥ºóÔÙ»¹Ô­
        }
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4};
        allrange(a, 0);
        System.out.println(N);
    }
}
