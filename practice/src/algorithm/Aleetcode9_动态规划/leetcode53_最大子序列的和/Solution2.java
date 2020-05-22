package algorithm.Aleetcode9_动态规划.leetcode53_最大子序列的和;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大子序和
 *
 * 输出数组最大连续子序列的和
 *
 * 跟着Y神，我自己都写出了这个题的单调队列的写法，也是O（n + n）复杂度
 *
 * 前缀和 + 单调队列！完美！单调队列和前缀和这种方法确实是最合适的。
 * 结合918题，环形数组的解决方式
 *
 * 不要用DP，DP很难思考，这种线性最优解确实可以用 DP。
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 保存前缀和
        int[] sums = new int[n + 1];
        // 前0个元素的和为0
        sums[0] = 0;
        for (int i = 1; i < n + 1; i ++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        Deque<Integer> q = new ArrayDeque<Integer>();
        int ret = Integer.MIN_VALUE;
        q.offer(0);

        // 针对每一个sum[i]，在前面找到最小的sum[j]与之对应，中间的差值就是一个最大和
        for (int i = 1; i < n + 1; i ++) {
            if (!q.isEmpty()) ret = Math.max(ret, sums[i] - sums[q.peekFirst()]);

            while (!q.isEmpty() && sums[q.peekLast()] >= sums[i]) q.pollLast();

            q.offerLast(i);
        }

        return ret;
    }
}
