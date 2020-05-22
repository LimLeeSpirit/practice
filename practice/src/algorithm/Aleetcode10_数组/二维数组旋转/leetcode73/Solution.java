package algorithm.Aleetcode10_数组.二维数组旋转.leetcode73;

import java.util.ArrayList;
import java.util.List;

/**
 *  矩阵置0：给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。
 *  [[0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]]
 *
 *   [[0,0,0,0],
 *    [0,4,5,0],
 *    [0,3,1,0]]
 *    即只把有0的行和列的元素置0，那么把有0的行和列分别找出来不就行了嘛，放在两个 set 里，然后分别对行和列进行置0
 *
 *
 *   注意一点，是把该行所以值，该列所有值都设置为0，而不只是上下左右！！！
 */
public class Solution {
    int[] dx = {-1, 1 , 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m;
    int n;
    public void setZeroes(int[][] nums) {
        List<int[]> xy = new ArrayList<>();
        m = nums.length; n = nums[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (nums[i][j] == 0) xy.add(new int[]{i, j});
            }
        }
        for (int[] cur : xy) {
            helper(nums, cur[0], cur[1]);
        }
    }

    private void helper(int[][] nums, int x, int y) {
        for (int i = 0; i < n; i ++) nums[x][i] = 0;

        for (int j = 0; j < m; j ++) nums[j][y] = 0;
    }
}
