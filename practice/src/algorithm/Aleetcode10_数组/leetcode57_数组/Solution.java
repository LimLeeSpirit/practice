package algorithm.Aleetcode10_数组.leetcode57_数组;

import java.util.ArrayList;
import java.util.List;

/**
 *  插入区间，合并区间的升级版
 *  为什么我在插入的时候感觉会分很多情况，别人在做得时候思路就能如此清晰，他可以把复杂的情况综合起来，将很多种情况
 *  放在一起处理。
 *
 *
 *  注意一个知识点：
 *  List<int[]> res = new ArrayList<>();
 *  要将res 转化为二维数组：
 *  1、res.toArray(int[] a)   // res.toArray(new int[res.size()][2])
 *
 *  2、int[][] ret = new int[res.size()][2];
 *     然后循环遍历res，ret[j] = new int[]{res.get(j)[0], res.get(j)[1]};
 *
 *  其实第二种写法就是第一种的具体实现
 */
public class Solution {
    public static int[][] insert(int[][] nums, int[] tar) {
        // 这个题一开始要分析会有出现多少种情况，然后将 newInterval 放在区间们之间，分前、中、后三个阶段进行处理！
        List<int[]> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n && nums[i][1] < tar[0]) {
            res.add(nums[i]);
            i ++;
        }

        int[] tmp = new int[]{tar[0], tar[1]};
        while (i < n && nums[i][0] <= tar[1]) {
            tmp[0] = Math.min(nums[i][0], tmp[0]);
            tmp[1] = Math.max(nums[i][1], tmp[1]);
            i ++;
        }
        res.add(tmp);

        while (i < n) res.add(nums[i ++]);

        int[][] ret = new int[res.size()][2];
        for (int j = 0; j < res.size(); j ++) ret[j] = res.get(j);

        return ret;
    }
}
