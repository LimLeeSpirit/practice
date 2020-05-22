package algorithm.Aleetcode1_二分.leetcode240;

/**
 * 二维数组搜索II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 这个题其实是用的二分的思想，只不过题目条件更强，右上角的元素就是 mid 值；
 * 所以直接从右上角往左下搜索就行了
 */
public class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int m = nums.length;
        int n = nums[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (nums[i][j] == target) return true;
            else if (nums[i][j] > target) j --;
            else i ++;
        }
        return false;
    }
}
