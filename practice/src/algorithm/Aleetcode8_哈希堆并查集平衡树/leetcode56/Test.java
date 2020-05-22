package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode56;

public class Test {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{3,4},{5,5},{4,5},{5,6},{2,3},{4,6},{0,0}};
        for(int i=0; i<4; i++) {
            for(int j=0; j<2; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");

        int[][] res = Solution.merge(intervals);
        for(int i=0; i<res.length; i++) {
            for(int j=0; j<2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
