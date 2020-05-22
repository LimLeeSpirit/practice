package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode347堆或者Map排序;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 和 692 题对字符串统计出现次数前k大的思路一样，这个题和692结合起来写个博客
 * 可以用  hash + 对Map进行Key排序 或者 hash映射+堆排序
 */
public class Solution {

    /**
     * hash + 对Map进行Key排序  20ms
     * @param nums int数组
     * @param k    频率前k大
     * @return     k个元素
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int a : nums) {
            hash.put(a, hash.getOrDefault(a, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hash.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> ret = new ArrayList<>();
        ListIterator<Map.Entry<Integer, Integer>> it = list.listIterator();
        while (it.hasNext() && k > 0) {
            Map.Entry<Integer, Integer> entry = it.next();
            ret.add(entry.getKey());
            k --;
        }
        return ret;
    }

    /**
     * hash 映射 + 堆排序   19ms
     *
     * 求最大数，用小根堆，求最小数，用大根堆
     *
     * Java中默认的是 小顶堆，入堆元素是 key，但是比较的是对应的 value，所以还是要传入比较器并实现Comparator
     * 如果要用大根堆，存相反数就好了
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();

        // key：nums元素，value：key出现的次数
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // 求前k大，用小顶堆，只不过比较的是key出现的次数
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 升序
                return map.get(a) - map.get(b);
            }
        });

        for (int key : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(key);
            } else if (map.get(key) > map.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.offer(key);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
