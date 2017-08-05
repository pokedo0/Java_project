package Match;

/**
 * Created by pokedo on 2017/3/15.
 */
public class EightQueen {
    static int count = 0;

    public static void main(String args[]) {
        int[] a = new int[8];
        //用一维数组遍历赋值的方式相当于减少了一层验证
        for (int i = 0; i < a.length; i++)
            a[i] = i;
        allrange(a, 0);
        System.out.println("count : " + count);
    }

    //检查棋盘
    public static boolean check(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                //验证不在同一水平线上
                if (a[i] == a[j])
                    return false;
                //对角线位置检查
                if (i - j == a[i] - a[j] || i - j == a[j] - a[i])
                    return false;
            }
        return true;
    }

    static void Swap(int[] str, int a, int b) {
        int temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }

//    //在 str 数组中，[start,end) 中是否有与 str[end] 元素相同的
//    static boolean IsSwap(int[] str, int start, int end) {
//        for (int i = start; i < end; i++)
//            if (str[i] == (str[end]))
//                return false;
//        return true;
//    }

    //递归去重全排列，start 为全排列开始的下标， length 为str数组的长度
    static void allrange(int[] a, int start) {
        //当start == length - 1时,就打印
        if (start == a.length - 1) {
            //如果检查通过
            if (check(a)) {
                count++;
                printqueen(a);
                System.out.println();
            }
        } else {
            for (int i = start; i < a.length; i++) {
                Swap(a, start, i);
                allrange(a, start + 1);
                //排序并打印完后，恢复原来位置
                Swap(a, start, i);
            }
        }
    }

    //打印棋盘
    static void printqueen(int[] a) {
        int n = a.length;
        for (int i : a) {
            for (int j = 0; j < n; j++) {
                if (j != i)
                    System.out.print("-" + " ");
                else
                    System.out.print(i+1 + " ");
            }
            System.out.println();
        }
    }
}
