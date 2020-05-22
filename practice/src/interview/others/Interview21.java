package interview.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入N个字符串，针对每个字符串，给出能够 【确定】该字符串的最短前缀
 */
public class Interview21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            String cur = in.next();
            strs.add(cur);
        }
//        for (String s : strs) {
//            System.out.println(s);
//        }
//        System.out.println(strs.size());
        int k = 0;
        // 针对每个str，取其前缀去其他字符中判断，如果该前缀能够在其余str找到，则代表该前缀不能代表该字符串，前缀需要往后移动
        for (int i = 0; i < N; i ++) {
            int j = 1;
            while (j <= strs.get(i).length()) {
                for (; k < N; k ++) {
                    if (k != i) {
                        if (strs.get(k).startsWith(strs.get(i).substring(0, j))) {
                            j ++;
                            break;
                        }
                    }
                }
                if (k >= N) {
                    System.out.println("here?: " + j);
                    System.out.println(strs.get(i).substring(0, j));
                    k = 0;
                    break;
                }
                if (j > strs.get(i).length()) {
                    System.out.println(strs.get(i));
                    k = 0;
                    break;
                }

            }
//            System.out.println("next s is: " + strs.get(i));
        }
    }
}
