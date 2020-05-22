package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode146;

import java.util.LinkedHashMap;

/**
 * 实现一个 LRU 缓存机制。
 * 利用 LinkedHashMap 的实现
 * 判重、插入、删除都是O（1）的复杂度。
 *
 * 通俗易懂，复习超快！
 */
class Solution {
    private LinkedHashMap<Integer, Integer> map;
    private int max_size;
    private int cur_size;

    public Solution(int capacity) {
        map = new LinkedHashMap<Integer, Integer>();
        this.max_size = capacity;
        this.cur_size = 0;
    }

    public int get(int key) {
        // 若没有，则返回 -1， 这个有的LRU实现机制不一样，这里 get 的实现会各不相同，大有文章。
        if(!map.containsKey(key)){
            return -1;
        }

        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
        }else{
            cur_size ++;
            map.put(key, value);
            if(cur_size > max_size){
                int oldestKey = map.keySet().iterator().next(); // 获取最远的key。
                map.remove(oldestKey);
                cur_size --;
            }
        }
    }
}