package algorithm.Aleetcode9_动态规划.leetcode542;

/**
 * 给定矩阵，求出每个元素离最近的 0 的距离，最近的 0 可以不和该元素同一行
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * 返回
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 在原矩阵的基础上返回
 */
public class Solution {
    private static int[] dx = {-1, 0, 1, 0}; //  上 左 下 右
    private static int[] dy = {0, -1, 0, 1};

    /**
     * 我们在遍历的时候总是根据从左到右、从上到下的顺序来的，对于某个我们想要考虑的元素，如果他的左边邻居和上面的邻居都已经被计算过，
     * 那么我们就可以根据他的左、上边邻居得到他的计算结果值。
     * 第一次遍历结束后，还只是考虑了从左上邻居的情况，没有考虑右下邻居的情况，然后再进行一次遍历，从右往左、从下往上遍历，
     * 此时就可以根据右、下邻居计算出一个值，这个值要和第一遍根据左上邻居计算出来的结果进行比较取小。即得到该位置处的计算结果。
     * 可能有同学会问了，为什么不能用一次遍历呢，直接把该元素的上下左右四个邻居全部考虑进来呢？
     * 对于这个问题，我们需要考虑一点，那就是从上到下，从左到右遍历的时候，对于给定位置的元素，他的左上邻居才有计算结果，右下邻居根本还没得到计算，
     * 怎么可以把非计算结果代带进去比较呢？
     * 举个例子，比如矩阵中的某个小区域是这个样子：
     * 1 0 1 1
     * 1 1 1 1
     * 0 0 1 1
     * 1 0 1 1
     *
     * 只遍历一次的前两行结果为：
     * 1 0 1 2
     * 1 1 2 2
     *
     * 对于第2行最后一个结果，明显错了对不对，因为他直接把他的下邻居的 1 拿来计算了。
     *
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] nums) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int m = nums.length, n = nums[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (nums[i][j] != 0) {
                    int x, y;
                    int cur_min = 100001;
                    for (int k = 0; k < 2; k ++) {
                        x = i + dx[k];
                        y = j + dy[k];
                        if (0 <= x && x < m && 0 <= y && y < n)
                            cur_min = Math.min(cur_min, nums[x][y]);
                    }
                    nums[i][j] = cur_min + 1;
                }
            }
        }

        for (int i = m -1; i >= 0; i --) {
            for (int j = n -1; j >=0; j --) {
                if (nums[i][j] != 0) {
                    int x, y;
                    int cur_min = 100001;
                    for (int k = 2; k < 4; k ++) {
                        x = i + dx[k];
                        y = j + dy[k];
                        if (0 <= x && x < m && 0 <= y && y < n)
                            cur_min = Math.min(cur_min, nums[x][y]);
                    }
                    // 注意这里是和上面左上步骤计算出的进行比较
                    nums[i][j] = Math.min(cur_min + 1, nums[i][j]);
                }
            }
        }
        return nums;
    }

    /**
     * 其实有点像是 DP，先左上，再左下，因为邻居可以不在一条线上，可以拐歪的。但是为什么他会想到这种思路呢
     * 普通的根本想不到好吧，最多就是用BFS来做
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 左上角开始分析
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 跳过0
                if (matrix[i][j] == 0) {
                    continue;
                }

                int min = 10001;
                // 上边
                if (i > 0) {
                    min = matrix[i - 1][j];
                }
                // 左边
                if (j > 0) {
                    min = Math.min(min, matrix[i][j - 1]);
                }
                matrix[i][j] = min + 1;
            }
        }

        // 右下角开始分析
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // 跳过0
                if (matrix[i][j] == 0) {
                    continue;
                }

                int min = 10001;
                // 下边
                if (i < row - 1) {
                    min = matrix[i + 1][j];
                }
                // 右边
                if (j < col - 1) {
                    min = Math.min(min, matrix[i][j + 1]);
                }
                // 跟从左上角开始的取最小的
                matrix[i][j] = Math.min(min + 1, matrix[i][j]);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,1,0,1,1,1,0,1,1},
                    {1,1,1,1,0,1,1,1,1,1},
                    {1,1,1,1,1,0,0,0,1,1},
                    {1,0,1,0,1,1,1,0,1,1},
                    {0,0,1,1,1,0,1,1,1,1},
                    {1,0,1,1,1,1,1,1,1,1},
                    {1,1,1,1,0,1,0,1,0,1},
                    {0,1,0,0,0,1,0,0,1,1},
                    {1,1,1,0,1,1,0,1,0,1},
                {1,0,1,1,1,0,1,1,1,0}

        };
        // 0,0,1,0,1,1,1,0,1,1
        // 1,1,1,1,0,1,1,1,1,1
        // 1,1,1,1,1,0,0,0,1,1
        // 1,0,1,0,1,1,1,0,1,1
        // 0,0,1,1,1,0,1,1,1,1
        // 1,0,1,1,1,1,1,1,1,1
        // 1,1,1,1,0,1,0,1,0,1
        // 0,1,0,0,0,1,0,0,1,1
        // 1,1,1,0,1,1,0,1,0,1
        // 1,0,1,1,1,0,1,1,1,0

        int[][] res = updateMatrix(mat);
        for (int[] a : res) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
