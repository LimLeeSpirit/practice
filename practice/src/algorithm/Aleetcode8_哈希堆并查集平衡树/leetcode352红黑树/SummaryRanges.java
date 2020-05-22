package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode352红黑树;

import java.util.Map;
import java.util.TreeMap;

/**
 * 动态将数据流变为多个不相交区间：包含区间合并的更新
 *
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 *
 * 数据流为 1 ：   [1, 1]
 * 数据流为 1，3 ： [1, 1], [3, 3]
 * 数据流为 1， 3， 7： [1, 1], [3, 3], [7, 7]
 * 数据流为 1， 3， 7， 2 ：[1, 3], [7, 7]
 * 数据流为 1， 3， 7， 2， 6 ： [1, 3], [6, 7]
 *
 * 解决思路是利用平衡树，分别保存 x 的左端点（此时 x 是右端点）和右端点（此时 x 是左端点）
 * 利用 Java 中的TreeMap，内部实现是红黑树，按照 key 顺序有序
 *
 * 学习平衡树的两个终于操作：
 * L.ceilingEntry(val) 返回 L 树中 key 大于等于 val 的最小实体，所以是 val 的上一层天花板
 * L.floorEntry(val)   返回 L 树中 key 小于等于 val 的最大实体，所以是 val 的下一层地板
 */
public class SummaryRanges {
    TreeMap<Integer, Integer> L;
    TreeMap<Integer, Integer> R;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        L = new TreeMap<>();
        R = new TreeMap<>();
    }

    public void addNum(int val) {
        // 如果 val 已经在某个区间了
        if (L.size() > 0) {
            Map.Entry<Integer, Integer> a = L.ceilingEntry(val);
            // a.getKey() 是右端点, a.getKey()已经大于等于val， a.getValue()是左端点
            if (a != null && a.getValue() <= val) {
                // System.out.printf("key:%d, value:%d",a.getKey(), a.getValue());
                //  System.out.printf("输入%s的时候break了",val);
                // System.out.println();
                return;
            }
        }

        if (L.get(val - 1) != null && R.get(val + 1) != null) {
            int left = L.get(val - 1);
            int right = R.get(val + 1);
            // val - 1的左端点的右端点是 val + 1的右端点
            // val + 1的右端点的左端点是 val - 1的左端点
            R.put(L.get(val - 1), R.get(val + 1));
            L.put(R.get(val + 1), L.get(val -1));
            L.remove(val - 1);
            R.remove(val + 1);

        } else if (L.get(val - 1) != null) {
            // val - 1 的左端点的右端点是 val
            // val 的左端点是 val - 1 的左端点
            R.put(L.get(val - 1), val);
            L.put(val, L.get(val - 1));
            L.remove(val - 1);

        } else if (R.get(val + 1) != null) {
            // val + 1的右端点的左端点是 val
            // val 的右端点是 val + 1的右端点
            L.put(R.get(val + 1), val);
            R.put(val, R.get(val + 1));
            R.remove(val + 1);

        } else {
            L.put(val, val);
            R.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int[][] ret = new int[R.size()][2];
        int i = 0;
        for (int l : R.keySet()) {
            ret[i][0] = l;
            ret[i][1] = R.get(l);
            i ++;
        }
        return ret;
    }
}