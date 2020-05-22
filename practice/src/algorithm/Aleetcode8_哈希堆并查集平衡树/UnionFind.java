package algorithm.Aleetcode8_哈希堆并查集平衡树;

public class UnionFind {
    private int count;
    private int[] roots;
    // ranks 存在的意义是生成更为优美的树，使 find 效率更高。
    private int[] ranks;
    public UnionFind(int m) {
        this.roots = new int[m];
        this.ranks = new int[m];
        this.count = m;
        for (int i=0; i<m; i++) {
            roots[i] = i;
        }
    }

    public int find(int i) {
        if (this.roots[i] != i) {
            this.roots[i] = find(this.roots[i]);
        }
        return this.roots[i];
    }

    /**
     * 这个合并高级啊！！！将 用户i 和用户j 合并，就是放在一个集合的意思。
     * 如果M[i][j] 为 1，那么 i 和 j就是一个集合（朋友圈）里的
     * @param i
     * @param j
     */
    public void Union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (this.ranks[rootI] > this.ranks[rootJ]) {
                this.roots[rootJ] = rootI;
            } else if (this.ranks[rootI] < this.ranks[rootJ]) {
                this.roots[rootI] = rootJ;
            } else {
                this.roots[rootI] = rootJ;
                this.ranks[rootJ] ++;
            }
            this.count --;
        }
    }

    public int getCount() {
        return this.count;
    }
}
