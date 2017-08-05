package Match.Fifth;

/*
我们可以抽象为一个数列：a0=2,a1=3,a2=5……a10?

第一个方法，可以认为an=2^(n)+1，进而得到a10=2^10+1==>1025

第二个方法，得递推关系：val(n+1) = 2*an - 1
 */
public class demo2 {
    public static void main(String args[]) {
        int n = 10;
        System.out.println(fun(10));

    }

    private static int fun(int i) {
        if (i == 2)
            return 5;
        else
            return 2*fun(i - 1)-1;
    }
}
