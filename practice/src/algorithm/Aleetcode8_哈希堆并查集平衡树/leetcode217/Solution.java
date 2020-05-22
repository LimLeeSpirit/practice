package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode217;

import java.util.HashMap;
import java.util.Map;

/**
 * 217 存在重复元素 I
 * 219 存在重复元素 II
 * 220 存在重复元素 III
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : nums) {
            count.put(a, count.getOrDefault(a, 0) + 1);
            if (count.get(a) > 1) {
                return true;
            }
        }
        return false;
    }
}
