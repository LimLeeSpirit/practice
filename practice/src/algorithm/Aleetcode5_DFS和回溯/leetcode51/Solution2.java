package algorithm.Aleetcode5_DFS和回溯.leetcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] v = new boolean[n];
        boolean[] u = new boolean[2 * n - 1];
        boolean[] d = new boolean[2 * n - 1];
        int[] indexes = new int[n];
        helper(res, indexes, v, u, d, n, 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] indexes, boolean[] v, boolean[] u, boolean[] d, int n, int row) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                char[] ch = new char[n];
                Arrays.fill(ch, '.');
                ch[indexes[i]] = 'Q';
                temp.add(new String(ch));
            }
            res.add(temp);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(v[col] || u[row + col] || d[row - col + n - 1]) {
                continue;
            }
            v[col] = true;
            u[row + col] = true;
            d[row - col + n - 1] = true;
            indexes[row] = col;

            helper(res, indexes, v, u, d, n, row+1);

            v[col] = false;
            u[row + col] = false;
            d[row - col + n - 1] = false;
        }
    }
}