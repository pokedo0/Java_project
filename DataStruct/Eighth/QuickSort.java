package DataStruct.Eighth;

public class QuickSort {
    public static void main(String args[]) {
//        int a[] = new int[10];
//        for (int j = 0; j < 50; j++) {
//            for (int i = 0; i < a.length; i++)
//                a[i] = (int) (Math.random() * 10);
//            quicksort(a);
//            System.out.println(isSort(a));
//        }
        int[] a = {1, 3, 5, 9, 9, 0, 0, 3, 5};
        quicksort(a);
        print(a);
    }

    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    //递归方式
    private static void quicksort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = partition(a, lo, hi);
        quicksort(a, lo, mid - 1);
        quicksort(a, mid + 1, hi);
    }

//    private static void quicksort(int[] a, int lo, int hi) {
//        Stack<Integer> stack = new Stack<>();
//        if (lo < hi) {
//            int mid = partition(a, lo, hi);
//            if (mid > lo) {
//                stack.push(lo);
//                stack.push(mid - 1);
//            }
//            if (mid < hi) {
//                stack.push(mid + 1);
//                stack.push(hi);
//            }
//
//            while (!stack.isEmpty()) {
//                int right = stack.pop();
//                int left = stack.pop();
//                int tmp = partition(a, left, right);
//                if (tmp > left) {
//                    stack.push(left);
//                    stack.push(tmp - 1);
//                }
//                if (tmp < right) {
//                    stack.push(tmp + 1);
//                    stack.push(right);
//                }
//            }
//        }
//    }

    private static boolean isSort(int[] a) {
        boolean uflag = false;
        boolean dflag = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                dflag = true;
            else if (a[i] < a[i + 1])
                uflag = true;
            else if (a[i] == a[i + 1])
                continue;
            if (uflag && dflag)
                return false;
        }
        return true;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[--j] > v && j > lo)
                continue;
            while (a[++i] < v && i < hi)
                continue;
            if (i >= j)
                break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void exchange(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
