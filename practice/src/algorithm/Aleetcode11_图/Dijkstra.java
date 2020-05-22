package algorithm.Aleetcode11_图;

import java.util.Arrays;

public class Dijkstra {
    int n; // 节点数

    int[][] g;  // 权重值的邻接矩阵

    int[] dist; // 每个节点到 源 点的距离，这样把每个节点到源点的最短距离都算出来了

    boolean[] st; // 存储每个点的最短距离是否已确定

    int INF = 10000; // 默认值，距离最大为无穷

    public void dijkstra() {
        n = 10;
        g = new int[n + 1][n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];

        Arrays.fill(dist, INF);

        dist[1] = 0;
        // O（n^2）时间
        for (int i = 0; i < n; i ++) {
            int idx = -1;
            int min_d = INF;
            for (int j = 1; j <= n; j ++) {
                if (!st[j] && dist[j] < min_d) {
                    idx = j;
                    min_d = dist[j];
                }
            }
            st[idx] = true;

            // 找到了一个离源点最近的点，将这个点加入集合S，这个点的加入对 源点到其他点的最短距离有没有影响，更新
            for (int j = 1; j <= n; j ++) {
                dist[j] = Math.min(dist[j], dist[idx] + g[idx][j]);
            }
        }
    }
}

