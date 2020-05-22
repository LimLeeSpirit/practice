package algorithm.Aleetcode5_DFS和回溯.leetcode37;

/**
 * 解数独，将字符 1 - 9 填入不完整的棋盘，保证三个条件：每个行、列不能出现重复元素，3X3的小方格不能出现重复元素。
 *
 * 注意这个和单词搜索的区别，单词搜索是遍历到第一个字母相同的时候，才进行dfs
 * 这种棋盘问题，需要填充整个空棋盘的时候，需要从头开始搜索
 */
public class Solution2 {
    // 利用数组判断数字是否重复，true代表重复
    // row[7][1] 代表第 7+1 行 的字符 1 已经使用过了
    boolean[][] row = new boolean[9][9];
    // col[7][2] = true 代表第 7 + 1 列的字符 2 已经使用过了
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char c = board[i][j];
                if (c != '.') {
                    int k = c - '1';
                    row[i][k] = true;
                    col[j][k] = true;
                    cell[i/3][j/3][k] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    /**
     *
     * @param board 棋盘
     * @param i 当前行
     * @param j 当前列
     * @return  是否可以继续填充
     */
    private boolean dfs(char[][] board, int i, int j) {
        if (j == 9) {
            i ++;
            j = 0;
        }
        if (i == 9) return true;

        if (board[i][j] != '.') return dfs(board, i, j + 1);

        for (int k = 0; k < 9; k ++) {
            if (!row[i][k] && !col[j][k] && !cell[i/3][j/3][k]) {
                board[i][j] = (char)('1' + k);

                row[i][k] = true;
                col[j][k] = true;
                cell[i/3][j/3][k] = true;

                if (dfs(board, i, j + 1)) {
                    return true;
                }

                row[i][k] = false;
                col[j][k] = false;
                cell[i/3][j/3][k] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }
}
