package algorithm.Aleetcode10_数组.位运算.leetcode191_位运算;

/**
 *  计算一个整数的汉明距离
 */
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n-1);
            ret ++;
        }
        return ret;
    }
}
