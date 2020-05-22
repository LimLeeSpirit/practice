package algorithm.Aleetcode7_栈队列.leetcode560;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续子数组的个数。
 *
 * 又是连续子数组，53题是求最大连续子数组的和。
 *
 * 会不会又和前缀和有关呢？没错，这题想到了前缀和，就作出了一半了。
 * 画个图，当遍历到第 i 个位置出，其前缀和为 sum[i],看看在[0,i - 1]处的前缀和中，有多少等于 sum[i] - k，
 * 中间的就是等于 K 的；
 *
 * 求出其个数，不就得到一个子结果了嘛，要统计个数，hash 就又派上用场了
 *
 * 复杂度又成为了O（n）
 *
 * 这个题和JZ76题有着相同的解题思路，那个是求连续子数组的集合，这个是求个数
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // <sum, cnt>
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int ret = 0;
        // sum[-1] = 0,代表有一个 前缀和 = 0，就是还没有元素的时候
        hash.put(0, 1);

        for (int i = 0, sum = 0; i < nums.length; i ++) {
            // 求前缀和 sum 的步骤放在了这里
            sum += nums[i];

            if (hash.containsKey(sum - k)) {
                ret += hash.get(sum - k);
            }

            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }

        return ret;
    }
}
