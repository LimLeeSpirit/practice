package algorithm.Aleetcode9_动态规划.leetcode152_最大子序列乘积;


/**
 *  数组中最大连续子序列的乘积
 *
 *  leetcode52 是 最大和连续子数组的和（子数组最少包含一个元素）
 *
 *  明显用DP，但是怎么用又不知道，声明一维数组又不行，怎么脑子就不能聪明点，升维呀？
 *  在实现的时候主要考虑到有时一个最小的负数，突然遇到一个负数，那么不就变最大了吗？真的高级
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums ==null || nums.length == 0) { return 0; }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int ret = nums[0];
        for (int i = 1; i < n; i ++) {
            dp[i][0] = Math.min(dp[i - 1][0] * nums[i], Math.min(dp[i - 1][1] * nums[i], nums[i]));
            dp[i][1] = Math.max(dp[i - 1][0] * nums[i], Math.max(dp[i - 1][1] * nums[i], nums[i]));
            ret = Math.max(ret, dp[i][1]);
        }
        return ret;
    }

    public int maxProduct2(int[] nums) {
        /**
         *  优化，当前处的DP结果只与上一次的结果有关，那么只保存上一次的结果不就可以得到下一次的结果了嘛.
         *  上一次：写在第一行，那么下一次就写第0行；上一次写在第0行，下一次就写在第一行。
         */
        if (nums ==null || nums.length == 0) { return 0; }
        int m = nums.length;
        int[][] DP = new int[2][2];
        DP[0][0] = nums[0];
        DP[0][1] = nums[0];
        int ret = nums[0];
        for (int i=1; i<m; i++) {
            if ((i&1)==1) {
                DP[1][0] = Math.max(Math.max(DP[0][0] * nums[i], DP[0][1] * nums[i]), nums[i]);
                DP[1][1] = Math.min(Math.min(DP[0][0] * nums[i], DP[0][1] * nums[i]), nums[i]);
                ret = Math.max(ret, DP[1][0]);

            } else {
                DP[0][0] = Math.max(Math.max(DP[1][0] * nums[i], DP[1][1] * nums[i]), nums[i]);
                DP[0][1] = Math.min(Math.min(DP[1][0] * nums[i], DP[1][1] * nums[i]), nums[i]);
                ret = Math.max(ret, DP[1][0]);
            }
        }
        return ret;
    }

    public int maxProduct3(int[] nums) {
        /**
         *  进一步优化，只保存3个值就可以了，当前最大值，当前最小值，全局最大值。连二维数组都省了
         */
        if (nums ==null || nums.length == 0) { return 0; }
        int n = nums.length;
        int cur_min = nums[0];
        int cur_max = nums[0];
        int ret = nums[0];
        for (int i = 1; i < n; i ++) {
            int a = cur_min * nums[i];
            int b = cur_max * nums[i];
            cur_min = Math.min(a, Math.min(b, nums[i]));
            cur_max = Math.max(a, Math.max(b, nums[i]));
            ret = Math.max(ret, cur_max);
        }
        return ret;
    }
}
