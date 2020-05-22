package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode200;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  岛屿的数量（朋友圈的数量）
 *  给定一个包含0、1的矩阵，求1的最大连通（本身是1且上下左右也有1则他们相连）分量的个数
 *
 *  法1、广度优先遍历，只不过是按照上下左右来当前一层的，不像是树结构的左右子树是一层。很高深！这个"一层"的思想
 */
public class Solution {
    private static int[] dx =  {-1, 1, 0, 0};
    private static int[] dy =  {0, 0, -1, 1};
    private static int[][] checked;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) { return 0;}
        checked = new int[grid.length][grid[0].length];

        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                count += BFS(grid, i, j);
            }
        }
        return count;
    }

    private static int BFS(char[][] grid, int i, int j) {
        // 上下左右扩散

        if (!isValid(grid, i, j)) { return 0; }
        checked[i][j] = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curIJ = queue.poll();
            int curX = curIJ[0];
            int curY = curIJ[1];
            for (int k=0; k<4; k++) {
                int newX = curX + dx[k], newY = curY+dy[k];

                if (isValid(grid, newX, newY)) {
                    checked[newX][newY] = 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return 1;
    }

    private static boolean isValid(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) { return false; }
        if (grid[i][j] == '0' || checked[i][j]==1) { return false; }
        return true;
    }
}
