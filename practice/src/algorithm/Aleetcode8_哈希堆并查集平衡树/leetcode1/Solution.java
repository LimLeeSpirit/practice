package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Solution {
    /**
     * 开一个哈希表存之前遍历过的数，以及下标，然后在遍历的时候查找目标数字是否出现过
     * @param nums   数组
     * @param target 之和
     * @return       两个下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
