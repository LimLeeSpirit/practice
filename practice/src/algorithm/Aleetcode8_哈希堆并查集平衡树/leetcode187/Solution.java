package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定字符串，求出在整个字符串中出现过一次以上的 且 长度为 10 的字符串
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * 他题目的描述有点问题，直接这样叙述就清晰多了，明显的hash映射。简单
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i <= s.length() - 10; i ++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2) ret.add(sub);
        }
        return ret;
    }
}
