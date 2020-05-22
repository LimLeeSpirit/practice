package algorithm.Aleetcode9_动态规划.leetcode10;

/**
 * 正则表达式匹配
 * '.'匹配任意单个字符，'*'匹配前面的字符的任意个数
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 *
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 和44题字符串匹配道理相似，都可以用 dp
 *
 * 方法：动态规划
 *      （1）动态规划的变量是什么
 *      （2）动态方程是什么
 *
 * 第二次做了，还是有点困难，这个题真的很难
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] DP = new boolean[m + 1][n + 1];
        DP[0][0] = true;
        for (int i = 0; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                // i 和 j 相互匹配或者 p[j] = '.'
                if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '.')) {
                    DP[i][j] = DP[i - 1][j - 1];
                }
                // 如果 j 前面最近的一个为 *
                if (p.charAt(j - 1) == '*') {
                    // 在匹配的时候，* 前面的字符也和 i 处字符不匹配，所以没有用 * 前面的字符进行匹配
                    if (i == 0 || s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        DP[i][j] = DP[i][j - 2];

                        // j 前面最近的一个为 *，要么使用'*'号进行匹配(f[i-1][j])，
                        // 要么只使用'*'号前面的那个字符匹配，不使用'*'匹配(f[i][j-1])，
                        // 要么'*'号前面的那个字符在匹配的过程当中一个都不使用（f[i][j-2]，
                        // 只要有一个是 true 则能够匹配。
                    } else {
                        DP[i][j] = DP[i - 1][j] || DP[i][j - 1] || DP[i][j - 2];
                    }
                }
            }
        }

        return DP[m][n];
    }
}
