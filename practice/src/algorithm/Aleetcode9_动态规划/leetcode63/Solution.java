package algorithm.Aleetcode9_动态规划.leetcode63;

/**
 *  求解从矩阵左上角到矩阵右下角的路径条数。且只能向左走或向右走。
 *  在62题的基础上添加了一个条件：如果有障碍物，则不走。
 *
 *  逆向思维：求从左上->右下，依然是从右下到左上，更好理解 。
 *
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        int m = mat.length;
        int n = mat[0].length;
        if (mat[m - 1][n - 1] == 1) return 0;

        // 状态变量：op[i][j] 代表[i][j]位置到右下位置的不同路径数
        int[][] DP = new int[m][n];

        // 初始化状态变量，这里有点小坑，初始状态里，最底行、最右列中有1（障碍物）的时候，前面所有的op状态均为0。
        // 直接跳过就行了，默认是0
        for (int i = m - 1; i >= 0; i --) {
            if (mat[i][n - 1] == 0) {
                DP[i][n - 1] = 1;
            } else {
                break;
            }
        }

        for (int j = n -1; j >= 0; j --) {
            if (mat[m - 1][j] == 0) {
                DP[m - 1][j] = 1;
            } else {
                break;
            }
        }

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                if (mat[i][j] == 0) DP[i][j] = DP[i + 1][j] + DP[i][j + 1];
                else DP[i][j] = 0;
            }
        }

        return DP[0][0];
    }
}
