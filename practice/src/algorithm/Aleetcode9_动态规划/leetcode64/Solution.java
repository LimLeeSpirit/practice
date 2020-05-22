package algorithm.Aleetcode9_动态规划.leetcode64;

/**
 *  求解从矩阵左上角到右下角的最短路径
 *  依然是DP，逆向思维，从右下到左上 去思考。
 */
public class Solution {
    public int minPathSum(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        int m = mat.length;
        int n = mat[0].length;

        int[][] DP = new int[m][n];
        DP[m - 1][n - 1] = mat[m - 1][n - 1];

        for (int i = n - 2; i >= 0; i --) DP[m - 1][i] = DP[m - 1][i + 1] + mat[m - 1][i];

        for (int j = m - 2; j >= 0; j --) DP[j][n - 1] = DP[j + 1][n - 1] + mat[j][n - 1];

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                DP[i][j] = Math.min(DP[i + 1][j], DP[i][j + 1]) + mat[i][j];
            }
        }

        return DP[0][0];
    }
}