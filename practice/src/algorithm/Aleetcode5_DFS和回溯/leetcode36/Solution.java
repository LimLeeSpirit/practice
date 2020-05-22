package algorithm.Aleetcode5_DFS和回溯.leetcode36;

import java.util.HashMap;

/**
 * 有效的数独
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 对于3X3方阵，利用对3 取整 就能获得所在的哪个方阵。
 *
 * 对于Python实现的集合里面嵌套list或者tuple，很容易，但在Java里面，好像不常用集合的集合
 *
 * 这里在判断重复的时候，需要对每行，每列，每个小方格都设置一个映射，
 * key为board的元素值，value为key在该行、列、小方格 出现的次数！若是次数 > 1, 则说明是重复了。
 *
 * 注意： 1、在判断重复的时候不要只想着集合的 contains 方法， 如果出现的个数 > 1 了，那不就是重复了吗 ！！！！
 *       2、区分小格子那里的方法可以学习下，利用i，j 下标区分小格子。
 *
 * 将 java 和 Python 代码写个博客
 */
public class Solution {
    public boolean isValidSudoku2(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] cell = new int[3][3][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    if (row[i][k] > 0 || col[j][k] > 0 || cell[i/3][j/3][k] > 0) {
                        return false;
                    }
                    row[i][k] ++;
                    col[j][k] ++;
                    cell[i/3][j/3][k] ++;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // validate a board
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    // 区分当前是第几个小格子，9X9的格子阵里面有 9 个 3X3 的小格子。
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }

}
