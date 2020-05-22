package interview.meituan;

import java.util.Scanner;

/**
 * 美团笔试1
 * 找出幸运星的个数，DFS
 */
public class Interview1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] board = new int[2000][2000];

        int ans = 0;

        for (int i = 0; i < N; i ++) {
            int x = in.nextInt() + 1000;
            int y = in.nextInt() + 1000;
            board[x][y] = 1;
        }

        for (int i = 0; i < 2000; i ++) {
            for (int j = 0; j < 2000; j ++) {
                if (board[i][j] == 1) {
                    ans += check(board, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static int check(int[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < x; i ++) {
            if (board[i][y] == 1) {
                cnt ++;
                break;
            }
        }
        if (cnt == 0) return 0;

        for (int i = x + 1; i < 2000; i ++) {
            if (board[i][y] == 1) {
                cnt ++;
                break;
            }
        }
        if (cnt == 1) return 0;

        for (int i = 0; i < y; i ++) {
            if (board[x][i] == 1) {
                cnt ++;
                break;
            }
        }
        if (cnt == 2) return 0;

        for (int i = y + 1; i < 2000; i ++) {
            if (board[x][i] == 1) {
                cnt ++;
                break;
            }
        }
        if (cnt == 3) return 0;
        return 1;
    }

}
