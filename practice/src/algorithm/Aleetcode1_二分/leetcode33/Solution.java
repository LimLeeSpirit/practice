package algorithm.Aleetcode1_二分.leetcode33;

import java.util.Arrays;

/**
 * 搜索旋转排序数组I.无重复元素； 搜索旋转排序数组II，有重复元素；
 *
 * 旋转排序数组的意思就是在 本来一个升序数组，截取其前部分放到后面所组成的新数组。
 *
 * 注意总结知识：复制数组，数组二分查找 都在 java.utils.Arrays
 *
 * 哈哈哈其实更不错的应该是利用模版1 二分 找到最小元素的下标，然后再分别判断目标在左子升序数组还是右子升序数组。
 *
 */
public class Solution {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        // 找到最小值的下标，就是 153 题
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= nums[r]) r = mid;
            else l = mid + 1;
        }

        // 此时的 l = r 且都处于最小值的位置，判断目标在哪一个半区
        // 在右半区
        if (target <= nums[nums.length-1] )  r = nums.length-1;
        // 左半区
        else {
            l = 0;
            r --;
        }

        // 再利用一次二分进行查找
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target)  r = mid;
            else l = mid + 1;
        }

        if (nums[l] == target) return l;
        return -1;

    }

    public static int search2(int[] nums, int target) {
        // 妈的居然直接搜索查找，好卑鄙！但是这不就是直接搜索查找吗。。。。服了.复杂度是O（n）
        int res=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
                res=i;
        }
        Arrays.binarySearch(nums, target);
        return res;
    }
}
