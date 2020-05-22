package algorithm.Aleetcode9_动态规划.leetcode70;

import java.util.Arrays;

/**
 *  爬楼梯，简单的 DP
 */
public class Solution {
    public int climbStairs(int n) {
        // 其实可以只设置n个元素，但是这里设置n+1个，可以巧妙得简化代码。
        // 因为如果设置n个，那么初始变量：最后一个阶梯是 1， 倒数第二个是 2， 然后从倒数第三个开始计算
        // 如果设置了 n+1个，下标n和 n-1 都是 1， 从 n-2 开始计算，更方便。
        int[] DP = new int[n+1];
        Arrays.fill(DP, 1);
        for (int i = n - 2; i >= 0; i --) {
            DP[i] = DP[i+1] + DP[i+2];
        }
        return DP[0];
    }

    public int climbStairs2(int n) {
        // 斐波拉起的优化思想

        if (n<3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for(int i = 3; i < n + 1; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
