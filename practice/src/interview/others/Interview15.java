package interview.others;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 给出评价矩阵，每一行每一列选一个元素出来之后，得到最大和，给出方案
 * 输入例子1:
 *
 * 3
 * 1.08 1.25 1.5
 * 1.5 1.35  1.75
 * 1.22 1.48 2.5
 *
 * 输出例子1:
 * 5.25
 * 1 2
 * 2 1
 * 3 3
 *
 * 5.25 = 1.25 + 1.5 + 2.5
 *
 * N 皇后的变种
 */
public class Interview15 {
    static double total;
    static int[][] ans;
    static HashSet<Integer> cols;
    static double[][] board;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        board = new double[N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                board[i][j] = in.nextDouble();
            }
        }

        cols = new HashSet<>();

        ans = new int[N][2];
        total = Integer.MIN_VALUE;

        dfs(N, 0, new ArrayList<int[]>(), 0);

        // 输出，total 保留两位小数

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(decimalFormat.format(total));

        for (int[] a : ans) {
            for (int b : a) {
                System.out.printf(b + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int N, int cur_row, List<int[]> tmp, double sum) {
        if (cur_row >= N) {
            if (sum > total) {
//                System.out.println("sum :" + sum);
                // 将tmp -> ans
                for (int i = 0; i < N; i ++) {
                    ans[i] = tmp.get(i);
                }
                total = sum;
                return;
            }
        }
        for (int i = 0; i < N; i ++) {
            if (!cols.contains(i)) {
                cols.add(i);
                tmp.add(new int[]{cur_row + 1, i + 1});
                sum += board[cur_row][i];

                dfs(N, cur_row + 1, tmp, sum);

                cols.remove(i);
                tmp.remove(tmp.size() - 1);
                sum -= board[cur_row][i];
            }
        }
    }
}
