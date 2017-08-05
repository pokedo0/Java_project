package DataStruct.Third.JosephProblem;

/**
 * 约瑟夫环数组结构
 * Created by pokedo on 2017/3/17.
 */
public class JArrayList {
    public static void main(String args[]) {
        int N = 50;
        // 剩下人数
        int count = N;
        // 处死步长
        int STEP = 7;
        int[] a = new int[count + 1];
        // 数组下标
        int i = 1;
        // 每次有效步数
        int j = 1;
        for (int k = 1; k <= count; k++)
            a[k] = k;
        while (count != 1) {
            if (i == N + 1)
                i = 1;
            if (a[i] == 0) {
                i++;
                continue;
            } else {
                // 当步数不为7 && 当前a[i] != 0时 ,才算有效步数,j++;
                if (j != STEP) {
                    i++;
                    j++;
                } else {
                    a[i] = 0;
                    count--;
                    j = 1;
                    System.out.println("index : " + i);
                    i++;
                }
            }
        }
        for (int s : a)
            if (s != 0)
                System.out.println("Survivor : " + s);
    }
}
