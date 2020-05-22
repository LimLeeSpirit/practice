package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode8_数字运算;

/**
 * String to integer(atoi)
 *
 * 1、忽略所有行首空格，找到第一个非空格字符，可以是 ‘+/−’ 表示是正数或者负数，紧随其后找到最长的一串连续数字，将其解析成一个整数；
 * 2、整数后可能有任意非数字字符，请将其忽略；
 * 3、如果整数长度为0，则返回0；
 * 4、如果整数大于INT_MAX(2^31 − 1)，请返回INT_MAX；如果整数小于INT_MIN(−2^31) ，请返回INT_MIN；
 *
 */
public class Solution {
    public int myAtoi2(String s) {
        int k = 0;
        int n = s.length();
        // 去首部空格
        while (k < n && s.charAt(k) == ' ') k ++;

        long isMinus = 1;
        if (k < n && s.charAt(k) == '+') k ++;
        else if (k < n && s.charAt(k) == '-') {
            k ++;
            isMinus = -1;
        } else if (k > 0 && k < n && s.charAt(k) == '-' && s.charAt(k- 1) == '+') return 0;

        // 边计算边判断是否超了边界，str 可能已经超过 Long.MAX_VALUE "9223372036854775808"
        long ret = 0;
        while (k < n && s.charAt(k) >= '0' && s.charAt(k) <= '9') {
            ret = ret * 10 + s.charAt(k) - '0';
            if (ret * isMinus > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (ret * isMinus < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            k ++;
        }
        return (int) (ret * isMinus);
    }
}
