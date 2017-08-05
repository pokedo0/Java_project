package Match.Fifth;

import java.util.Scanner;

/**
 *  有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：

 每个小朋友都把自己的糖果分一半给左手边的孩子。

 一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。

 反复进行这个游戏，直到所有小朋友的糖果数都相同为止。

 你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
 */
/*
3
2 2 4
 */
public class demo8 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] people = new int[n];
        String[] st = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++)
            people[i] = Integer.valueOf(st[i]);
        int[] cube = new int[n];
        int count = 0;

        while (!check(people)) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    cube[i] = people[n - 1] / 2;
                    people[n - 1] -= cube[i];
                } else {
                    cube[i] = people[i - 1] / 2;
                    people[i - 1] -= cube[i];
                }
            }
            for (int i = 0; i < n; i++) {
                people[i] += cube[i];
                if (people[i] % 2 != 0) {
                    people[i]++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean check(int[] people) {
        int res = people[0];
        for (int i : people)
            if (i != res)
                return false;
        return true;
    }
}
