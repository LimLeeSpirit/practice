package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode67;

import java.util.ArrayList;
import java.util.List;

/**
 *  二进制字符串的求和，依然返回字符串。
 *  我用的依然是十进制字符串的求和，用栈结构。
 *
 *  用不用栈其实无所谓，逻辑是最重要
 */
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int m = a.length(), n = b.length();
        int i = m - 1, j = n - 1;
        List<Integer> nums = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            int n1 = a.charAt(i) - '0';
            int n2 = b.charAt(j) - '0';
            int tmp = n1 + n2 + carry;
            nums.add(tmp % 2);
            carry = tmp / 2;
            i --;
            j --;
        }

        while (i >= 0) {
            int tmp = a.charAt(i) - '0' + carry;
            nums.add(tmp % 2);
            carry = tmp / 2;
            i --;
        }

        while (j >= 0) {
            int tmp = b.charAt(j) - '0' + carry;
            nums.add(tmp % 2);
            carry = tmp / 2;
            j --;
        }

        if (carry > 0) nums.add(carry);

        StringBuilder sb = new StringBuilder();
        for (int k = nums.size() - 1; k >= 0; k --) {
            sb.append(nums.get(k));
        }

        return sb.toString();

    }
}
