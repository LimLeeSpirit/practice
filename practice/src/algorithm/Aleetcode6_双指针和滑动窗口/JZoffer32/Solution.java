package algorithm.Aleetcode6_双指针和滑动窗口.JZoffer32;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 *
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 *
 * 简单的双指针
 */
public class Solution {
    public void reOrderArray(int [] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if ((nums[l] & 1) == 1) l ++;
            else if ((nums[r] & 1) == 0) r --;
            else if ((nums[l] & 1) == 0 && (nums[r] & 1) == 1) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
                l ++;
                r --;
            }
        }
    }
}
