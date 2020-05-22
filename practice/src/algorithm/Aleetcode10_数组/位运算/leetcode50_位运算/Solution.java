package algorithm.Aleetcode10_数组.位运算.leetcode50_位运算;

/**
 *  计算 x 的 n 次方
 *
 *  又是面试跪了，我咋就没想到将n一步一步减小呢？思维局限啊
 */
public class Solution {
    public static double myPow(double x, int n) {
        /**
         * 精妙的位运算，我自己在写的时候不知道如何处理n = 9 这样的奇数的情况
         *
         * 3的5次方：3X3 3X3 再X3
         * 常识： 涉及正负数的时候转化为正数去做，负数只需要转化一下就好了。
         */

        if (n == Integer.MIN_VALUE) {
            return myPow(x, n + 1) * x;
        }
        if (n < 0) {
            x = 1 / x;
            n = - n;
        }

        double ret = 1;
        while (n > 0) {
            // 如果 n 为奇数，则直接将 x 乘一个进入 ret。后面n >> 1的时候就不会丢失一个 n
            // 而且在 n > 0 的时候，ret 会一直自乘，当 n = 1 时， 结束返回
            if ((n & 1) == 1) ret *= x;
            x *= x;
            n >>= 1;
        }
        return ret;
    }
}
