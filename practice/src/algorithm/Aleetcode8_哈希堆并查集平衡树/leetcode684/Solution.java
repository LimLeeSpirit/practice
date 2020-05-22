package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode684;

/**
 * 在一棵树中，多了一条边，本来是 n 个节点，n-1 条边，但是现在是n条边，n + 1 个节点
 * 从小到大的顺序给出边，边的组成是一个数组<u, v>, u < v，起始顶点是 1，一直到 n+1
 * 求出多余那条边的顶点
 *
 * 输入 [[1, 2], [1, 3], [2, 3]]
 * 输出 [2, 3]
 *
 * 可以将相互联通的两个顶点当作一个类别里的，也就是他们如果相互联通，则就具有相同的类别信息。问题就转化为
 * 找出边的两个点中，已经是一个类别的边。
 *
 * 每个顶点就是一个类，顺序遍历如果发现一条边的两个点已经是一个类别的，那就把结果输出，因为如何还把这条边加上去的话，两个顶点之间就
 * 有两条不同的路径相互可达，这就形成了环。
 * 所以用并查集来做，时间复杂度为O（n + n），也就是O（n）；
 * 并查集 200、547、684、721
 */
public class Solution {
    int n;
    int[] root;
    private int find(int x) {
        if (root[x] != x) root[x] = find(root[x]);
        return root[x];
    }
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        root = new int[n + 1];

        for (int i = 0; i <= n; i ++) root[i] = i;

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (find(a) == find(b)) return new int[]{a, b};
            root[find(a)] = find(b);
        }
        return new int[]{};
    }
}
