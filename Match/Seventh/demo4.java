package Match.Seventh;
//分小组
//
//        9名运动员参加比赛，需要分3组进行预赛。
//        有哪些分组的方案呢？
//
//        我们标记运动员为 A,B,C,... I
//        下面的程序列出了所有的分组方法。
//
//        该程序的正常输出为：
//        ABC DEF GHI
//        ABC DEG FHI
//        ABC DEH FGI
//        ABC DEI FGH
//        ABC DFG EHI
//        ABC DFH EGI
//        ABC DFI EGH
//        ABC DGH EFI
//        ABC DGI EFH
//        ABC DHI EFG
//        ABC EFG DHI
//        ABC EFH DGI
//        ABC EFI DGH
//        ABC EGH DFI
//        ABC EGI DFH
//        ABC EHI DFG
//        ABC FGH DEI
//        ABC FGI DEH
//        ABC FHI DEG
//        ABC GHI DEF
//        ABD CEF GHI
//        ABD CEG FHI
//        ABD CEH FGI
//        ABD CEI FGH
//        ABD CFG EHI
//        ABD CFH EGI
//        ABD CFI EGH
//        ABD CGH EFI
//        ABD CGI EFH
//        ABD CHI EFG
//        ABD EFG CHI
//        ..... (以下省略，总共560行)。
//
//public class A
//{
//    public static String remain(int[] a)
//    {
//        String s = "";
//        for(int i=0; i<a.length; i++){
//            if(a[i] == 0) s += (char)(i+'A');
//        }
//        return s;
//    }
//
//    public static void f(String s, int[] a)
//    {
//        for(int i=0; i<a.length; i++){
//            if(a[i]==1) continue;
//            a[i] = 1;
//            for(int j=i+1; j<a.length; j++){
//                if(a[j]==1) continue;
//                a[j]=1;
//                for(int k=j+1; k<a.length; k++){
//                    if(a[k]==1) continue;
//                    a[k]=1;
//                    System.out.println(__________________________________);  //填空位置
//                    a[k]=0;
//                }
//                a[j]=0;
//            }
//            a[i] = 0;
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        int[] a = new int[9];
//        a[0] = 1;
//
//        for(int b=1; b<a.length; b++){
//            a[b] = 1;
//            for(int c=b+1; c<a.length; c++){
//                a[c] = 1;
//                String s = "A" + (char)(b+'A') + (char)(c+'A');
//                f(s,a);
//                a[c] = 0;
//            }
//            a[b] = 0;
//        }
//    }
//}

//这道代码填空题在比赛的时候没有做出来，一是因为紧张、慌，二是因为没有看明白。教训：像这种代码填空题，应尽最大努力先去看明白，再去猜、试，如果只是一味的猜的话（当时我就是这么做的，大体看了一眼，没有思路，虽然试了几次找到了第一个和第三个，可是就是没有试出来第二个的写法，白白浪费了15分钟），
//很难得到正确的答案，最终往往不仅没有得到正确的解，还让自己搞得心烦意乱（总是觉得前面有一道简单的代码填空题，等会要在回过头去看看，然后”中断“、”中断“又”中断“，浪费了资源！）。其实，像这种代码填空题，最好的解决方案是求解和猜双管齐下，只要大致看明白了程序，然后再稍微一试，很容易就出来了。
//分析：
//首先，标准的程序，起名字，往往是可以见名知义，直接拿来用的，像”remain”函数，程序中写出来都没有用过，而且根据其含义再加上其返回一个字符串，可以很容易的确定这个函数是需要调用的，将其放入填空位置，打印出来，与答案对照，发现这刚好是第三部分！
//再去分析源程序，发现整形数组a的元素只有两个取值，一个是0，一个是1，这是一个标记数组。标记为1的元素的下标对应的就是已经确定了的，打印字符串s的值，发现和第一部分答案相同。
//其实，在去看函数f会发现，它和主方法的函数体是大致相同的，都是先标记，再恢复现场，所以，仿照着主方法中的s得到第二部分的答案！
//note：答案中的第一部分和第三部分可以很容易的求得，但是第二部分的答案很长，不是单单只靠猜就能得到的，我当时就是死在这儿了，就是得不到这一部分的答案，所以代码填空题，虽然简单，但还是要看懂程序再做效率更高！


public class demo4 {
    public static String remain(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                s += (char) (i + 'A');
        }
        return s;
    }

    public static void f(String s, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) continue;
            a[i] = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == 1)
                    continue;
                a[j] = 1;
                for (int k = j + 1; k < a.length; k++) {
                    if (a[k] == 1)
                        continue;
                    a[k] = 1;
                    System.out.println(s + " " + (char) (i + 'A') + (char) (j + 'A') + (char) (k + 'A') + " " + remain(a));  //填空位置
                    a[k] = 0;
                }
                a[j] = 0;
            }
            a[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[9];
        a[0] = 1;

        for (int b = 1; b < a.length; b++) {
            a[b] = 1;
            for (int c = b + 1; c < a.length; c++) {
//                System.out.println(remain(a));
                a[c] = 1;
                String s = "A" + (char) (b + 'A') + (char) (c + 'A');
                f(s, a);
                a[c] = 0;
            }
            a[b] = 0;
        }
    }
}
