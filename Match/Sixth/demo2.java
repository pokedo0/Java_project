package Match.Sixth;

/**
 * Created by pokedo on 2017/3/3.
 */
public class demo2 {
    public static void main(String args[]) {
        double sum = 0;
        for (double i = 1; sum < 15.0 ; i++) {
            sum += 1 / i;
            if (sum >= 15.0) {
                System.out.println("i: " + i);
                System.out.println("sum: " + sum);
                break;
            }
        }
    }
}