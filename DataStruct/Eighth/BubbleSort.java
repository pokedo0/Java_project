package DataStruct.Eighth;

public class BubbleSort {
    public static void main(String args[]) {
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (Math.random() * 10);
        bubblesort(a);
    }

    public static void bubblesort(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length && flag; i++) {
            flag = false;
            for (int j = 0; j < a.length - 1; j++)
                if (a[j] > a[j + 1]) {
                    exchange(a, j, j + 1);
                    flag = true;
                }
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
