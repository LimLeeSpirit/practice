package interview.others;

import java.util.Scanner;

/**
 * 病毒检查？
 * 输入
 * 2
 * 01010101
 *
 * next()、nextLine()、nextInt() 的区别
 */
public class Interview12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int k = in.nextInt();
        int k = Integer.valueOf(in.nextLine());
        String s = in.nextLine();
        System.out.println("k:" + k);
        System.out.println("s:" + s);
        int ans = 0;
        int start = k;
        // 获取所有长度大于等于 k 的子串，并判断每个子串是否满足条件
        while (start <= s.length()) {
            for (int i = 0; i < s.length() - start + 1; i ++) {
                System.out.println("sub is :" + s.substring(i, i + start));
                ans += checkSub(s.substring(i, i + start), k);
            }
            start ++;
        }
        System.out.println(ans);
    }
    public static int checkSub(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt ++;
            }
        }
        return cnt == k ? 1 : 0;
    }
}
