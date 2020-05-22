package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode258_数字运算;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class Solution {
    public static int addDigits(int num) {
        // 递归法
        if (0 <= num && num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
    public static int addDigits2(int num) {
        /**
         * O(1)解法   观察规律
         * 假设一个三位数整数n = 100*a + 10*b + c,变化后和 = a+b+c；
         * 两者的差值 n-abc = 99a + 9b，差值可以被9整除，说明每次缩小 9 的倍数
         * 那么我们可以对res=num%9，若不为0则返回res，为0则返回9
         *
         */
        if (num > 9) {
            num = num % 9;
            if (num == 0) {
                return 9;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(21345));
    }
}
