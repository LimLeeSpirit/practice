package algorithm.Aleetcode10_数组.JZoffer86_leetcode238;

/**
 * 除自身以外数组的乘积
 *
 * 给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，
 * 其中B中的元素B[i]=A[0]×A[1]×… ×A[i-1] × A[i+1]×…×A[n-1]。
 *
 * 不能使用除法。
 *
 * 输入：[1, 2, 3, 4, 5]
 *
 * 输出：[120, 60, 40, 30, 24]
 *
 * 如果不能用除法，那么就可以用乘法对吧，将B[i]分成两部分来求，前面一部分和后面一部分。然后两部分相乘就可以了
 */
public class Solution {
    public int[] multiply(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0, p = 1; i < n; i ++) {
            ans[i] = p;
            p *= nums[i];
        }

        for (int i = n - 1, p = 1; i >= 0; i --) {
            ans[i] *= p;
            p *= nums[i];
        }
        return ans;
    }
}
