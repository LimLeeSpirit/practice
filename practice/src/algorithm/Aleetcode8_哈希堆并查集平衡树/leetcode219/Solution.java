package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode219;

import java.util.HashSet;
import java.util.Set;

/**
 * 217 存在重复元素 I
 * 219 存在重复元素 II
 * 220 存在重复元素 III
 *
 * 219
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /**
         * 最为基本的解法，顺序遍历，毫无技巧可言，时间复杂度O(nk)。但是超时
         */
        for (int i=0; i<nums.length; i++) {
            for (int j = i + 1; j <= i + k && j<nums.length; j ++) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        /**
         * 法2，维护一个长度为 k 的散列表,好聪明哦！
         * 反正要求就是相等的元素的下标差在 k 以内 + 以hash表判重
         */
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
