package algorithm.Aleetcode9_动态规划.leetcode300;

import java.util.Arrays;

/**
 *  最长上升子串的长度，上升的元素可以不相邻，难就难在这
 *  仍然是用DP
 *  首先考虑一点：遍历到 i 位置，如意能找出前面有多少个比 nums[i] 小的，那不就很好判断了嘛？
 *              然后仔细想一下：前面的小的值，也要升序才行，如果这是用到记忆性，能找到前面的最长序列，然后加上当前的，不就好了嘛？
 *              ！！！牛逼！！！！。
 *              依然保持一个全局最小，每次和当前最小比较。
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // DP[i] 代表对于当前元素，前面有多少个小于自己的且是升序的
        int[] DP = new int[n];

        int ret = 1;

        Arrays.fill(DP, 1);

        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    DP[i] = Math.max(DP[j] + 1, DP[i]);
                }
            }
            ret = Math.max(ret, DP[i]);
        }
        return ret;
    }
}
