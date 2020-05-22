package algorithm.Aleetcode5_DFS和回溯.leetcode52;

/**
 * N-皇后第二题，给定数字n，求出该 n 对应的 n皇后 解决方法数量。
 *
 * 每一行每一列只有一个皇后
 *
 * 依次枚举每一行，枚举该行每个位置皇后的位置
 *
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static Set<Integer> col = new HashSet<>();
    private static Set<Integer> pie = new HashSet<>();
    private static Set<Integer> na = new HashSet<>();
    static int sum;
    public static int totalNQueens(int n) {
        sum = 0;
        dfs(n, 0);
        return sum;
    }

    public static void dfs(int n, int row) {
        if (row >= n) {
            sum ++;
            return;
        }

        for(int i = 0; i < n; i ++) {
            // 对该行，所有的列遍历
            if (col.contains(i) || pie.contains(i+row) || na.contains(i-row)) { continue; }

            // 符合条件：继续走
            col.add(i);
            pie.add(i+row);
            na.add(i-row);

            dfs(n, row+1);

            // 回到上一层，修正
            col.remove(i);
            pie.remove(i+row);
            na.remove(i-row);
        }
    }
}