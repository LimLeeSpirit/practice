package algorithm.Aleetcode9_动态规划.leetcode72;

/**
 *  给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数。
 *  你可以对一个单词进行如下三种操作：
 *      插入一个字符
 *      删除一个字符
 *      替换一个字符
 */
public class Solution {
    public static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // DP[i][j] 代表 将 s1 前 i 个字符转化为 s2 前 j 个字符所以的最少操作
        // 集合：将 s1 前 i 个字符转化为 s2 前 j 个字符所需的操作，属性：数量最少的操作
        int[][] DP = new int[m + 1][n + 1];

        // 初始化
        for (int i = 1; i <= n; i ++) DP[0][i] = i;

        for (int j = 1; j <= m; j ++) DP[j][0] = j;

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) DP[i][j] = DP[i - 1][j - 1];
                else {
                    // 分别代表删除、插入、替换操作
                    // 删除：s1 删除i之后，和s2的前j个相同，则说明s1 的前i-1个已经相同s2的前j个相同了
                    // 插入：同理
                    // 删除：同理
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j], DP[i][j - 1]),
                            DP[i - 1][j - 1]) + 1;
                }
            }
        }

        return DP[m][n];
    }
}
