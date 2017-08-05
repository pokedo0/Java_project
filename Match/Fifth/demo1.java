package Match.Fifth;

import java.util.ArrayList;
import java.util.Scanner;

/*
书的第10页和第11页在同一张纸上，但第11页和第12页不在同一张纸上 。
要带第81页到第92页的武功，又不想带着整本书。请问他至少要撕下多少张纸带走？ 7页
 */
public class demo1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c;
        if (a % 2 != 0 && b % 2 == 0)
            c = (b - a) / 2 + 2;
        else
            c = (b - a) / 2 + 1;
        System.out.println(c);
    }
}
