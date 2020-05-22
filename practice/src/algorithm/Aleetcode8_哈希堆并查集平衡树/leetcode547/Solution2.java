package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode547;


import algorithm.Aleetcode8_哈希堆并查集平衡树.UnionFind;

/**
 * 这里需要注意一点，利用并查集进行解决问题的时候，需要想清楚到底创建一个什么样的并查集，要和实际问题结合起来，
 * 结合 721 合并账户题
 * 比如这道题，给出关系矩阵M，我们只需要 M.length 个初始元素即可，因为只有 M.length 这么多个人，在他们之间划分朋友圈
 */
public class Solution2 {
    public static int findCircleNum(int[][] M) {
        if (M == null || M[0] == null || M[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(M.length);

        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M[0].length; j++) {
                if (M[i][j] == 1) {
                    uf.Union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        int[][] M= {{1,0,0,1},
                    {0,1,1,0},
                    {0,1,1,1},
                    {1,0,1,1}};
        System.out.println(findCircleNum(M));
    }
}

