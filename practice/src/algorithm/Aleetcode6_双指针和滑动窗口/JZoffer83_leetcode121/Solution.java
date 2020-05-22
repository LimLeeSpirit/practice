package algorithm.Aleetcode6_双指针和滑动窗口.JZoffer83_leetcode121;

/**
 * 股票的最大利润I, 只能交易一次
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖 一次 该股票可能获得的利润是多少？
 *
 * 输入：[9, 11, 8, 5, 7, 12, 16, 14]
 *
 * 输出：11 = 16 - 5
 *
 * 其实就是动态保持前面 K 个元素的最小值，循环一遍就得到全局最小值。
 */
public class Solution {
    public int maxDiff(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // min_p 动态变化，代表前 i 个元素的最小值
        int min_p = nums[0];
        int ret = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > min_p) ret = Math.max(ret, nums[i] - min_p);
            min_p = Math.min(min_p, nums[i]);
        }
        return ret;
    }
}
