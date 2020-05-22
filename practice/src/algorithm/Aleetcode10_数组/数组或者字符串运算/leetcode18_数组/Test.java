package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode18_数组;


import java.util.List;

public class Test {
    public static void main(String[] args) {
        int nums[] = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = Solution.fourSum(nums, -1);
        for(List<Integer> l: res) {
            for(int k:l) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
