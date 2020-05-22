package algorithm.Aleetcode5_DFS和回溯.leetcode78;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> ret = Solution2.subsets(nums);
        for (List<Integer> a : ret) {
            for ( int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

}
