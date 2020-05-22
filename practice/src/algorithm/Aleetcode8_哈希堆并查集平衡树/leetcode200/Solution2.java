package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode200;

public class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到一个 1 之后就把与之向连接的 1 置为0，！然后count++，帅气呀！！！
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(char[][] grid, int i, int j) {
        /**
         * 好像是他的更简单一鞋，这个DFS的作用就是将上下左右的 1 置为0！，这样一个连通分量就找出来了！
         */
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
}
