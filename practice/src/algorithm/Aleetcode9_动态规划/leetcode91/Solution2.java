package algorithm.Aleetcode9_动态规划.leetcode91;

/**
 * 递归写法
 * 那个DP真的很难想到，此类问题一般还是考虑递归吧，将大问题转化为基本问题
 *
 * 比如 232232323232。
 *
 * 对于第一个字母我们有两种划分方式。
 *
 * 2 | 32232323232 和 23 | 2232323232
 *
 * 所以，如果我们分别知道了上边划分的右半部分 32232323232 的解码方式是 ans1 种，
 * 2232323232 的解码方式是 ans2 种，
 * 那么整体 232232323232 的解码方式就是 ans1 + ans2 种。
 *
 */
public class Solution2 {
    public int numDecodings(String s) {
        return getAns(s, 0);
    }
    private int getAns(String s, int start) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        int ans1 = getAns(s, start+1);
        int ans2 = 0;
        if (start < s.length()-1) {
            int ten = (s.charAt(start)-'0') * 10;
            int one = s.charAt(start+1)-'0';
            if (ten + one < 27) ans2 = getAns(s, start+2);
        }
        return ans1+ans2;
    }
}
