package DataStruct.Ninth;

public class HeapSort {
    public static void main(String args[]) {
        int[] a = {3, 5, 2, 6, 8, 1, 1};
        heapsort(a);
//        print(a);
    }

    public static void heapsort(int[] a) {
        int[] b = new int[a.length + 1];
        for (int i = 1; i < b.length; i++)
            b[i] = a[i - 1];
        int N = b.length - 1;
        //构建小顶堆
        for (int i = N / 2; i >= 1; i--)
            adjust(b, i, N);
//        print(b);

        while (N > 1) {
            exchange(b, 1, N--);    //每次调整完后交换到N--的位置
            adjust(b, 1, N);       //调整后顶部就是最小元素
//            print(b);
        }
//        print(b);

        for (int i = 0; i < a.length; i++)
            a[i] = b[i + 1];
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    //小顶堆，每次调整后最小的在顶部,从lo-hi的范围进行调整
    private static void adjust(int[] a, int lo, int hi) {
        int i = lo;
        int j = 2 * i;
        while (j <= hi) {
            if (j + 1 <= hi && a[j] > a[j + 1]) //调整对象为两个子结点中更小的点
                j++;
            if (a[i] <= a[j])
                break;
            exchange(a, i, j);
            i = j;
            j = 2 * j;
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
