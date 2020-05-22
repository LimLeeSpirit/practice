package algorithm.Aleetcode6_双指针和滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定字符串a1a2a34....an-1,求串中字典序最大的子序列。
 * 先找到字符串中的最大字符 ai，
 * 再在ai+1 ai+2....an-1之间找到最大的字符aj;
 * 再在aj+1 aj+2 aj+3......an-1中找到最大的字符 ak;重复这个操作，直到字符串为空
 *
 * 比如 acbdxmng  依次找到 x，n， g，则最大字典序子串为 xng
 *
 * 根据题目描述，其实就可以写出算法了。简单的递归也可以，简单的双指针也可以
 */
public class LongestSubInDictOrder {
    public static String getLongestSubInDictOrder(String s) {
        if (s==null) throw new IllegalArgumentException("参数错误");

        // 用来保存找到的字符
        char[] chars = new char[s.length() + 1];
        // 计数下标
        int charsIndex = 0;

        for (int i = 0; i < s.length(); i ++) {
            chars[charsIndex] = s.charAt(i);
            // 在后面找出比当前大的字符
            for (int j = i + 1; j < s.length(); j ++) {
                if (s.charAt(j) > chars[charsIndex]) {
                    chars[charsIndex] = s.charAt(j);
                    // 更新查找的 i
                    i = j;
                }
            }
            charsIndex ++;
        }
        return new String(chars).substring(0, charsIndex);
    }

    public static void getLongestSubInDictOrder2(String s) {
        List<Character> ans = new ArrayList<>();
        dfs(s, 0, ans);
        for (Character c : ans) System.out.print(c + " ");
    }

    public static void dfs(String s, int idx, List<Character> ans) {
        if (idx >= s.length()) return;
        char tmp = s.charAt(idx);

        int next = idx;
        for (int i = idx + 1; i < s.length(); i ++) {
            if (s.charAt(i) > tmp) {
                tmp = s.charAt(i);
                next = i;
            }
        }
        ans.add(tmp);

        dfs(s, next + 1, ans);
    }

    public static void main(String[] args) {
        getLongestSubInDictOrder2("abcjhid");
        // System.out.println(getLongestSubInDictOrder2("abcjhid"));
    }
}
