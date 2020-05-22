package algorithm.Aleetcode10_数组.JZoffer56;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 *
 * 例如输入12，从1到12这些整数中包含“1”的数字有1，10，11和12，其中“1”一共出现了5次。
 *
 * 暴力枚举法：遍历每个数，对每个数求其1出现的次数。时间复杂度O（n * m）， m为n的十进制的字符形式的长度
 */
public class Solution {
    public int numberOf1Between1AndN_Solution(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i ++) {
            ret += helper(i);
        }
        return ret;
    }
    private int helper(int i) {
        int ret = 0;
        for (char c : String.valueOf(i).toCharArray()) {
            if (c == '1') ret ++;
        }
        return ret;
    }
}
