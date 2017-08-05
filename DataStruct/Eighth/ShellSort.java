package DataStruct.Eighth;

public class ShellSort {
    public static void main(String args[]) {
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (Math.random() * 10);
        shellsort(a);

        print(a);
    }

    public static void shellsort(int[] a) {
        int[] temp = {5, 3, 1};
        for (int step : temp) {
            for (int i = step; i < a.length; i++)
                for (int j = i; j >= step; j -= step)
                    if (a[j] < a[j - step])
                        exchange(a, j, j - step);
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
