package algorithm.Aleetcode6_双指针和滑动窗口.leetcode122;

/**
 * 股票买卖第二题，可以买多次，但是每笔交易不能重叠
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 真的就只有这么简单而已，像这种驼峰式的 4，7，6。 为7-4 = 3； 等价于 4， 6， 7
 */
public class Solution {
    public int maxProfit(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i - 1])
                sum += nums[i] - nums[i -1];
        }
        return sum;
    }
}
