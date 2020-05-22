package algorithm.Aleetcode10_数组.leetcode242;

/**
 *  判断两个字符串是否由相同的字母组成
 *
 *  哈哈，这次一下就想起了最优解：字符串要联想到以字母ASCII码为下标的数组。顺便说一下其他的解法
 *
 *  排序比较法、转化为字符的Map个数法
 *
 *  一个知识：ASCII码，包含128个字符，从0-127
 *          0-31、127：控制字符、通信专业字符
 *          32：空格
 *          48-57：0-9 10个阿拉伯数字
 *          65-90：A-Z 26个大写英文字母
 *          97-122：a-z 26个小写英文字母
 *
 *          一个ASCII码编码的字符占1个字节； gbk  2字节；   utf-8   3字节
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if (n != m) return false;
        int[] nums = new int[256];
        for (int i = 0; i < m; i ++) nums[s.charAt(i) - '0'] ++;

        for (int i = 0; i < n; i ++) nums[t.charAt(i) - '0'] --;

        for (int a : nums) {
            if (a != 0) return false;
        }
        return true;
    }
}
