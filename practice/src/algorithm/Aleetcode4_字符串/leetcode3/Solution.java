package algorithm.Aleetcode4_字符串.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不重复子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 1：哈希集或者哈希表，难点在于如何将 [i, j]区间更新为不含重复元素，或者[j, i]区间不含邮重复元素
 *
 * 2：是优化后的双指针 + 哈希表
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 基础写法，双指针，time O（n^2）；没有优化
         */
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j ++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i ++));
            }
        }
        return ans;
    }

    /**
     * 在[i, j]区间维护一个hash表，j 往后走，i 每次从 0 开始，往后走到[i, j] 之间没有重复元素为止
     * @param s str
     * @return 最长不重复子串长度
     *
     * 第四次自己写的时候，一目了然，其实是双指针算法 + 优化，每个元素被访问两遍，所以 time：O（n）
     */
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        while (i < n && j < n) {
            map.put(chars[j], map.getOrDefault(chars[j], 0) + 1);
            while (map.get(chars[j]) > 1) {
                // 这个步骤很重要，比如 a, b, c, d, b 此时 j = 4，i = 0。 要把 i = 0，1  的元素
                // 滤去。
                int k = map.get(chars[i]);
                k --;
                map.put(chars[i], k);
                i ++;
            }
            j ++;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
        Object obj = new Object();
    }
}