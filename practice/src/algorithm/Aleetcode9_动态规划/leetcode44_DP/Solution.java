package algorithm.Aleetcode9_动态规划.leetcode44_DP;

/**
 * 通配符匹配
 * ？ 可匹配任意单字符
 * *  可匹配任意字符
 *
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 * 和 leetcode10 正则表达式匹配有点类似。
 *
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        /*
         * 这里为什么会想到用二维数组来做存储呢？匹配的是一维，数量是2 ，那就用2维数组保存中间结果。
         */
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始条件
        dp[0][0] = true;
        for (int i = 1; i <= n; i ++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                // 最简单的情况
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 如果 p 串的第 j 个字符为 *
                } else if (p.charAt(j - 1) == '*') {
                    // 则可以让 s 串的前 i 个字符与这个 * 对应（* 匹配 s 的前 i 个字符）
                    // 或者是 * 匹配零个字符
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}