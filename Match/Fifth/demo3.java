package Match.Fifth;

/**
 * 把abcd...s共19个字母组成的序列重复拼接106次，得到长度为2014的串。

 接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字母。

 得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。
 */
public class demo3 {
    public static void main(String args[]) {
//        StringBuilder strb = new StringBuilder();
//        for (int i = 0; i < 19; i++)
//            strb.append((char) ('val' + i));
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 106; i++)
//            sb.append(strb);
//        int len = sb.length();
//        String[] st = new String(sb).split("");
//        //数组下标
//        int count = len;
//        while (true) {
//            sb = new StringBuilder();
//            for (int i = 0; i < len; i++) {
//                if (i % 2 == 0) {
//                    count--;
//                    if (count == 0) {   //当为0的时候即所求
//                        System.out.println(st[i]);
//                        return;
//                    }
//                    st[i] = "";
//                } else
//                    sb.append(st[i]);
//            }
//            st = new String(sb).split("");
//            len = st.length;
//        }

        String str = "";
        for (int i = 1; i <= 19; i++)
            str += (char) (96 + i);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 106; i++)
            sb.append(str);

        //手写找规律
        while (sb.length() > 1) {
            for (int i = 0; i < sb.length(); i++)
                sb.delete(i, i + 1);
        }
        System.out.println(sb);
    }
}
