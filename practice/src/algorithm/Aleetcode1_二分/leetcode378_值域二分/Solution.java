package algorithm.Aleetcode1_二分.leetcode378_值域二分;

import java.util.Arrays;

/**
 *  给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 *  请注意，它是排序后的第 k 小元素，而不是第 k 个元素。
 *  matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 *    ],    k = 8,  返回 13
 *
 *  这个就是值域的二分查找，之前接触过的都是索引的二分查找。值域的二分是指给定值域区间[l, r]，在其中找出第k小的数
 *  那么就是要找一个值，有 k 个值小于等于它就行了。
 */
public class Solution {
    public int kthSmallest2(int[][] nums, int k) {
        int m = nums.length, n = nums[0].length;
        int l = nums[0][0], r = nums[m - 1][n - 1];
        while (l < r) {
            int mid = l + r >> 1;
            int ret = l;
            int cnt = 0;
            for (int i = 0, j = n - 1; i < m; i ++) {
                // 遍历矩阵每一行，找比 mid 小的个数， 加起来为 count； 从每行的最后一个元素开始比较
                while (j >= 0 && nums[i][j] > mid) j --;
                if (j >= 0) {
                    cnt += j + 1;
                    // ret 用来记录返回值，在count = k的时候，这个值就刚好是第k小的值
                    ret = Math.max(ret, nums[i][j]);
                }
            }
            // if (cnt == k) return ret;
            // else if (cnt < k) l = mid + 1;
            // else if (cnt > k) r = mid;
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[] nums = new int[m * n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j<n; j++) {
                nums[i*n + j] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k-1];
    }
}
