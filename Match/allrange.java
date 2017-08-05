package Match;

public class allrange<T extends Comparable> {
    static <T> void Swap(T[] str, int a, int b) {
        T temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }

    //在 str 数组中，[start,end) 中是否有与 str[end] 元素相同的
    static <T> boolean IsSwap(T[] str, int start, int end) {
        for (int i = start; i < end; i++)
            if (str[i].equals(str[end]))
                return false;
        return true;
    }

    //递归去重全排列，start 为全排列开始的下标， length 为str数组的长度
    static <T> void AllRange2(T[] str, int idx) {
        //当start == length - 1时,就打印
        if (idx == str.length - 1) {
            for (T s : str)
                System.out.print(s + " ");
            System.out.println();
        } else {
            for (int i = idx; i < str.length; i++) {
                if (IsSwap(str, idx, i)) {
                    Swap(str, idx, i);
                    AllRange2(str, idx + 1);
                    //排序并打印完后，恢复原来位置
                    Swap(str, idx, i);
                }
            }
        }
    }

    public static void main(String args[]) {
        String[] str = "abcd".split("");
//        int[] a = {1,2,3,4,5}
        AllRange2(str, 0);
    }
}
