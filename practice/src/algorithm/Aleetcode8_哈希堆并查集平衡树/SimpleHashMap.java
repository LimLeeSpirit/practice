package algorithm.Aleetcode8_哈希堆并查集平衡树;

import java.util.*;

/**
 * 实现简单的HashMap，包括put和get操作
 */


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

public class SimpleHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    static final int SIZE = 16;

    static float loadFactor = 0.75f;

    static int threshold = 12;

    static int capacity = 0;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    /**
     * put 操作的精髓：先找到下标，再在这个槽的链表后面找到key，如果出现过，则替换；否则直接加在这个链表头部。
     * @param key
     * @param value
     * @return 如果曾经存在，则返回旧值；否则返回 null；
     */
    public V put(K key, V value) {
        int h, index;
        if (key == null ) index = 0;
        else {
            h = key.hashCode()^(key.hashCode()>>>16);
            index = h & (SIZE - 1);
        }

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();

        MapEntry<K, V> pair = new MapEntry<>(key, value);

        V oldValue = null;
        boolean find = false;

        while (it.hasNext()) {
            Entry<K, V> tmp = it.next();
            if (tmp.getKey().equals(key)) {
                oldValue = tmp.getValue();
                it.set(pair);
                find = true;
                break;
            }
        }

        if (!find) {
            buckets[index].addFirst(pair);
            capacity ++;
            if (capacity >= threshold) {
                //resize;
            }
        }
        return oldValue;
    }

    public V get(Object key) {
        int h = key.hashCode();
        h = h^(h>>>16);
        int index = h & (SIZE - 1);
        if (buckets[index] == null) {
            return null;
        }
        for (Entry<K,V> pair : buckets[index]) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    set.add(entry);
                }
            }
        }
        return set;
    }
}
