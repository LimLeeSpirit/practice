package interview.alibaba;

import java.util.ArrayList;
import java.util.List;

public class FindBestWay {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;
    static int[][] v;
    public static int ret = Integer.MAX_VALUE;
    public static List<Integer> sets;
    public static List<Integer> findWay(int[][] b) {
        m = b.length;
        n = b[0].length;
        v = new int[m][n];
        sets = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            dfs(b, sets, b[0][i], 0, i);
        }
        System.out.println(ret);
        return sets;

    }

    private static void dfs(int[][] board, List<Integer> set, int tmp, int row, int col) {
        if (row >= m - 1) {
//            for (Integer a : sets) {
//                System.out.printf(a + " ");
//            }
//            System.out.println();
            ret = Math.min(tmp, ret);
            return;
        }
        for (int i = 1; i < 4; i ++) {
            int a = dx[i] + row;
            int b = dy[i] + col;
            if (0 <= a && a < m && 0 <= b && b < n && v[a][b] != 1) {
                v[a][b] = 1;
                tmp += board[a][b];
                set.add(board[a][b]);
                dfs(board, set, tmp, a, b);

                tmp -= board[a][b];
                v[a][b] = 0;
                set.remove(set.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {9,9,1,1},
                {9,1,1,9},
                {1,1,9,9},
        };
        findWay(board);
    }
}
