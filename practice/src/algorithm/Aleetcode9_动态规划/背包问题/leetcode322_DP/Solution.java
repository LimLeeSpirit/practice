package algorithm.Aleetcode9_动态规划.背包问题.leetcode322_DP;

import java.util.Arrays;

/**
 *  零钱置换算法，我觉得这个 DP 真的很难，可以参考这个题解
 *  求最少的钱个数
 *
 *  Y总说这是一个完全背包问题，后面学习下！
 *  leetcode 518 求总方案数
 */
public class Solution {
    public int coinChange2(int[] coins, int amount) {
        // DP[i] 代表从开头走到 i 的最小步数
        int[] DP = new int[amount + 1];
        Arrays.fill(DP, amount + 1);
        DP[0] = 0;// DP[i] 代表 i 块钱最少需要多少的钱币数
        for (int i = 0; i < amount + 1; i ++) {
            for (int coin : coins) {
                if (coin <= i) {
                    DP[i] = Math.min(DP[i], DP[i - coin] + 1);
                }
            }
        }
        return DP[amount] < amount + 1 ? DP[amount] : -1;

    }
}
