package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode172_数字计算;

/**
 * 给定一个整数 n，返回 n! 结果, 尾数中零的数量。
 * 5X2 有一个0
 * 25X2 有一个0
 * 25X4 有两个0
 * 125X8 有三个0
 * ...
 * 由于n!的后缀0是由起质因子2和质因子5相乘而来的，而2的个数总是比5多的，因此我们只需要计算n!中质因子5的个数即可。
 *
 * 要求n!中质因子5的个数即可，可以通过求∑n5i
 * 而得。
 *
 * 例如，求245！末尾0的个数时，
 *
 * 245/5=49 代表着有49个数(可被5
 * 整除)贡献了1个5，
 *
 * 245/25=9 代表着有9个数(可被5×5
 * 整除)在上一行的基础上多贡献了1个5，
 *
 * 245/125=1 代表着有1个数(可被5×5×5
 * 整除)在上一行的基础上多贡献了1个5，
 *
 * 像数字50在第一行被call过，在第二行也被call过，给target贡献了两个5，
 *
 * 所以245!末尾0的个数为49+9+1=59。
 *
 */
public class Solution {
    public static int trailingZeroes2(int n) {
         int res=0;
         while (n >= 5) {
             n = n/5;
             res += n;
         }
         return res;
    }

    public int trailingZeroes(int n) {
        return n < 5 ? 0 : n/5 + trailingZeroes(n/5);
    }

}

