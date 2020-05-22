package algorithm.Aleetcode6_双指针和滑动窗口.leetcode80_removeDuplicates2;

/**
 *  删除排序数组中的重复项 II
 *
 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *  给定 nums = [1,1,1,2,2,3],
 *
 *  函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3) return n;

        int k = 1;
        for (int i = 2; i < n; i ++) {
            if (nums[i] != nums[k - 1]) {
                nums[++ k] = nums[i];
            }
        }
        k ++;
        return k;
    }
}
