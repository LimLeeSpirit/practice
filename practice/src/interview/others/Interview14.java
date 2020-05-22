package interview.others;

import java.util.Scanner;

/**
 * 正则表达式匹配
 * 输入描述:
 * 输入第一行包含一个字符串p， (1 ≤ |p| ≤ 20).
 * 输入第二行包含一个字符串t， (1 ≤ |t| ≤ 20).
 *
 * 输出描述:
 * 输出仅包含0和1的整数，0表示p和t不匹配，1表示p和t匹配。
 *
 * a*b
 * ab
 * t:ab
 * p:a*b
 * 1
 *
 */
public class Interview14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p = in.nextLine();
        String t = in.nextLine();
        System.out.println("p:" + p);
        System.out.println("t:" + t);

        int m = t.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始条件
        dp[0][0] = true;
        for (int i = 1; i <= n; i ++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                // 最简单的情况
                if (t.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 如果 p 串的第 j 个字符为 *
                } else if (p.charAt(j - 1) == '*') {
                    // 则可以让 t 串的前 i 个字符与这个 * 对应（* 匹配 t 的前 i 个字符）
                    // 或者是 * 匹配零个字符
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        if (dp[m][n]) System.out.println("1");
        else System.out.println("0");
    }

}
