package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode43_数字计算;

/**
 * 两个字符串形式的大整数相乘，字符串长达 110 位。求这两个字符串代表的正数相乘后的整数的字符串形式。
 *
 * 当然无法直接转为整形计算了。
 *
 * (高精度乘法，模拟) O(nm)
 *
 * 本题是经典的高精度乘法，可以直接模拟竖式乘法计算。
 * 乘积的最大长度为两个乘数的长度之和。
 *
 */
public class Solution {
    public static String multiply(String num1, String num2) {
        /**
         *  经典的大数相乘运算，记住套路
         */
        int m = num1.length(), n = num2.length();
        int[] a = new int[m + n];
        for (int i = m - 1; i >= 0; i --) {
            for (int j = n - 1; j >= 0; j --) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                // 这里容易泄漏 +
                a[i + j + 1] += n1 * n2;
            }
        }

        int carry = 0;
        for (int i = m + n - 1; i >= 0; i --) {
            int cur = (carry + a[i]) % 10;
            carry = (carry + a[i]) / 10;
            a[i] = cur;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : a) sb.append(num);
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
