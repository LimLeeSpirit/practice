package interview.others;

import java.util.Scanner;

/**
 * 统计一个字符串中有多少回文子串，给出个数
 */
public class Interview20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            for (int j = i; j < s.length(); j ++) {
                ans += check(s, i ,j);
            }
        }
        System.out.println(ans);
    }

    public static int check(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l ++;
                r --;
            } else {
                return 0;
            }
        }
        return 1;
    }
}
