package algorithm.Aleetcode9_动态规划.JZoffer80;

/**
 * 将一个骰子投掷n次，获得的总点数为s，s的可能范围为n~6n
 *
 * 掷出某一点数，可能有多种掷法，例如投掷2次，掷出3点，共有[1,2],[2,1]两种掷法。
 *
 * 请求出投掷n次，掷出n~6n点分别有多少种掷法。
 *
 * 输入：n=2
 *
 * 输出：[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
 *
 * 解释：投掷2次，可能出现的点数为2-12，共计11种。每种点数可能掷法数目分别为1,2,3,4,5,6,5,4,3,2,1。
 *
 *       所以输出[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]。
 *
 * 听说是分组背包问题，后面学习下。太难了。
 */
public class Solution {
    public int[] numberOfDice(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= i * 6; j ++) {
                for (int k = 1; k <= Math.min(j, 6); k ++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        int[] ret = new int[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i ++) {
            ret[i - n] = dp[n][i];
        }
        return ret;
    }
}
