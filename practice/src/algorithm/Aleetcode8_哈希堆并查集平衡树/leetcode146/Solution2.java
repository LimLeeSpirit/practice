package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 利用双向链表 + hashmap 来存
 * 双向链表存储：存储key，删除和插入是O（1）复杂度，查找是O（n）的复杂度
 * hashmap：存储真正的value，形成key-value键值对，目的是利用好查找是O（1）的复杂度。
 * 这样利用双向链表 和 hashmap 就可以实现的O（1）的查找、删除、插入的复杂度了。
 * 上一个方式是利用 LinkedHashMap 实现的，其实 LinkedHashMap 就是用 双向链表和 hashmap 实现的
 */
class Solution2 {
    private LinkedList<Integer> linkedList;
    private Map<Integer, Integer> map;

    private int max_size;
    private int cur_size = 0;

    public Solution2(int capacity) {
        linkedList = new LinkedList<>();
        map = new HashMap<>();
        this.max_size = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        int val = map.get(key);
        // 链表删除指定节点，为什么会被当成删除第key个节点。所以我只能转为Object类型了
        Object o = key;
        linkedList.remove(o);
        linkedList.addLast(key);

        return val;
    }

    /**
     * 必须先判断是否存在，如果存在，则删除，添加新的；
     * 不存在，则添加，然后判断添加后的缓存是否超过了容量；若超出，则删除最远元素
     */
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // 这个put不能省略，即使 key 存在，若新添加的value更新了，那刚好就将value更新，如果省略，则value更新不了
            map.put(key, value);
            Object o = key;
            linkedList.remove(o);
            linkedList.addLast(key);
        }else{
            map.put(key, value);
            cur_size ++;
            linkedList.addLast(key);

            // listSet.add(key);
            if(cur_size > max_size){
                // 在满了的时候，必须删除最远的那个，对于 hashmap 来讲，他不知道哪个最远，所以需要一个有序的链表来记录
                int tmp = linkedList.removeFirst();
                map.remove(tmp);
                cur_size --;
            }
        }
    }
}

