package algorithm.Aleetcode9_动态规划.leetcode518;

/**
 * 零钱兑换II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 是一个完全背包问题，天呐，怎么可以这么简单就解决了，背包问题需要再注意一下，学完之后去学习一下
 * 322 求最少币数
 */
public class Solution {
    public int change(int m, int[] coins) {
        int[] DP = new int[m + 1];
        DP[0] = 1; // DP[i] 代表 i 块钱共有多少种方案
        for (int c : coins) {
            for (int j = c; j <= m; j ++) {
                DP[j] += DP[j - c];
            }
        }
        return DP[m];
    }
}
