package algorithm.Aleetcode6_双指针和滑动窗口.leetcode32;

import java.util.LinkedList;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * leetcode 5 最长回文子串（马拉车法、从中间往外扩）
 *
 * 这个题可以用DP来做，但是DP一般难以想到
 * Y总提供了一种更牛逼的思路：
 *   有效括号子串 (: 1 ): -1，也就是将左括号用 1 代替，右括号用 -1 代替，那么一个有效的子串的等价条件是：
 *   所有前缀和大于等于 0，子串和 == 0
 *
 *   比如（（）（）） 对应 1 1 -1 1 -1 -1；
 *   虽然这个思路不错，但是需要顺序判断一次，逆序再判断一次； 不如用栈来实现，栈的实现是最好的
 */
public class Solution {
    /**
     * 这个利用栈来做的不错，虽然知道可以用栈来模拟，但是怎么能够把过程也想得没有纰漏呢
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        LinkedList<Integer> stk = new LinkedList<>();
        // 先push一个进去，防止 pop 抛出异常
        stk.push(-1);
        int ret = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.isEmpty()) {
                    stk.push(i);
                } else {
                    ret = Math.max(ret, i - stk.peek());
                }
            }
        }
        return ret;
    }

    public int longestValidParentheses(String s) {
        int ret1 = work(s);
        System.out.println(ret1);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i --) {
            // 左括号 与 右括号 的二进制位只在最后一位不同，进行异或操作相互转换
            char c = (char)(s.charAt(i) ^ 1);
            sb.append(c);
        }
        return Math.max(ret1, work(sb.toString()));
    }

    /**
     * 用双指针法找到最长的合理字符串长度
     * start 代表最长字符串起始点
     * 如果前缀和小于 0，说明肯定不是合理的；如果前缀和==0，则说明肯定有效，更新；若>0,则继续走，不过这里容易一直往后走，
     * 走到最后，比如 ((((),这种情况返回 0，所以需要反序再查找一遍。
     * @param s
     * @return
     */
    private int work(String s) {
        int ret = 0;
        for (int i = 0, start = 0, cnt = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                cnt ++;
            } else {
                cnt --;
                if (cnt < 0) {
                    start = i + 1;
                    cnt = 0;
                } else if (cnt == 0) {
                    ret = Math.max(ret, i - start + 1);
                }
            }
        }
        return ret;
    }
}
