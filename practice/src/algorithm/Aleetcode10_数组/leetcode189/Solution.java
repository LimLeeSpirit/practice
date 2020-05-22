package algorithm.Aleetcode10_数组.leetcode189;

/**
 * 旋转数组，书上也有过
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 */
public class Solution {
    /**
     * 时间O（nk），空间 O（1）
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l ++;
            r --;
        }
    }


}
