package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *  合并区间
 *  之前想了好久都没AC，最开始是按照区间的左覆盖、右覆盖来做的，始终不行；
 *  后来又将区间映射到坐标轴，由于无法区分两个不覆盖的区间（不覆盖包括：中间有间隔、中间午间隔的相邻状态），所以又失败了。
 *
 *  标准答案是：先将 intervals 按照第一列排序。关键也就是这一点了，怎么重写Comparator
 *            然后利用一次遍历对区间进行判断
 *
 *  注意：List<int[]> list = new ArrayList<>();
 *      list.add(new int[]{2,3});
 *      的这种写法。
 */
public class Solution {
    public static int[][] merge( int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[0][0];
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        // 这里为什么能够能够一次遍历就可以，就是因为排序后，对于当前区间，考虑他的下一个区间。
        // 如果下一个区间右覆盖当前区间，则更新当前区间的左右坐标，继续下去。否则，说明当前区间没有与其他的区间有覆盖了！！！
        for(int i = 1; i < intervals.length; i ++) {
            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        //这是最后一个区间，无区间跟他有覆盖了
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);

//        int[][] result = new int[list.size()][2];
//        for(int i = 0; i < list.size(); i++) {
//            result[i] = new int[] {list.get(i)[0], list.get(i)[1]};
//        }
//
//        return result;
    }
}
