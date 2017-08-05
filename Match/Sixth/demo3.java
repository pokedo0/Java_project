package Match.Sixth;

/**
 * Created by pokedo on 2017/3/1.
 */
public class demo3 {
    public static void main(String args[]) {
        double start = System.currentTimeMillis();

        double x;
        //暴力
//        for (x = 2.0; x < 3.0; x += 0.0000001) {
//            if (Math.abs(Math.pow(x, x) - 10.0) < 1e-6) {
//                System.out.printf("x: %.6f\n", x);
//                System.out.println("x: " + x);
//                break;
//            }
//        }
        //二分法
        double lo = 2.0;
        double hi = 3.0;
        double mid = (lo + hi) / 2;
        while (Math.abs(Math.pow(mid, mid) - 10.0) > 1e-10) {
            if (Math.pow(mid, mid) - 10.0 < 0) {
                lo = mid;
                mid = (lo + hi) / 2;
            } else if (Math.pow(mid, mid) - 10.0 > 0) {
                hi = mid;
                mid = (lo + hi) / 2;
            }
        }
        System.out.printf("mid : %.6f", mid);

        double end = System.currentTimeMillis();
        System.out.println("\ntime : "+(end - start) / 1000.0);
    }
}
