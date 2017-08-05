package Match.Seventh;

/**
 * Created by pokedo on 2017/4/7.
 */
public class demo1_JC {
    public static void main(String args[]) {
        String[] str = "vxvxvxvxvxvxvvx".split("");
        int a = 777;
        for (String s : str) {
            if (s.equals("v"))
                a = a * 2;
            else
                a -= 555;
        }
        System.out.println(a);
    }
}
