package algorithm.Aleetcode9_动态规划.leetcode120;

import java.util.List;

/**
 *  这个用的方法牛逼了，只用一维数组保存，DP[m]:m行到最底行的最短路径。
 *  原因是三角形每一行的个数都与所在行数相等，
 *  2
 *  3 4
 *  6 5 7
 *  4 1 8 3
 *  所以可以直接用一纬保存。每一次内层遍历，都是在横着的，那样看起来比较方便。
 */
public class Solution2 {
    // 3ms
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] mini = new int[triangle.get(m - 1).size()];

        for (int i = 0; i < triangle.get(m - 1).size(); i ++) {
            mini[i] = triangle.get(m - 1).get(i);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (mini[j] > mini[j + 1]) {
                    mini[j] = triangle.get(i).get(j) + mini[j + 1];
                } else {
                    mini[j] = triangle.get(i).get(j) + mini[j];
                }
            }
        }
        return mini[0];
    }
}
