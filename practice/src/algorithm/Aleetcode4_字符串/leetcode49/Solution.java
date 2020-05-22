package algorithm.Aleetcode4_字符串.leetcode49;

import java.util.*;

/**
 * 字母异位词分组
 *
 * 哈哈第二次自己就做出来了
 */
public class Solution {
    public static List<List<String>> groupAnagrams2(String[] strs) {
        /*
         * 排序nlgn,以及外层循环，不也都n^2lgn嘛。。
         *
         * 没有想到还有这种操作，将可以唯一确定一个字符串的排序字符当做健，与他异构的字符串当作值，存储起来.
         *
         * Hash映射啊！！！！！！！
         */
        if (strs==null || strs.length==0) { return new ArrayList<List<String>>(); }
        Map<String, List<String>> res = new HashMap<>();
        for ( String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String curKey = String.valueOf(temp);
            //String curKey = new String(temp);
            // 这个键不在，添加，并把s，以及空的值（ArrayList）添加进去
            if (! res.containsKey(curKey)) { res.put(curKey, new ArrayList<String>()); }
            res.get(curKey).add(s);
        }
        return new ArrayList<>(res.values());
    }

    /**
     * 考点有二：一是找到同分异构字符串的本质，二是如何快速得将同分异构的字符串放在一起
     * 所以就是排序 + 哈希 的思想
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strSort = new String(chars);

            if (!map.containsKey(strSort)) {
                map.put(strSort, new ArrayList<String>());
            }
            map.get(strSort).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
