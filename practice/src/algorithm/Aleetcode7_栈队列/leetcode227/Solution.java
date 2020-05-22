package algorithm.Aleetcode7_栈队列.leetcode227;

import java.util.LinkedList;

/**
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * 这个题其实考的就是栈的思想，先利用栈算出乘除的结果
 * 有一些细节很需要注意，比如入栈元素的正负号，设置一个 minus 变量代表下一个值的正负，然后将所以的值放入栈
 *                   又比如在遇到数字的时候，需要将空格略过，数字可能又多位。
 * 最后将栈内的值相加就得出结果了。
 */
public class Solution {
    public static int calculate(String s) {
        s = s.trim();
        int m = s.length();
        int i = 0;

        LinkedList<Integer> stk = new LinkedList<Integer>();

        int minus = 1;

        while (i < m) {
            int tmp = 0;
            while (s.charAt(i) == ' ') i ++;

            if (s.charAt(i) == '+') {
                minus = 1;
                i ++;
            } else if (s.charAt(i) == '-') {
                minus = -1;
                i ++;
            } else if (s.charAt(i) == '*') {
                int a1 = stk.pop();
                ++ i;
                while (s.charAt(i) == ' ') i ++;

                while (i < m && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                    i ++;
                }
                stk.push(a1 * tmp);
            } else if (s.charAt(i) == '/') {
                int a1 = stk.pop();

                ++ i;
                while (s.charAt(i) == ' ') i ++;

                while (i < m && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                    i ++;
                }
                stk.push(a1 / tmp);

            } else if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                while (i < m && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                    i ++;
                }
                stk.push(tmp * minus);
            }
        }
        int ans = 0;
        while (stk.size() > 0) {
            ans += stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1*2*3*4*5*6*7*8*9*10"));
    }
}
