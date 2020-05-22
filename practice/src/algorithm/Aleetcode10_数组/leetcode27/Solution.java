package algorithm.Aleetcode10_数组.leetcode27;

/**
 * 删除数组指定元素，其余元素往后移
 * 原地移除所有数值等于 val 的元素，返回移除后数组的新长度,不需要考虑数组中超出新长度后面的元素
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution {
    public static int removeElement2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) nums[k ++] = nums[i];
        }

        return k;
    }
}
