package algorithm.Aleetcode1_二分.leetcode35;

/**
 * 二分查找，返回插入位置，即下标
 *
 * 输入: [1,3,5,6], 5 输出: 2
 * 输入: [1,3,5,6], 2 输出: 1
 */

public class Solution {
    /**
     * 就是找比目标值小的第一个数的右索引
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (nums[0] > target) return 0;
        if (nums[n - 1] < target) return n;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }

}
