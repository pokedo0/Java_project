package Algorithms.demo;

/**
 * Created by pokedo on 2017/1/17.
 */
public class Demo {
    int[] a;
    int[] b = a;

    int[] a1 = {1, 2, 3};
    int[] b1 = a1;

    String c;
    String d = c;

    String c1 = "c1";
    String d1 = c1;

    public static void main(String args[]) {
        Demo demo = new Demo();
        //当a为null时候，b也为null
        System.out.println("demo1.a: " + demo.a);
        System.out.println("demo1.b: " + demo.b);

        //当a原本由null指向其他地址，b仍然为null
        demo.a = new int[]{1,2,3};
        System.out.println("demo1.a: " + demo.a);
        System.out.println("demo1.b: " + demo.b);

        //a1指向[I@677327b6时，b也指向[I@677327b6,
        // 除非a1 new出新的数组，指向另外的地址，
        // 否则a1 = {1, 2, 3}的任何改动，b1也同样改动。
        System.out.println("demo1.a1: " + demo.a1);
        System.out.println("demo1.b1: " + demo.b1);

        System.out.println("===================================");
        //字符串的任何重新赋值都是开辟了新的内存或指向null
        //c=null，d=c，当c指向其他地址时，d仍然为null
        demo.c = "c";       //开辟新内存
        System.out.println("demo1.c: " + demo.c);
        System.out.println("demo1.d: " + demo.d);

        //c1指向3118，d1也指向3118
        System.out.println("demo1.c1: " + demo.c1.hashCode());
        System.out.println("demo1.d1: " + demo.d1.hashCode());

        //c1指向3118，d1也指向3118，当c1指向3119时候，d1仍指向3118
        demo.c1 = "c2";    //开辟新内存
        System.out.println("demo1.c1: " + demo.c1.hashCode());
        System.out.println("demo1.d1: " + demo.d1.hashCode());
    }
}
