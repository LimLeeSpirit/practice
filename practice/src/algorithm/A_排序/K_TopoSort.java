package algorithm.A_排序;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 针对 有向无环图（DAG）的排序算法
 *
 *
 * 拓扑排序是对 DAG 的顶点进行排序，使得对每一条有向边(u,v)，均有 u（在排序记录中）比 v 先出现。
 * 亦可理解为对某点 v 而言，只有当 v 的所有源点均出现了，v 才能出现。
 *
 * 可以针对图的表示形式：邻接矩阵进行宽搜 和 广搜 的拓扑排序
 */
public class K_TopoSort {
    /**
     * @param nei 有向无环图的邻接矩阵
     * @param n   顶点数
     * @return    拓扑排序结果
     */
    public static List<Integer> topo_sort(int[][] nei, int n) {
        List<Integer> ret = new ArrayList<>();
        int[] in_degree = new int[n];

        // 找出每个节点的入度数
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (nei[i][j] == 1) {
                    in_degree[j] ++;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        // 将入度为 0 的顶点先加入队列
        for (int i = 0; i < n; i ++) {
            if (in_degree[i] == 0) q.offer(i);
        }

        while (q.size() > 0) {
            // 将当前层入度为 0 节点的输出
            int len = q.size();
            for (int i = 0; i < len; i ++) {
                int req = q.poll();
                // + 1是为了让节点从 1 开始
                ret.add(req + 1);
                // 寻找其它入度为 0 的顶点加入进去
                for (int j = 0; j < n; j ++) {
                    if (nei[req][j] == 1) {
                        in_degree[j] --;
                        if (in_degree[j] == 0) {
                            q.offer(j);
                            System.out.println("j:" + j + 1);
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nei = {{0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0}};

        for (int a : topo_sort(nei, 5)) {
            System.out.print(a + " ");
        }
    }
}
