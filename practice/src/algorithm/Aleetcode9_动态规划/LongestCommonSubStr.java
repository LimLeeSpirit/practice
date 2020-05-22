package algorithm.Aleetcode9_动态规划;

/**
 * 求两个字符串的公共最长子串
 *
 * 这个题比较常见了
 * 法1：暴力法，求出 s1 的所以子串，从长到短判断每一个子串是否是 s2 的子串。这种方法就得新增一个方法：判断一个子串是否是 s 的子串
 *
 * 法2：滑动窗口法，比较难想
 *
 * 法3：DP。DP[i][j]表示以 s1[i] 和 s2[j] 结尾的公共子串的长度，还要设置一个全局最长子串长度和开始下标
 *         s1[i] == s2[j]：DP[i+1][j+1] = DP[i][j] + 1;
 *         else : DP[i][j] = 0
 *
 *         time: O(n^2), space: O(n * 2)
 */
public class LongestCommonSubStr {
    public static String getLongestCommonSub(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int max_len = 0;
        int end_idx = 0; // 记录下标，相同子串在s1中的结束下标

        int[][] DP = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                    if (DP[i][j] > max_len) {
                        max_len = DP[i][j];
                        end_idx = i;
                    }
                } else {
                    DP[i][j] = 0;
                }
            }
        }

        return s1.substring(end_idx - max_len, end_idx);
    }
    public static void main(String[] args) {
        System.out.println(getLongestCommonSub("abccaddekk", "dgccaddehj"));
    }
}
