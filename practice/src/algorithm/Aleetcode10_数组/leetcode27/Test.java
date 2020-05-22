package algorithm.Aleetcode10_数组.leetcode27;

public class Test {
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        System.out.println(Solution.removeElement2(nums, 2));
        for(int i:nums) {
            System.out.print(i);
        }
    }
}
