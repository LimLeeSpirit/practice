package algorithm.Aleetcode9_动态规划.leetcode45_jump_game_2;

/**
 *  跳跃游戏 II。假定能从第一个跳到最后一个，问最少需要几步，可以跳到。
 *
 *  输入: [2,3,1,1,4]
 *  输出: 2
 *  解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 *  动态规划，然后用贪心去优化，https://www.acwing.com/solution/LeetCode/content/107/
 *
 *  dp[i] 代表跳到位置 i 的最少步数。
 *  last 指针代表能跳到位置 i 的上一步位置
 *
 *  而且 last 是随着 i 单调增加的！只需要O（n）时间复杂度，O（n）空间
 *
 */
public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int last = 0;
        for (int i = 1; i < n; i ++) {
            while (i > nums[last] + last) last ++;
            dp[i] = dp[last] + 1;
        }
        return dp[n - 1];
    }
}


