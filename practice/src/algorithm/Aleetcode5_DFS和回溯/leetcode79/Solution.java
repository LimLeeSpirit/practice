package algorithm.Aleetcode5_DFS和回溯.leetcode79;

/**
 *  矩阵中的路径，查找单词
 *
 *  给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 *  单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 *
 *  其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 *
 *  不容易呀，居然写的挺对，
 *
 *  第二次的思路：枚举每个起点，然后进行回溯搜索，跟着y总走！是真的太牛逼了！
 *
 */

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        char[] chars = word.toCharArray();
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n ; j ++) {
                if (dfs(i, j, 0, chars, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int cur, char[] chars, char[][] board) {
        if (chars[cur] != board[i][j]) return false;
        // 走到了最后一个字母
        if (cur >= chars.length - 1) return true;

        // char tmp = board[i][j];
        board[i][j] = '#';

        for (int k = 0; k < 4; k ++) {
            int a = i + dx[k];
            int b = j + dy[k];
            if (0 <= a && a < m && 0 <= b && b < n) {
                if (dfs(a, b, cur + 1, chars, board)) {
                    return true;
                }
            }
        }

        board[i][j] = chars[cur];

        return false;
    }
}