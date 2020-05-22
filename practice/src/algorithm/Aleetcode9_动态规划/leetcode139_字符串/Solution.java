package algorithm.Aleetcode9_动态规划.leetcode139_字符串;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 */
public class Solution {
    public boolean wordBreak(String s, List<String> dic) {
        /**
         * 这道题居然也可以用DP，wordDict里的单词可以重复用，所以直接放在set里，判断子序列是否在set里是最好的，这点应该想到的。
         * 不过那个DP方程是真的难以想到。
         *
         * 第三次遇见依然无法想到,如果用dfs的话难度太多，果然只能是用DP
         */
        Set<String> hash = new HashSet<>(dic);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (hash.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
