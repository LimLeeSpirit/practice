package algorithm.Aleetcode9_动态规划.leetcode55_jump_game_1;

import java.util.Arrays;

/**
 * 跳跃游戏I
 *
 * 用跳跃游戏II的思路，O（n）复杂度
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = 0;
        for (int i = 1; i < n; i ++) {
            while (last < i && i > last + nums[last]) last ++;
            // 如果没有能到达位置 i 的，那么也就无法达到 i 之后的元素了，直接返回 false
            if (last == i) return false;
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        /**
         *  我的DP解法，题目要求从第一个跳到最后一个，如果能直到中间的是否可以跳到最后一个，那么第一个是否能跳到也就能判断了
         *  从后往前跳，判断当前位置是否可以跳到最后一个元素，一直判断到第一个元素。
         *
         *  时间复杂度O(n^2),因为每个元素都要与其右边的元素相参照，右边元素最多达到n个。
         *  空间复杂度O(n),只需要开辟一个 DP 数组。
         */
        int length = nums.length;
        if (length==0) { return true; }
        boolean[] DP = new boolean[length];
        Arrays.fill(DP, false);
        DP[length-1] = true;

        for ( int i = length - 2; i >= 0; i --) {
            if (nums[i] >= length - i - 1) {
                DP[i] = true;
            } else {
                for (int j = nums[i]; j >= 0; j --) {
                    if (DP[i + j]) {
                        DP[i] = true;
                        break;
                    }
                }
            }
        }

        return DP[0];
    }

}
