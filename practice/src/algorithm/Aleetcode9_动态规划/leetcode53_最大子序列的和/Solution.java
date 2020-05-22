package algorithm.Aleetcode9_动态规划.leetcode53_最大子序列的和;

/**
 * 求出给定数组中 和最大的子数组的和    最大连续子数组之和
 *
 * 就算是看起来这么简单的DP我也想不出来啊。。。。
 * 他的设计很巧妙，利用sum来跳过那些负数，res来保存到当前位置最大的连续和，res更新为二者之间的较大者。
 */
public class Solution {

    /**
     * 这才是最能想到的DP好吗，，，DP[i] = max { DP[i-1], nums[i-1], 包含nums[i]在内的 maxEnd[i] }
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            // curMax 为包含 i 位置上的值的最大子序和
            curMax = Math.max(nums[i], curMax + nums[i]);
            dp[i] = Math.max(nums[i], Math.max(curMax, dp[i - 1]));
        }
        return dp[n - 1];
    }

    public static int maxSubArray2(int[] nums) {
        // 代表DP[i]，DP 这一类集合的含义是：包括 i 的最大和子序
        int last = 0;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            int now = Math.max(last, 0) + nums[i];
            ret = Math.max(ret, now);
            last = now;
        }
        return ret;
    }
}
