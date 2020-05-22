package algorithm.Aleetcode9_动态规划;

import java.util.Arrays;

/**
 * 分配任务，计算执行完任务的最少时间
 * 给定每个机器执行同一个任务的时间数组，如 3 个机器，执行一个任务的时间分别为：[5, 7, 9]
 *
 * 给定 n 个相同的任务。问如何分配任务到机器上才能使总时间最少,给出任务分配数组
 *
 * 这里的策略是贪心策略，仔细想一下，是可以一步一步使用贪心达到最优解的：
 * 假设此时的任务安排分布已知，新来一个任务，将这个任务分配到那哪呢？使用贪心：
 * 计算每台机器已经分配的时间 + 新到任务的时间 的最小值，记录最小值的机器下标，将这个任务分配到该机器上。
 *
 * 哈哈哈现在自己做这类题，一下子就做出来了，就是简单的贪心策略。
 */
public class AssignMissions {
    public static void assMissions(int[] cost, int n) {
        // 先排序的目的是先从耗时少的开始
        Arrays.sort(cost);
        int m = cost.length;
        int[] ans = new int[m];
        while (n > 0) {
            int idx = 0;
            for (int i = 1; i < m; i ++) {
                idx = cost[idx] * (ans[idx] + 1) < cost[i] * (ans[i] + 1) ? idx : i;
            }
            ans[idx] ++;
            n --;
        }
        for (int a : ans) System.out.print(a + " ");
    }

    public static void main(String[] args) {
        int[] machines = {5, 7, 9};
        assMissions(machines, 10);
    }
}
