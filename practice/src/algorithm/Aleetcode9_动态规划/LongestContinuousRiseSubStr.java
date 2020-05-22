package algorithm.Aleetcode9_动态规划;

import java.util.Arrays;

/**
 * 求字符串的最长连续上升子序列
 *
 * 和 leetcode300 最长上升子序列 对标
 */
public class LongestContinuousRiseSubStr {
    // DP
    public static int getLongestContinuousRiseSub(String s) {
        // DP[i] 代表包括 s[i] 的最长连续上升序列
        int n = s.length();
        int[] DP = new int[n + 1];

        Arrays.fill(DP, 1);

        int end_idx = 0;
        int ans = 1;

        for (int i = 2; i <= n; i ++) {
            if (s.charAt(i - 1) > s.charAt(i - 2)) {
                DP[i] = DP[i-1] + 1;
                if (DP[i] > ans) {
                    ans = DP[i];
                    end_idx = i - 1;
                }
            }
        }

        System.out.println(s.substring(end_idx - ans + 1, end_idx + 1));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getLongestContinuousRiseSub("bgcde"));
    }
}
