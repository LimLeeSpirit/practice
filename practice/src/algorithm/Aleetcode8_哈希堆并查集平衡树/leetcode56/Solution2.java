package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间，在我做完堆的题后，掌握了比较器的使用，这个其实是相对简单的，但是为什么会报错？，自己的编译器可以通过
 *
 * 把它放在这的原因仅仅是因为它和352题划分区间，都是区间相关的题。
 */
public class Solution2 {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        List<int[]> list = new ArrayList<>();
        for (int[] a : intervals) list.add(a);

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                Integer l1 = a[0];
                Integer l2 = b[0];
                Integer r1 = a[1];
                Integer r2 = b[1];
                return l1.equals(l2) ? r1.compareTo(r2) : l1.compareTo(l2);
            }
        });

        List<int[]> mergeArr = new ArrayList<>();
        int[] cur = list.get(0);
        int i = 1;
        boolean merFlag = false;
        while (i < n) {
            while (i < n && list.get(i)[0] <= cur[1] && cur[1] <= list.get(i)[1]) {
                cur[1] = list.get(i)[1];
                i ++;
            }
            if (i == n) { merFlag = true; }

            mergeArr.add(cur);
            if (i < n) cur = list.get(i ++);

        }

        // 一个点，后面可以合并的时候，还会把 cur 加一遍；如果不加上，在后面不合并的时候，最后一个区间就会被丢掉
        if (!merFlag) {
            mergeArr.add(cur);
        }

        int[][] ret = new int[mergeArr.size()][2];
        for (int j = 0; j < mergeArr.size(); j ++) {
            ret[j] = mergeArr.get(j);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] a = {{1,3}, {4,6}, {5, 9}, {10, 11}};
        merge(a);
        for (int[] b : merge(a)) {
            System.out.printf("%s, %s",b[0], b[1]);
            System.out.println();
        }
    }
}
