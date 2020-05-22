package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode547;

/**
 *  求朋友圈数量
 *  给出的是对称矩阵，
 *  这题和求岛屿数量有点不同，岛屿是必须相连那才叫相连的岛屿，而朋友圈同行、同列 就是一个小朋友圈了。
 *  比如矩阵： 1 0 0 1
 *           0 1 1 0
 *           0 1 1 1
 *           1 0 1 1
 *  如果求岛屿数量就是4，朋友圈数量就是 1。
 *
 *  这个和 求岛屿的数量200题 一起写个博客，不用并查集求解。
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int m = M.length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                // 找到一个 1 之后就把与之向连接的 1 置为0，！然后count++，帅气呀！！！
                if (M[i][j] == 1) {
                    DFS(M, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(int[][] M, int i, int j) {
        /**
         *  哈哈哈这道题确实用并查集好一些，不过我用岛屿的思想也做的出来
         *  利用DFS将是一个朋友圈的全部合并起来，将他们的 1 归为0，行、列相交的都是一个朋友圈的。
         */
        if (i < 0 || i >= M.length || j < 0 || j >= M.length || M[i][j] == 0) return;
        M[i][j] = 0;
        int hang = M.length-j;
        int lie = j-i;
        // 本列左右扩展
        for(int a=i; a<j; a++) {
            DFS(M, i, a);
        }
        for (int k=1; k<hang; k++) {
            DFS(M, i, j+k);
        }

        // 本行上下扩展
        for (int b=0;b<i; b++) {
            DFS(M, b, j);
        }
        for (int z=1; z<=lie; z++) {
            DFS(M,i+z, j);
        }
    }
}