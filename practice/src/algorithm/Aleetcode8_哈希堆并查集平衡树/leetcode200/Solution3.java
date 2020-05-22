package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode200;

/**
 * 岛屿数量
 *
 * 并查集的实现方式，和 547、721题结合
 *
 * 在某一个位置上下左右便利的时候，也只是遍历的周围元素，而不是他所在行、所在列的所有元素，这点要注意，对于岛屿，必须遍历
 * 其周围元素，这样才是岛屿；不像朋友圈那题，朋友圈中只要 M[i][j] == 1，i, j 就是一个集合里的。这点要注意区分！
 */
public class Solution3 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int newI = directions[k][0] + i;
                        int newJ = directions[k][1] + j;
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1') {
                            uf.union(i * n + j, newI * n + newJ);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }
}

class UnionFind {
    private int count=0;
    private int[] roots;
    // ranks 存在的意义是生成更为优美的树，使 find 效率更高。
    private int[] ranks;

    public UnionFind(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        this.roots = new int[m*n];
        this.ranks = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    roots[i * n + j] = i * n + j;
                    this.count++;
                }
            }

        }
    }
    public int getCount() {
        return this.count;
    }

    public int find(int i) {
        if (this.roots[i] != i) {
            this.roots[i] = find(this.roots[i]);
        }
        return this.roots[i];
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (this.ranks[rootI] > this.ranks[rootJ]) {
                this.roots[rootJ] = rootI;
            } else if (this.ranks[rootI] < this.ranks[rootJ]) {
                this.roots[rootI] = rootJ;
            } else {
                this.roots[rootI] = rootJ;
                this.ranks[rootJ]++;
            }
            this.count--;
        }
    }
}
