package algorithm.Aleetcode1_二分.leetcode81;

/**
 *  搜索旋转排序数组 II， 数组中有重复元素。
 *
 *  和 33 思路类似，但是处理起来麻烦点，右半升序的部分 需要严格小于 nums[0]
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null) return false;
        int n = nums.length - 1;
        if (n < 0) return false;
        // 尾部与 nums[0] 相等的情况的那些元素，不考虑
        while (n > 0 && nums[n] == nums[0]) n --;

        int l = 0, r = n;
        // 只有在旋转了的情况下才去找最小值下标。
        if (nums[n] < nums[0]) {
            while (l < r) {
                int mid = l + r >> 1;  // [l, mid], [mid + 1, r]
                if (nums[mid] < nums[0]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            // 目标在右半区
            if (target <= nums[n]) {
                r = n;
            } else {
                l = 0;
                r --;
            }
        }

        // 再在有序数组中进行二分查找
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target)  r = mid;
            else l = mid + 1;
        }
        return nums[l] == target;
    }
}
