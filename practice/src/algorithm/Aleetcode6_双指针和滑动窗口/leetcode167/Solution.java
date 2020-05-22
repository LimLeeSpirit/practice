package algorithm.Aleetcode6_双指针和滑动窗口.leetcode167;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和 等于 目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 思路：双指针算法，相当简单，主要是他是升序的，所以使用双指针，实现的复杂度为O（n）
 *      如果是乱序的，则用 hash 做。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 1, j = n;
        while (i < j) {
            int total = nums[i - 1] + nums[j - 1];
            if (total == target) return new int[]{i, j};
            else if (total < target) i ++;
            else j --;
        }
        return new int[]{};
    }
}
