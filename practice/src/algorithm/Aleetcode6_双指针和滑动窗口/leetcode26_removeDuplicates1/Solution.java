package algorithm.Aleetcode6_双指针和滑动窗口.leetcode26_removeDuplicates1;

/**
 * 删除有序数组的重复元素。在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {
    public static int removeDuplicates1(int[] nums) {
        /**
         *  经典的双指针题目
         *  因为要将后面的元素往前面移动，所以应该放一个自增1的指针i， 另一个指针j用来判断是否与 i 指针
         *  的元素相同，然后赋值和移动
         */
        if (nums.length == 0) return 0;
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i ++] = nums[j];
            }
        }
        return i;
    }
}
