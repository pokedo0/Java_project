package Match;

/**
 * Created by pokedo on 2017/4/7.
 */
public class Combine {
    static int[] placeNum;
    static int[] getNum;

    public static void main(String args[]) {
        getNum = new int[3];
        placeNum = new int[10];
        dfs(0, 0);
    }

    //cur - 填写第cur个结果数
    //rest - 上一轮for()中填写的，用于在下一次dfs()中取得恒 >i 的结果数
    private static void dfs(int cur, int rest) {
        //取三个结果数
        if (cur == 3) {
            //10取三的结果数，
            printGetNum();
            //将10取三得到的结果数放置到placeNum[]中
            printPlaceNum();
            System.out.println();
            return;
        }
        for (int i = rest; i < 9; i++) {
            getNum[cur] = i;
            placeNum[i] = i;
            //注意是 i+1 ,不是rest+1，因为本轮dfs() cur位置的i结果也要取 i+1,i+2....的数
            dfs(cur + 1, i + 1);
            //一定要置零
            placeNum[i] = 0;
        }
    }

    private static void printPlaceNum() {
        for (int i : placeNum)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void printGetNum() {
        for (int i : getNum)
            System.out.print(i + " ");
        System.out.println();
    }
}
