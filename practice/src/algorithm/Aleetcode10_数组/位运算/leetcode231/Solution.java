package algorithm.Aleetcode10_数组.位运算.leetcode231;

/**
 *  判断一个数是否是 2 的指数
 *
 *  又是位运算，n 的二进制表示只有一个1，且在第一位，那么 n 就是2的指数
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == Integer.MIN_VALUE || n == 0) return false;
        n &= (n - 1);
        return n == 0;
    }
}
