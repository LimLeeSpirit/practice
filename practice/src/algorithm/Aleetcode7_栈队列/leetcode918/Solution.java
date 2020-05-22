package algorithm.Aleetcode7_栈队列.leetcode918;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大子序和。
 *
 *  对于长度为 n 的环形的数组，一般将其组成长度为 2 * n 的非环数组，
 *  比如环形数组 2 -3 -2 3，组成单链就是nums： 2 -3 -2 3 2 -3 -2 3
 *
 *  所以问题就变成了在 nums 中找到长度在 [1, n] 之间的最大子序和
 *
 *  首先求出 nums 的前缀和；
 *  维护一个 单调增队列，对处于 i 位置的前缀和，求在他前面的最小前缀和 j，要求下标满足： i - j <= n
 *
 *  然后 ret = sums[i] - min(sums[j])
 *
 *  所以这道题就转化为了给定前缀和数组 nums，求长度为 n 的窗口中的最小值问题了。
 *
 *  这个转化能力是在不一般，
 *
 */
public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int ret = Integer.MIN_VALUE;

        int[] nums = new int[2 * n];
        System.arraycopy(A, 0, nums, 0, n);
        System.arraycopy(A, 0, nums, n, n);


        int[] sums = new int[2 * n + 1];
        for (int i = 1; i < 2 * n + 1; i ++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);

        for (int i = 1; i < 2 * n + 1; i ++) {
            // 如果左端点下标不满足下标要求，抛出
            if (!q.isEmpty() && i - n > q.peekFirst()) q.pollFirst();

            // 更新结果，最左端就是
            if (!q.isEmpty()) ret = Math.max(ret, sums[i] - sums[q.peekFirst()]);

            //
            while (!q.isEmpty() && sums[q.peekLast()] >= sums[i]) q.pollLast();
            q.offerLast(i);
        }

        return ret;
    }
}
