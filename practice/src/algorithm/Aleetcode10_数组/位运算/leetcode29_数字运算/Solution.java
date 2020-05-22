package algorithm.Aleetcode10_数组.位运算.leetcode29_数字运算;

/**
 * 两整数相除，不用除法，乘法运算！
 *
 * 位运算！ 这种思路很棒！ 可以总结下。
 */
public class Solution {
    public static int divide2(int dividend, int divisor) {
        // 相当于位运算的解法。100,3 减3，6，12，24，48，，，这样子减下去
        // 这种思路很棒！

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        long sum;
        while (b <= a) {
            sum = b;
            int count = 1;
            while ((sum<<1) <= a) {
                count <<= 1;
                sum <<= 1;
            }

            System.out.println("count:" + count);
            a -= sum;
            res += count;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            res = - res;
        }
        return res;
    }
}
