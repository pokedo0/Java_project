package Match.Fifth;

/**
 * Created by pokedo on 2017/4/3.
 */
public class demo5 {
    public static void main(String args[]){
        double x = 111;
        //到n=0,时候，本应该为x = 1 + (i*i/x),但循环一直是 2 + (i*i/x),多了一个1，所以要减去 1
        for(int n = 10000; n>=0; n--){
            int i = 2 * n + 1;
            x = 2 + (i*i / x);
        }
        System.out.println(String.format("%.4f",4/(x-1)));
    }
}
