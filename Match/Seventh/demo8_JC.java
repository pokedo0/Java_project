package Match.Seventh;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 冰雹数
 * <p>
 * 任意给定一个正整数N，
 * 如果是偶数，执行： N / 2
 * 如果是奇数，执行： N * 3 + 1
 * <p>
 * 生成的新的数字再执行同样的动作，循环往复。
 * <p>
 * 通过观察发现，这个数字会一会儿上升到很高，
 * 一会儿又降落下来。
 * 就这样起起落落的，但最终必会落到“1”
 * 这有点像小冰雹粒子在冰雹云中翻滚增长的样子。
 * <p>
 * 比如N=9
 * 9,28,14,7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1
 * 可以看到，N=9的时候，这个“小冰雹”最高冲到了52这个高度。
 * <p>
 * 输入格式：
 * 一个正整数N（N<1000000）
 * 输出格式：
 * 一个正整数，表示不大于N的数字，经过冰雹数变换过程中，最高冲到了多少。
 * <p>
 * 例如，输入：
 * 10
 * 程序应该输出：
 * 52
 * <p>
 * 再例如，输入：
 * 100
 * 程序应该输出：
 * 9232
 */
public class demo8_JC {
    public static void main(String args[]) {
        int N = 10;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (N != 1) {
            if (N % 2 == 0)
                N = N / 2;
            else
                N = N * 3 + 1;
            System.out.println(N);
            arrayList.add(N);
        }
        Object[] a = arrayList.toArray();
        Arrays.sort(a);
        System.out.println(a[a.length - 1]);
    }
}
