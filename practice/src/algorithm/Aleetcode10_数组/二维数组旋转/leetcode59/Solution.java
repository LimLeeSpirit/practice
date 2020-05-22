package algorithm.Aleetcode10_数组.二维数组旋转.leetcode59;

/**
 * 螺旋矩阵II。
 * 给定整数n，要求生成 nxn 的矩阵，且矩阵元素顺时针螺旋排列为：1-n^2
 *
 * 哈哈哈和 leetcode 54 螺旋矩阵相同的解法而已。学到了！
 */
public class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int x1 = 0;
        int x2 = n - 1;
        int y1 = 0;
        int y2 = n - 1;
        int k = 1;

        while (x1 <= x2 && y1 <= y2) {
            // 上行
            for(int i = x1; i <= x2; i++) {
                ret[x1][i] = k ++;
            }

            // 右列
            for(int i = x1 + 1; i <= x2; i ++) {
                ret[i][y2] = k ++;
            }

            if (x1 <= x2 && y1 <= y2) {
                for (int i = y2 - 1; i >= y1; i --) {
                    ret[x2][i] = k ++;
                }
                for (int i = x2 - 1; i > x1; i --) {
                    ret[i][y1] = k ++;
                }
            }
            x1 ++;
            x2 --;
            y1 ++;
            y2 --;
        }
        return ret;
    }
}
