package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 *
 *
 * 基本方法，将strs转化为一个map，保存每个字符串的次数，然后遍历 len - m 次，每次取出 n 个字符串组成临时map，
 * 判断是不是和目的map相等，是则说明该起始下标是一个满足条件的下标。
 *
 * 时间复杂度O（(len - m) * n）
 */
public class Solution {
    List<Integer> ret;
    int m;
    int n;
    public List<Integer> findSubstring(String s, String[] strs) {
        ret = new ArrayList<>();
        if (strs == null || strs.length == 0) return ret;
        int len = s.length();
        n = strs[0].length();
        m = strs.length * n;

        Map<String, Integer> map = new HashMap<>();
        for (String cur_s : strs) {
            map.put(cur_s, map.getOrDefault(cur_s, 0) + 1);
        }
        for (int i = 0; i < len - m + 1; i ++) {
            check(s, i, map);
        }
        return ret;
    }

    private void check(String s, int i, Map<String, Integer> map) {
        Map<String, Integer> tmpMap = new HashMap<>();
        for (int j = i; j < i + m; j += n) {
            String str = s.substring(j, j + n);
            tmpMap.put(str, tmpMap.getOrDefault(str, 0) + 1);
        }
        if (map.equals(tmpMap)) ret.add(i);
    }
}
