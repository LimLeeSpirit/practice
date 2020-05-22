package algorithm.Aleetcode9_动态规划.leetcode62;

import java.util.Arrays;

/**
 *  求解从矩阵左上角到矩阵右下角的路径条数。且只能向左走或向右走。
 *
 *  这算是二维数组里最简单的动态规划了吧。
 *  逆向思维：求从左上->右下，如何从右下到左上呢？  会不会好理解点。
 *
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) { return 0; }
        if (m == 1 || n == 1) { return 1; }
        // 状态变量：op[i][j] 代表[i][j]位置到右下位置的不同路径数
        int[][] op = new int[m][n];
        // 初始化状态变量
        Arrays.fill(op[m-1], 1);

        for (int i = 0; i < m; i++) {
            op[i][n-1] = 1;

        }

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                // 动态方程
                op[i][j] = op[i + 1][j] + op[i][j + 1];
            }
        }

        return op[0][0];
    }
}
