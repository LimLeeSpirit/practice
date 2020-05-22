package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode200;

/**
 * 岛屿的数量
 * 给定一个包含0、1的矩阵，求1的最大连通（本身是1且上下左右也有1则他们相连）分量的个数
 *
 * 哈哈哈又是分类别的题，这不就是并查集的东西，第三遍自己写了，完美！
 * 并查集的题 200、547、684、721写个博客，200、547、684、721
 */
public class Solution4 {
    int n;
    int m;
    int[] root;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    private int find(int x) {
        if (root[x] != x) root[x] = find(root[x]);
        return root[x];
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 ) return 0;
        n = grid.length;
        m = grid[0].length;

        root = new int[n * m];

        int ret = 0;
        // 对陆地进行初始化种类信息
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == '1') {
                    root[i * m + j] = i * m + j;
                    ret ++;
                }
            }
        }
        System.out.println(ret);

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                // 如果当前节点为 1，则找到它上下左右的为 1 的元素，比较是否是一个种族的，如果不是，将
                // 本节点的种族信息赋给邻居节点的种族
                if (grid[i][j] == '0') continue;
                int rootC = find(i * m + j);
                for (int k = 0; k < 4; k ++) {
                    int a = i + dx[k];
                    int b = j + dy[k];
                    if (0 <= a && a < n && 0 <= b && b < m && grid[a][b] == '1') {
                        int rootN = find(a * m + b);
                        if (rootN != rootC) {
                            root[rootN] = rootC;
                            ret --;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
