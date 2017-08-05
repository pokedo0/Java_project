package DataStruct.First.Reverse;

/**
 * Created by pokedo on 2017/3/1.
 */
public class Reverse {
    public static void main(String args[]) {
        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        for (int i : a)
            System.out.print(i + "  ");
        System.out.println("\nresult:");
        reverse(a);
        for (int i : a)
            System.out.print(i + "  ");
    }

    private static void reverse(int[] a) {
        int random = 0;
        int pos = 0;
        while (pos < a.length) {
            //TODO 第二种要求，随机步长
//            random = new Random().nextInt(3) + 1; //随机数 : 1-3 交换
            //TODO 第一种要求,固定布长
            random = 4;
            //当最后pos的位置与random要求的交换数目冲突时
            if (pos + random - 1 >= a.length) {
                random = a.length - pos;
            }
            //当pos +i > pos局部移动数目一半时停止循环
            for (int i = 0; pos + i <= (pos + pos + random - 1) / 2; i++) {
                exchange(a, pos + i, pos + random - i - 1);
            }
            //局部倒序完成后，pos移动到对应位置
            pos += random;
        }
    }

    private static void exchange(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }
}
