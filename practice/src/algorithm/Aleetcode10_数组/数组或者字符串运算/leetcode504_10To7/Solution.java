package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode504_10To7;

/**
 * 将一个整数转化为 7 进制数，哎，面试的时候做的不是很好，边界条件没有考虑，比如负数的情况、0的情况
 *
 * 当时回忆10进制转2进制，短除法除2 取余，在商为0的时候停止，最后将得到的余数反转。
 *
 * 不过这一次确实在清晰思路了之后，自己写的话就很快了，简单明了。
 */
public class Solution {
    public String convertToBase7(int num) {
        boolean is_minus = false;
        if (num < 0) is_minus = true;
        if (num == 0) return "0";
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (is_minus) sb.append('-');
        return sb.reverse().toString();
    }
}
