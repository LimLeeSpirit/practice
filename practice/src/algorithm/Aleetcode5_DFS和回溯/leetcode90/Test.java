package algorithm.Aleetcode5_DFS和回溯.leetcode90;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2,3,4};
        List<List<Integer>> ret = solution.subsetsWithDup(nums);
        for (List<Integer> list : ret) {
            for (Integer a : list) {
                System.out.printf(a + " ");
            }
            System.out.println();
        }
    }
}
