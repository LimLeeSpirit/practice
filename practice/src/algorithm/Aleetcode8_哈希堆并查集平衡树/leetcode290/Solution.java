package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 和那个 映射+集合 是一个题
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> hash = new HashMap<Character, String>();
        Set<String> set = new HashSet<>();
        String[] words = str.split(" ");
        int n = pattern.length(), m = words.length;

        if (m != n) return false;

        for (int i = 0; i < m; i ++) {
            char c = pattern.charAt(i);
            String s = words[i];
            if (hash.containsKey(c)) {
                if (!hash.get(c).equals(s)) return false;
            } else {
                if (set.contains(s)) return false;
                else {
                    set.add(s);
                    hash.put(c, s);
                }
            }
        }
        return true;
    }
}
