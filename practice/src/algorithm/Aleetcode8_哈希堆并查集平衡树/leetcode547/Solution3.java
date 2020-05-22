package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode547;

/**
 * 朋友圈个数
 *  *  比如矩阵： 1 0 0 1
 *  *           0 1 1 0
 *  *           0 1 1 1
 *  *           1 0 1 1
 *  *  朋友圈数量就是 1。
 *
 * 这是第三次做这个题，典型的利用并查集查找查找朋友圈，为什么用并查集来找呢，因为这道题相当于是并查集的模版题
 * 并查集：每个元素都有自己的帮派，包含自己的种类信息，并查集可以对元素进行快速的find找到种类信息、
 * union将两个不是一个种类的元素进行合并，他们实现依赖于一个数组p，p保存了每个元素自己的种类信息。
 *
 * 200、547、684、721
 */
public class Solution3 {
    int[] p;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int findCircleNum(int[][] M) {
        // n个人，n个元素
        int n = M.length;
        p = new int[n];

        // 初始化每个元素的种类
        for (int i = 0; i < n; i ++) p[i] = i;

        int ret = n;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                // 相互认识且不在同一个朋友圈，则合并
                if (M[i][j] == 0) continue;
                if (find(i) != find(j)) {
                    p[find(i)] = find(j);
                    ret --;
                }
            }
        }
        return ret;
    }
}
