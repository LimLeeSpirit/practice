package algorithm.Aleetcode5_DFS和回溯.leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。要求子集不重复
 *
 *  我的困惑在于：递归终止条件如何写？子集的大小是从0增长到 nums.length 的，这个会不会是一个线索？
 *
 *  确实有用到这个线索，从0开始，一直到nums.length-1。但是我感觉好难想啊，特别是退回到上一层的时候。
 *
 *  使用类似解法的还有：40. 组合总和 II    46. 全排列     47. 全排列 II      78. 子集      90. 子集 II
 *
 */

public class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int count, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for(int j = count; j < n; j ++) {
            temp.add(nums[j]);
            dfs(nums, j+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
