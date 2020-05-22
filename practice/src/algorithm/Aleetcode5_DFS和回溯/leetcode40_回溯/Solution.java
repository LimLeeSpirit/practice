package algorithm.Aleetcode5_DFS和回溯.leetcode40_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode40 combinationSum2  找出数组中所有的和为 target 的组合，数组中元素只能用一次。
 *
 * 使用回溯法,其实就是递归解法：不合适就退回上一步，然后通过约束条件, 减少时间复杂度
 * 使用类似解法的还有：40. 组合总和 II    46. 全排列     47. 全排列 II      78. 子集      90. 子集 II
 *
 * 注意：
 * 在回溯函数 backTrace 中，tempSum += candidates[i] 这一步骤需要放到函数形参里去，不能当作一条语句单独写在函数体内
 * 原因是本类就是个递归的过程，如果你单独把他写出来，那么他就是必定执行的一句，但是在递归终止条件的时候，可能会不一致，所以为了
 * 减少bug，还是在函数参数里面进行改变比较好。
 *
 * 同时需要注意如何让判重，比如 1，1，3，3，5，7，8，第一次是1，1=这一层的寻找完了，那下一个又是1，难道又要重新开始吗，不能，所以需要去重。
 *
 */
public class Solution {
    List<List<Integer>> ret;
    int n;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        n = nums.length;
        ret = new ArrayList<List<Integer>>();

        dfs(nums, target, new ArrayList<Integer>(), 0, 0);

        return ret;
    }
    private void dfs(int[] nums, int target, List<Integer> tmp, int sum, int start) {
        if (sum == target) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < n; i ++) {
            // 这个除去重复的还是有点难想
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (nums[i] + sum <= target) {
                sum += nums[i];
                tmp.add(nums[i]);

                // 是从i的下一个 i + 1 开始加了
                dfs(nums, target, tmp, sum, i + 1);

                sum -= nums[i];
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}

