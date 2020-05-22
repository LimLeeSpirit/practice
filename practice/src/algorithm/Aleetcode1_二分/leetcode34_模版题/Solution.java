package algorithm.Aleetcode1_二分.leetcode34_模版题;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 利用二分找两次 分别找第一次出现的下标和最后一次出现的下标。时间复杂度O（nlgn）
 *
 * 找第一次出现的下标：
 *      找出条件，第一个出现的下标左边的值都满足：nums[i] < k。
 *      if (nums[mid] < k)，mid 一定不是答案，故[l, r] -> [mid + 1, r]; 否则，[l,r] -> [l, mid]
 * 找最后一次出现的下标：
 *      找出条件，发现最后u一次出现的下标的左边的值都满足：nums[i] <= k.
 *      if (nums[mid] <= k) 答案在右半区，且 mid 可能是答案，故[l, r] -> [mid, r];
 *          否则，[l, r] -> [l, mid - 1]。由于出现了 -1 操作，故需要在计算 mid 的时候 + 1。
 *
 *          在出现了 l = mid - 1 的时候，需要在计算 mid 的时候，写成 mid = l + r + 1 >> 1;
 *          是因为这相当于是对(l + r)/2 向上取整；
 *          如果不这样，在 l + 1 = r 的时候， mid = l + r >> 1 = 2l + 1 >> 1 = l;
 *          如果 达到了 l = mid 的情况，区间[l, r]  变化为  [mid, r] = [l, r]，所以会造成死循环
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ret = new int[2];

        // 先找左端点
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid =  l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (nums[r] != target) {
            return new int[]{-1, -1};
        }
        ret[0] = r;

        // 再找右端点
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        ret[1] = r;

        return ret;
    }
}
