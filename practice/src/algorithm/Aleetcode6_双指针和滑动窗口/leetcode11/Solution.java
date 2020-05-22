package algorithm.Aleetcode6_双指针和滑动窗口.leetcode11;

/**
 * 盛水最多的容器问题，有点像木桶效应。问的是找出其中两个元素，让他们作为木桶的两边，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * Aleetcode7_栈队列.leetcode42 数组容器问题，问数组元素当作木板，一共能容纳多少水。
 */
public class Solution {
    public static int maxArea(int[] height) {
        /**
         * 暴力遍历法
         * 获取最大的
         */
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int kuan = height[i] > height[j] ? height[j] : height[i];
                max = kuan * (j - i) > max ? kuan * (j - i) : max;
            }
        }
        return max;
    }

    public static int maxArea2(int[] nums) {
        /**
         * 可以暴力求解的一般都可以找到更优解，这里双指针法，一个从头开始，一个从尾开始就可以。
         */
        int ret = Integer.MIN_VALUE;
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int tmp =  (r - l) * Math.min(nums[l], nums[r]);
            ret = Math.max(ret, tmp);
            if (nums[r] > nums[l]) l ++;
            else r --;
        }
        return ret;
    }
}