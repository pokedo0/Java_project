package Match.Seventh;

/**
 * 快速排序
 * <p>
 * 排序在各种场合经常被用到。
 * 快速排序是十分常用的高效率的算法。
 * <p>
 * 其思想是：先选一个“标尺”，
 * 用它把整个队列过一遍筛子，
 * 以保证：其左边的元素都不大于它，其右边的元素都不小于它。
 * <p>
 * 这样，排序问题就被分割为两个子区间。
 * 再分别对子区间排序就可以了。
 * <p>
 * 下面的代码是一种实现，请分析并填写划线部分缺少的代码。
 * <p>
 * <p>
 * #include <stdio.h>
 * <p>
 * void swap(int a[], int i, int j)
 * {
 * int t = a[i];
 * a[i] = a[j];
 * a[j] = t;
 * }
 * <p>
 * int partition(int a[], int p, int r)
 * {
 * int i = p;
 * int j = r + 1;
 * int x = a[p];
 * while(1){
 * while(i<r && a[++i]<x);
 * while(a[--j]>x);
 * if(i>=j) break;
 * swap(a,i,j);
 * }
 * ______________________;
 * return j;
 * }
 * <p>
 * void quicksort(int a[], int p, int r)
 * {
 * if(p<r){
 * int q = partition(a,p,r);
 * quicksort(a,p,q-1);
 * quicksort(a,q+1,r);
 * }
 * }
 * <p>
 * int main()
 * {
 * int i;
 * int a[] = {5,13,6,24,2,8,19,27,6,12,1,17};
 * int N = 12;
 * <p>
 * quicksort(a, 0, N-1);
 * <p>
 * for(i=0; i<N; i++) printf("%d ", a[i]);
 * printf("\n");
 * <p>
 * return 0;
 * }
 * <p>
 * <p>
 * 注意：只填写缺少的内容，不要书写任何题面已有代码或说明性文字。
 */
public class demo4_C {
    static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static int partition(int a[], int p, int r) {
        int i = p;
        int j = r + 1;
        int x = a[p];
        while (true) {
            while (i < r && a[++i] < x) ;
            while (a[--j] > x) ;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, p, j);//TODO
        return j;
    }

    static void quicksort(int a[], int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    public static void main(String args[]) {
        int i;
        int a[] = {5, 13, 6, 24, 2, 8, 19, 27, 6, 12, 1, 17};
        int N = 12;

        quicksort(a, 0, N - 1);

        for (i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
