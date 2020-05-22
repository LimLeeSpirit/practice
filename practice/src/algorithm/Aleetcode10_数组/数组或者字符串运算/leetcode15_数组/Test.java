package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode15_数组;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 0};

        //  List<List<Integer>> res = Solution1.threeSum(nums);
        List<List<Integer>> res2 = Solution2.threeSum(nums);


        for (int i=0;i<res2.size(); i++) {
            for (int j=0; j< res2.get(i).size(); j++) {
                // System.out.print(res.get(i).get(j) + " ");
                System.out.print(res2.get(i).get(j) + " ");

            }
            System.out.println();
        }
    }
}
