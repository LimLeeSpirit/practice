package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode692堆或者Map排序;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。
 *
 * 如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 这个题和 347 一样，只不过这里多了对出现次数相同的字符串进行字典序排序
 * 这不就是根据 value 对 hash 进行排序嘛，哈哈
 * 实际做法是将 entry 放在 list 里，然后调用 Collections.sort(list, new Comparator(){}) 的方法来进行排序的
 *
 */
public class Solution {
    /**
     * hash + 对Map排序 11ms，时间复杂度是O（mlgm）,m 代表 m 种不同的字符串
     * @param s
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] s, int k) {
        Map<String, Integer> hash = new TreeMap<>();

        for (String str : s) {
            hash.put(str, hash.getOrDefault(str, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hash.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                // list 会降序
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        ListIterator<Map.Entry<String, Integer>> it = list.listIterator();
        List<String> ret = new ArrayList<>();
        while (it.hasNext() && k > 0) {
            Map.Entry<String, Integer> entry = it.next();
            ret.add(entry.getKey());
            k --;
        }
        return ret;
    }

    /**
     * hash + 堆 + 比较器的应用 9 ms，总体复杂度达到了O（nlgk），n 为字符串个数，k 为堆的大小。
     * @param s strings
     * @param k 个数
     * @return  strings
     */
    public List<String> topKFrequent2(String[] s, int k) {
        final Map<String, Integer> hash = new HashMap<>();

        for (String str : s) {
            hash.put(str, hash.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<String> h = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hash.get(o1).equals(hash.get(o2)) ?
                        // 按照key降序       按照value升序
                        // o2.compareTo(o1) : hash.get(o1).compareTo(hash.get(o2));
                        o2.compareTo(o1) : (hash.get(o1) - hash.get(o2));
            }
        });

        // 将key存放进去，存放的规则是 先按照key出现的次数进行升序，如果遇到次数相同的，按照key字典序降序
        for (String key : hash.keySet()) {
            h.offer(key);
            if (h.size() > k) h.poll();
        }

        // 保存结果，最后还需要反转一下，这样实现的就是按照次数进行降序排序，次数一样的话，按照字典序升序
        List<String> ret = new ArrayList<>();
        while (!h.isEmpty()) ret.add(h.poll());

        Collections.reverse(ret);
        return ret;
    }
}
