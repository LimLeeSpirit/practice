package algorithm.Aleetcode10_数组.leetcode31_nextPermutation;

import java.util.Arrays;

/**
 * 数组的下一升序数组，仅仅是第一个比原数组大的升序数组
 * 用什么规则去求出第一个呢？感觉这道题考的是对题目的理解
 * 这里的全排列可以组成一个循环，比如：1,2,3 -> 1,3,2 -> 2,1,3 -> 2,3,1 -> 3,1,2 -> 3,2,1 -> 1,2,3
 *
 * 解决方法，从后往前遍历，找到降序的位置，记录下标为j，然后再次从后往前找到第一个大于 nums[j] 的值，交换这两个元素的值
 * ，将下标 j + 1 及往后的序列升序 即得到下一个排列。
 *
 * 注意新知识：复制数组 System.arraycopy(src, start, des, start, copyOfLength);
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = -1;
        for (int i = n - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int k = n - 1; k > j; k --) {
            if (nums[k] > nums[j]) {
                int tmp = nums[k];
                nums[k] = nums[j];
                nums[j] = tmp;
                break;
            }
        }
        // reverse j+1 - end
        reverse(nums, j + 1, n - 1);
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
