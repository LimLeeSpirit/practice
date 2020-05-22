package algorithm.Aleetcode10_数组.二维数组旋转.leetcode48_数组;

/**
 * 旋转矩阵，将矩阵顺时针旋转90度。
 *
 * 这种题，记一下套路：
 * 顺时针旋转矩阵90度：先根据左上-右下对角线对折，再根据竖着的中轴线左右对折；
 *
 * 逆时针旋转矩阵90度：先根据竖着的中轴线左右对折，再根据左上-右下对角线对折。所以就是和上一个反着来的
 */
public class Solution {
    public void rotate(int[][] nums) {
        int m = nums.length;
        for (int i = 0; i < m ; i ++) {
            for (int j = i + 1; j < m; j ++) {
                int tmp = nums[j][i];
                nums[j][i] = nums[i][j];
                nums[i][j] = tmp;
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < m / 2; j ++) {
                int tmp = nums[i][m - 1 - j];
                nums[i][m - 1 - j] = nums[i][j];
                nums[i][j] = tmp;
            }
        }
    }
}
