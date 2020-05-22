package algorithm.Aleetcode1_二分.leetcode154;

/**
 *  查找旋转数组中的最小值，和 153 题相比，难点的一点是：数组中可能存在重复元素
 *
 *  跟 leetcode 33、34、153 均是二分查找的变种！
 *
 *  1 1 0 1
 *  1 1 1 0 1
 *  1 0 1 1 1
 *  1 1 1 1
 *
 *  有重复元素，左右端点值可能相同，把相同值移除就行了，就像搜索旋转数组II一样
 *
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length - 1;
        while (n >= 0 && nums[n] == nums[0]) n --;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            // 注意这里只能用 nums[r] 来比较
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
