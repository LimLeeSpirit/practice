package algorithm.Aleetcode9_动态规划.leetcode91;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution {
    public int numDecodings(String s) {
        /**
         * 又是DP，这次第三次其实还是想到了一些的
         * count(str) = count(str.substring(0, length - 2)) + count(str.substring(0, length - 1))
         *
         * 具体的例子如："12321"的解码数 = "1232"的解码数 + "123"的解码数(因为后面的 21 构成了合法的数字)
         *
         */
        if (s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];

            //判断后两位是否在[10,26]，可以的话说明最后两位可以组成合法字母，也就成为了一种解码方式
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')
                dp[i] += dp[i - 2];

        }
        return dp[n];
    }


}
