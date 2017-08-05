package DataStruct.First.Poker;

import java.util.Random;

/**
 * Created by pokedo on 2017/2/28.
 */
public class Pocker {
    public static void main(String args[]) {
        //牌数 N
        int N = 52;
        int[] card = new int[N];
        for (int i = 0; i < N; i++)
            card[i] = i + 1;
        for (int a : card)
            System.out.print(a + " ");
        System.out.println("\nresult:");
        shuffle(card);
        for (int a : card)
            System.out.print(a + " ");
    }

    private static void shuffle(int[] card) {
        /**
         * @c1 card1[]长度
         * @c2 card2[]长度
         * @pos1 记录card1[]发牌后的下标位置
         * @pos2 记录card2[]发牌后的下标位置
         * @mid 以mid为界限，分开card[]为两数组洗牌
         */
        int pos = 0;
        int pos1 = 0;
        int pos2 = 0;
        int length = card.length;
        //TODO 第三种要求，card[]不均分分成两份,随机范围[length/2-2 , length/2+2]
        int mid = new Random().nextInt(4) + card.length/2 - 4;
        //TODO 第一二种要求，card[]均分
//        int mid = card.length/2;
        int c1 = mid;
        int c2 = length - mid;
        int[] card1 = new int[c1];
        int[] card2 = new int[c2];
        //将card[]以mid为分界,左边放入card1[],右边放入card2[]
        for (int i = 0; i < length; i++) {
            if (i < mid)
                card1[i] = card[i];
            else
                card2[i - c1] = card[i];
        }
        int randoml;
        int randomr;
        //当card1[]或card2[]都没分完时
        while (pos1 < c1 || pos2 < c2) {
            /**
             * @randoml 每次分牌左边的分的牌数
             * @randomr 每次分牌右边的分的牌数
             */
            //TODO 第二种要求 随机生成[0-2]的牌数进行分牌
            randoml = new Random().nextInt(3);
            randomr = new Random().nextInt(3);
            //TODO 第一种要求 分牌数均分都为1
//            randoml = 1;
//            randomr = 1;
            //当card1[]分完,card2[]未分完
            if (pos1 >= c1 && pos2 < c2) {
                while (pos2 < c2)
                    card[pos++] = card2[pos2++];
                break;
            }
            //当card2[]分完,card1[]未分完
            if (pos2 >= c2 && pos1 < c1) {
                while (pos1 < c1)
                    card[pos++] = card1[pos1++];
                break;
            }
            //当左边要分的牌数>0
            while (randoml > 0) {
                card[pos++] = card1[pos1++];
                randoml--;
                //当左边要分的牌数>card1[]剩下的牌数
                if (pos1 + 1 > c1)
                    break;
            }
            while (randomr > 0) {
                card[pos++] = card2[pos2++];
                randomr--;
                if (pos2 + 1 > c2)
                    break;
            }
        }
    }
}
