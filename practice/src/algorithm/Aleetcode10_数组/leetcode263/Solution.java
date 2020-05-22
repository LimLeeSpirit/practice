package algorithm.Aleetcode10_数组.leetcode263;

/**
 * 判断一个正整数是否只有2、3、5这些因子
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−2^31,  2^31 − 1]。
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 5 == 0) num /= 5;
        while (num % 3 == 0) num /= 3;
        while (num % 2 == 0) num /= 2;
        return num == 1;
    }
}
