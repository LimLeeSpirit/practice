package algorithm.Aleetcode1_二分.leetcode153;

/**
 *  查找旋转数组中的最小值，数组中不存在重复元素
 *
 *  跟 leetcode 33、34、154 均是二分查找的变种！
 *
 *  法1：顺序遍历，获取比前一个元素小的第一个元素。时间复杂度O(n)
 *  法2：二分查找的思想：时间复杂度O(lgn)。这个思想的变种很值得学习。
 *
 *
 *  第三遍的时候差点记不起思路，最小值的左边全是大于它右端点值的，所以在遇到这种情况的时候，mid处一定不是答案，
 *                          所以[l, r] -> [mid + 1, r]
 */
public class Solution {
    public static int findMin2(int[] nums) {
        /**
         *  哈哈哈，其实就是用模版1：
         *  找出不满足规则的第一个数。规则是 nums[mid] >= nums[l] && nums[mid] > nums[r] 在左边
         */
        if ( nums == null || nums.length == 0) { return -1; }
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(findMin2(nums));
    }
}
