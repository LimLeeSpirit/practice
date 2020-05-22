package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。且同时保留字符的顺序
 *
 * 其实就是考的映射和集合，用映射保持对应关系，用集合保持加入顺序。
 */
public class Solution {
    // 其实考的是映射，一个字符与一个字符对应，需要开两个hash表，从而判断
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hash = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<>();
        int m = s.length();
        for (int i = 0; i < m; i ++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hash.containsKey(c1)) {
                if (hash.get(c1) != c2) return false;
            } else {
                if (set.contains(c2)) return false;
                else {
                    set.add(c2);
                    hash.put(c1, c2);
                }
            }
        }
        return true;
    }
}
