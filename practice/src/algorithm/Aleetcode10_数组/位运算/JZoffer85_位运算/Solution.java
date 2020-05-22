package algorithm.Aleetcode10_数组.位运算.JZoffer85_位运算;

/**
 * 不用加减乘除做加法
 *
 * 思路需要学习
 */
public class Solution {
    public int add(int num1, int num2) {
        while (num2 != 0) {
            // sum 保存没有进位的结果
            int sum = num1 ^ num2;
            // carry 保存进位的结果
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
            System.out.printf("%s, %s",sum, carry);
            System.out.println();
        }
        // 最后结果保存在 num1 里
        return num1;
    }
}
