package algorithm.A_排序;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 修课程顺序
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程 prerequisites。 我们用一个匹配来表示他们:
 * [0, 1] 代表 1 - > 0，必须先修完 1，才能修 0
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；
 * 并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 本题可约化为：课程安排图是否是 有向无环图(DAG)。如果有环，则无法满足先修条件，返回false
 *
 * 利用拓扑排序对课程进行排序。给出的是边的情况，不是邻接矩阵，其实都是类似的
 */
public class K_U_leetcode207 {
    public boolean canFinish(int n, int[][] prerequisites) {
        Queue<Integer> q = new ArrayDeque<>();
        // 统计每个节点的入度情况
        int[] in_degree = new int[n];
        for (int[] pre : prerequisites) in_degree[pre[0]] ++;

        for (int i = 0; i < n; i ++) {
            if (in_degree[i] == 0) q.offer(i);
        }

        while (q.size() > 0) {
            int req = q.poll();
            n --;
            for (int pre[] : prerequisites) {
                // 找到以 req 为起始顶点的边
                if (pre[1] == req) {
                    if ((-- in_degree[pre[0]]) == 0) q.offer(pre[0]);
                }
            }
        }
        return n == 0;
    }
}
