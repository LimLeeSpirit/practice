package algorithm.Aleetcode10_数组.JZoffer81;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 *
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
 *
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，大小王可以看做任意数字。
 *
 * 为了方便，大小王均以0来表示，并且假设这副牌中大小王均有两张。
 *
 * 输入：[0,8,9,11,12]
 *
 * 输出：true
 *
 * 1、求出 0 的个数
 * 2、在非 0 中如果有相同的，则肯定不是顺子
 * 3、非 0 元素中的最大值和最小值的差在 4 以内，则是顺子
 *
 * 想想也挺简单，见过一次就能很快做出来。
 */
public class Solution {
    public boolean isContinuous(int [] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int k = 0;
        Arrays.sort(nums);
        while (nums[k] == 0) k ++;
        for (int i = k + 1; i < n; i ++) {
            if (nums[i] == nums[i - 1]) return false;
        }
        return nums[n - 1] - nums[k] <= 4;
    }
}
