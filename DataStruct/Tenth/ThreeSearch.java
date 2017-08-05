package DataStruct.Tenth;


/**
 * Created by pokedo on 2017/5/16.
 */
public class ThreeSearch {
    static int pos1;

    public static void main(String args[]) {
        int[] a = getDate();
        int num = 50;

        pos1 = 0;
        while (pos1 < a.length) {
            threesearch(a, num - a[pos1]);
            pos1++;
        }
    }

    private static void threesearch(int[] a, int sum) {
        int lo = pos1 + 1;  //这样就不会出现重复的对数
        int hi = a.length - 1;
        int count = 0;
        while (lo < hi) {
            if (a[lo] + a[hi] > sum)
                hi--;
            if (a[lo] + a[hi] < sum)
                lo++;
            if (lo == pos1)
                lo++;
            if (hi == pos1)
                hi--;
            if (lo >= hi || lo < 0 || hi > a.length - 1)
                break;
            if (a[lo] + a[hi] == sum) {
                count++;
                System.out.println(a[pos1] + " - " + a[lo++] + " - " + a[hi]);
            }
        }
    }


    public static int[] getDate() {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++)
            a[i] = i + 1;
        return a;
    }


}
