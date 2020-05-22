package interview.huawei;

import java.util.Scanner;

public class Interview3 {
    public static void main(String[] args) {
        // System.out.println('F' - '0' - 7);   // A - 0 - 7 = 17,
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            hexo2Decimal(s);
        }
    }
    private static void hexo2Decimal(String s) {
        int ans = 0;
        for (int i = 2; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c <= '9' && '0' <= c) {
                ans = (ans * 16) + (c - '0');
            } else {
                ans = ans * 16 + (c - '0' - 7);
            }
        }
        System.out.println(ans);
    }
}
