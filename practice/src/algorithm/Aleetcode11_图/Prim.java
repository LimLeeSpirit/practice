package algorithm.Aleetcode11_图;

import java.util.Arrays;

public class Prim {
    int INF = 100000;

    int n; // n 个节点
    boolean[] st; // 节点 i 是否已经添加过
    int[] dist;   // 节点 j 到当前已经添加了的集合U的最短边的长度
    int[][] g;    // 节点 i 到节点 j 的长度，这个数组是需要提前算好的

    public int prim() {
        n = 10;
        st = new boolean[10 + 1];
        dist = new int[10 + 1];
        g = new int[10 + 1][10 + 1];

        // 返回值，最小生成树所以边的和
        int ans = 0;
        Arrays.fill(dist, INF);

        // 先将节点 1 加进去
        dist[1] = 0;

        for (int i = 1; i <= n; i ++) {
            int idx = -1, min_dist = INF;
            // 在集合 V 中找到离 U 中节点最短的节点idx，第一个是节点 1
            for (int j = 1; j <= n; j ++) {
                if (!st[j] && dist[j] < min_dist) {
                    idx = j;
                    min_dist = dist[j];
                }
            }
            st[idx] = true;
            ans += dist[idx];

            // 用新加入的点更新 其余点 到生成树的最短边
            for (int j = 1; j <= n; j ++) {
                if (!st[j]) {
                    dist[j] = Math.min(dist[j], g[idx][j]);
                }
            }
        }

        return ans;
    }
}
