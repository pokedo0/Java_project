package DataStruct.Eighth;


public class SelectSort {
    public static void main(String args[]) {
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (Math.random() * 10);
        selectsort(a);
    }

    public static void selectsort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int midx = i;
            for (int j = i; j < a.length; j++)
                if (a[j] < a[midx])
                    midx = j;
            exchange(a, i, midx);
        }
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
