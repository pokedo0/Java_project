package Match.Seventh;


//选择排序，找到最小的再依次交换，当前位置i的最小下标为自身时，不交换，直接跳过
public class demo9_C {
    static int N;

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5};
        sort(a);
        for (int i : a)
            System.out.print(i);
        System.out.println();
        System.out.println(N);
    }

    private static void sort(int[] a) {
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i; j < a.length; j++)
                if (a[j] < a[min])
                    min = j;
            if (min != i)
                exch(a, i, min);
        }
    }

    private static void exch(int[] a, int i, int j) {
        N++;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
