package DataStruct.Eighth;

public class InsertSort {
    public static void main(String args[]) {
        int[] a = {0, 1, 2, 2, 0, 0, 1, 1, 2, 1, 0};
        insertsort(a);
    }

    //前i个已排好序
    public static void insertsort(int[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = i; j > 0; j--)
                if (a[j] < a[j - 1])
                    exchange(a, j, j - 1);
                else
                    break;
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
    }

    private static void exchange(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
