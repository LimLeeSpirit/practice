package algorithm.Aleetcode1_二分.leetcode74;

import java.util.Arrays;

/**
 * 二维数组搜索I
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *      每行中的整数从左到右按升序排列
 *      每行的第一个整数 大于 前一行的最后一个整数。
 *
 * 其实就是一维有序数组分割成了二维的情况
 */
public class Solution {
    /**
     * 使用模版2，找出小于等于 target 的最大数，满足规则的最后一个数
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n -1 ;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[mid / n][mid % n] <= target) l = mid;
            else r = mid - 1;
        }
        // 最后r处在小于等于目标的最大数处，若他不等于目标，则不会找到了，返回false；
        return matrix[r / n][r % n] == target;
    }

    /**
     *  *  既然是有序的，那么直接定位到target所在的行，然后对行进行二分搜索，就可以判断是否存在了
     *  *  时间复杂度，只用到一个子数组的二分查找lg(n)，超过100%
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix ==null || matrix.length==0 || matrix[0].length==0) { return false; }
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] <= target && target <=matrix[i][matrix[0].length-1]) {
                int find = Arrays.binarySearch(matrix[i], target);
                return find > -1;
            }
        }
        return false;
    }
}
