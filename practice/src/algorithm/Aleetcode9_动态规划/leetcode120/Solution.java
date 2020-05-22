package algorithm.Aleetcode9_动态规划.leetcode120;

import java.util.List;

/**
 *  三角形最小路径和
 *  2
 *  3 4
 *  6 5 7
 *  4 1 8 3
 *  这样的排列，从上到下最短路径和？只能往下或者往右偏一个位置，即三角形走法
 *
 *  还可以扩展问题：1、路径求出来；2、一维解法行不行？，DP[m]:m行到最底行的最短路径。
 *              3、为什么整形 list 转数组不行啊？？？
 */
public class Solution {
    // 6ms
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        // 状态：DP[i][j]，集合属性：所以从最下面一排到当前元素的路径和； 属性：路径和中的最小值
        int[][] DP = new int[m][n];

        for (int i = 0; i < triangle.get(m-1).size(); i ++) {
            DP[m-1][i] = triangle.get(m-1).get(i);
        }

        for (int i = m - 2; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
//                if (DP[i+1][j] > DP[i+1][j+1]) {
//                    DP[i][j] = triangle.get(i).get(j) +  DP[i+1][j+1];
//                } else {
//                    DP[i][j] = triangle.get(i).get(j) +  DP[i+1][j];
//                }
                DP[i][j] = triangle.get(i).get(j) + Math.min(DP[i+1][j],DP[i+1][j + 1]) ;
            }
        }
        return DP[0][0];



        /**
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(3);
        int[] arr = testList.toArray(new int[0]);

        List<String> testList2 = new ArrayList<>();
        testList2.add("1");
        testList2.add("3");
        String[] arr2 = testList2.toArray(new String[0]);
        // 为什么不能转整数的？？*/
    }
}
