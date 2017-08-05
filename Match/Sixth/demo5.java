package Match.Sixth;

import java.util.ArrayList;

/**
 * Created by pokedo on 2017/4/2.
 */
public class demo5 {

    public static void main(String args[]) {
        int n = 5;
        ArrayList<Integer> list = new ArrayList<>();
        for (int a = 1; a < n; a++)
            for (int b = a; b < n; b++)
                if (a * a + b * b == n * n)
                    if (!list.contains(a)) {
                        list.add(a);
                        list.add(b);
                    }
        System.out.println(list.size()/2);
    }
}
