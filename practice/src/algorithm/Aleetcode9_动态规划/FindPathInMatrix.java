package algorithm.Aleetcode9_动态规划;

/**
 * 给定一个 N * N 的迷宫，其中 1 代表通路，0 代表阻塞，只能往下面和右边走，问能否从左上角走到右下角
 *
 * 可以结合力扣63题: 在可以到达的情况下，求路径总数  进行学习，所以也可以使用动态规划，
 * 若求出来DP[0][0] == 0: return false;
 *       DP[0][0] > 0: return true.
 *
 *  更熟悉DP做法，更加明了
 */
public class FindPathInMatrix {
    public static boolean canFind(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        int[][] dp = new int[m][n];
        for (int i = n - 1; i >= 0; i --) {
            if (nums[m - 1][i] == 0) {
                for (int j = i; j >= 0; j --) {
                    // 1 代表走不通
                    dp[m - 1][j] = 1;
                }
                break;
            }
        }

        for (int i = m - 1; i >= 0; i --) {
            if (nums[i][n - 1] == 0) {
                for (int j = i; j >= 0; j --) {
                    dp[j][n - 1] = 1;
                }
                break;
            }
        }

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                if (nums[i][j] != 0)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0] == 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0},
                          {1, 1, 0, 1},
                          {0, 1, 0, 0},
                          {1, 1, 1, 1}};

        System.out.println(canFind(matrix));
    }
}
