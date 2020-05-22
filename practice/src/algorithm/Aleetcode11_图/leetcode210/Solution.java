package algorithm.Aleetcode11_图.leetcode210;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 课程表第二题，按照先修顺序，先判断是否可以安排课程（是否可以进行拓扑排序）是的话给出拓扑排序结果
 */
public class Solution {
    public int[] findOrder(int n, int[][] pre) {
        int[] in_degree = new int[n];
        for (int[] a : pre) {
            in_degree[a[0]] ++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i ++) {
            if (in_degree[i] == 0) q.offer(i);
        }
        int[] ans = new int[n];
        int k = 0;
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i ++) {
                int cur = q.poll();
                ans[k ++] = cur;
                n --;
                for (int[] a : pre) {
                    if (a[1] == cur) {
                        in_degree[a[0]] --;
                        if (in_degree[a[0]] == 0) q.offer(a[0]);
                    }
                }
            }
        }
        if (n != 0) return new int[]{};
        return ans;
    }
}
