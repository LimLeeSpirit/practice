package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode706;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * 完美的实现了简单的hashMap，使用到了jdk中的实现方式，所以效率高的不行，减少了 hash 碰撞
 * 1、size为槽的个数，设计为2 的次方：8192 = 1024 * 8 = 2 ^ 14,因为所有的值都在 [1, 100 0000]的范围内。
 * 2、针对 key 找槽的时候使用了 JDK 中的方法，实现方式为hashcode，前后 16 位进行异或操作。再对 8192 取模
 * 3、在put的时候，如果有旧值，应该返回旧值
 * 4、在get的时候，如果key不存在，应该返回 null；
 * 5、使用好MapEntry！ 我们存入的是键值对实体
 *
 * 6、为解决hash碰撞，一般有链地址法、开放寻址法；找到槽，发现不空的时候，将键值对放入链表表头，JDK8之后在链长度大于8的时候就会扩展成红黑树，开放寻址法是如果发现此槽已经有值了，
 * 则继续看下一个槽，直到找到空的槽为止。
 */
public class MyHashMap {
    LinkedList<MapEntry<Integer, Integer>>[] buckets;
    int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 8192;
        buckets = new LinkedList[size];
    }

    /** value will always be non-negative.
     *  put 操作的精髓：先找到下标，再在这个槽的链表后面找到key，如果出现过，则替换；否则直接加在这个链表头部。
     * */
    public void put(int key, int value) {
        Integer k = (Integer)key;

        int code = k.hashCode();
        code ^= (code >>> 16);
        code %= 8192;
        if (buckets[code] == null) {
            buckets[code] = new LinkedList<>();
        }
        int oldValue = 0;
        boolean find = false;

        MapEntry<Integer, Integer> entry1 = new MapEntry<>(key, value);

        LinkedList<MapEntry<Integer, Integer>> bucket = buckets[code];
        ListIterator<MapEntry<Integer, Integer>> it = bucket.listIterator();

        while (it.hasNext()) {
            MapEntry<Integer, Integer> entry = it.next();
            if (entry.getKey() == key) {
                oldValue = entry.getValue();
                it.set(entry1);
                find = true;
                break;
            }
        }

        if (!find) {
            bucket.add(entry1);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Integer k = (Integer)key;

        int code = k.hashCode();
        code ^= (code >>> 16);
        code %= 8192;
        if (buckets[code] == null) return -1;

        for (MapEntry<Integer, Integer> entry : buckets[code]) {
            if (entry.key == key) {
                return entry.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Integer k = (Integer)key;

        int code = k.hashCode();
        code ^= (code >>> 16);
        code %= 8192;

        if (buckets[code] == null) throw new IllegalArgumentException("没有此key");
        ListIterator<MapEntry<Integer, Integer>> it = buckets[code].listIterator();
        while (it.hasNext()) {
            MapEntry<Integer, Integer> entry = it.next();
            if (entry.getKey() == key) {
                it.remove();
                break;
            }
        }
    }
}

class MapEntry<K, V> implements Map.Entry<K, V>{
    K key;
    V value;

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return null;
    }

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}