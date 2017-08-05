package Match.Seventh;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
结构： 一个int[] a 存放数据，int[] cout，存放 a[] 每个元素相对于前面元素出现的次数,默认最小为1。
int[] re 存放最后结果。
Stack[] st 是一个栈数组，类似于要构建一个邻接表，st[] 每个栈存放对应栈头元素(0-9)出现的位置
思想： 先遍历 a[] ，初始化 cout[] ,然后在填写 re[] 时候，
#根据cout[]特定元素第n次出现的位置,
到st[]栈中找到这个元素当前位置hi和上一个的位置lo，在for(lo+1 - hi)中找到出现新元素个数。
##如果当前遍历的位置 i ,和st[]栈中特定元素第一个位置的数值相同，说明 这个元素是第一次出现，直接取反。
 */
public class demo10 {
    public static void main(String args[]) {
        double start = System.currentTimeMillis();

        int n = 12;
//        int[] a = new int[n];
        int[] a = {1, 1, 2, 3, 2, 3, 1, 2, 2, 2, 3, 1};
        int[] cout = new int[n];
        int[] re = new int[n];
        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < n; i++)
//            a[i] = scanner.nextInt();
        Stack<Integer>[] st = new Stack[10];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < st.length; i++)
            st[i] = new Stack<Integer>();
        //HashMap用于初始化cout[]
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else
                map.put(a[i], 1);

            st[a[i]].push(i);
            cout[i] = map.get(a[i]);
        }

        for (int i = 0; i < n; i++) {
            //元素第一次出现
            if (st[a[i]].get(0) == i) {
                re[i] = -a[i];
                continue;
            }
            //特定元素第 i 次出现，到 st[] 中查找时，下标是 i-1
            int lo = st[a[i]].get(cout[i] - 1 - 1);
            int hi = st[a[i]].get(cout[i] - 1);
            for (int j = lo + 1; j < hi; j++)
                if (!stk.contains(a[j]))
                    stk.push(a[j]);
            re[i] = stk.size();
            //每次都要清除stk
            stk.clear();
        }
        for (int i : re)
            System.out.print(i + " ");

        double end = System.currentTimeMillis();
//        System.out.println((end-start)/1000);
    }
}
