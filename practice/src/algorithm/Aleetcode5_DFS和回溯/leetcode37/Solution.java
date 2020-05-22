package algorithm.Aleetcode5_DFS和回溯.leetcode37;

/**
 * 解数独
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 对于3X3方阵，利用对3 取整 就能获得所在的哪个方阵。
 *
 * 从前往后依次枚举每个空格该填哪一个数
 */


public class Solution {
    public static void solveSudoku(char[][] board) {
        if (board.length == 0 || board == null) { return; }
        solver(board);
    }

    public static boolean solver(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if (board[i][j] == '.') {
                    for(char k='1'; k<='9'; k++) {
                        // 判断把 k 放到这里是否可以
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            // 可以的话继续往下放，递归调用下去。如果发现不合适，则将[i][j]位置的值改回去
                            if (solver(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < board.length; i++) {
            // 行判重
            if (board[row][i] == c) { return false; }
            // 列判重
            if (board[i][col] == c) { return false; }
        }
        // 小方格判重
        for(int m=(row/3)*3; m<(row/3)*3+3; m++) {
            for(int n = (col/3)*3; n<(col/3)*3 + 3; n++) {
                if (board[m][n] == c) { return false; }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Math.round(-10.6));
    }
}
