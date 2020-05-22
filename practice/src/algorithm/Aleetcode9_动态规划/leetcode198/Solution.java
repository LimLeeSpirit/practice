package algorithm.Aleetcode9_动态规划.leetcode198;

/**
 * 打家劫舍问题
 *
 * 在给定数组中找出元素的和为最大，要求是元素之间不能相邻
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 这题其实是告诉我们动态变量可以不只一个
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // f[i] 代表前 i 个数中 不选 第i个数的所有选法的最大值
        int[] f = new int[n + 1];

        // g[i] 代表前 i 个数中 选   第i个数的所有选法的最大值
        int[] g = new int[n + 1];

        for (int i = 1; i <= n; i ++) {
            f[i] = Math.max(f[i - 1], g[i - 1]);

            g[i] = f[i - 1] + nums[i - 1];
        }
        return Math.max(g[n], f[n]);
    }
}
