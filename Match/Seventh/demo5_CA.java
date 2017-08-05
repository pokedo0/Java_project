package Match.Seventh;

/**
 * 消除尾一
 * <p>
 * 下面的代码把一个整数的二进制表示的最右边的连续的1全部变成0
 * 如果最后一位是0，则原数字保持不变。
 * <p>
 * 如果采用代码中的测试数据，应该输出：
 * 00000000000000000000000001100111   00000000000000000000000001100000
 * 00000000000000000000000000001100   00000000000000000000000000001100
 * <p>
 * 请仔细阅读程序，填写划线部分缺少的代码。
 * <p>
 * <p>
 * #include <stdio.h>
 * <p>
 * void f(int x)
 * {
 * int i;
 * for(i=0; i<32; i++) printf("%d", (x>>(31-i))&1);
 * printf("   ");
 * <p>
 * x = _______________________;
 * <p>
 * for(i=0; i<32; i++) printf("%d", (x>>(31-i))&1);
 * printf("\n");
 * }
 * <p>
 * int main()
 * {
 * f(103);
 * f(12);
 * return 0;
 * }
 */
public class demo5_CA {
    static void f(int x) {
        int i;
        for (i = 0; i < 32; i++) System.out.printf("%d", (x >> (31 - i)) & 1);
        System.out.print("   ");

        x = x & x + 1;//TODO

        for (i = 0; i < 32; i++) System.out.printf("%d", (x >> (31 - i)) & 1);
        System.out.println();
    }

    public static void main(String args[]) {
        f(103);
        f(12);
    }
}
