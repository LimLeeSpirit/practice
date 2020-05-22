package algorithm.Aleetcode5_DFS和回溯.leetcode39_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中所有的和为 target 的组合。数组中的每个元素都可以无限使用。leetcode40 combinationSum2 数组中元素只能用一次。
 *
 * 使用回溯法：不合适就退回上一步，然后通过约束条件, 减少时间复杂度
 * 使用类似解法的还有：40. 组合总和 II    46. 全排列     47. 全排列 II      78. 子集      90. 子集 II
 *
 * 这里学习一个写法：
 * 返回 List<List<Integer>> res.  可以使用这样的写法：res.add(new ArrayList<>(tmp_list))
 * 其中 tmp_list 在函数形参中为 ArrayList<Integer> tmp_list
 *
 * 哈哈哈哈现在终于可以写的比较好了，只是去重的时候需要多注意下
 */
public class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        ret = new ArrayList<>();
        dfs(nums, target, new ArrayList<Integer>(), 0, 0);
        return ret;
    }

    private void dfs(int[] nums, int target, List<Integer> tmp, int sum, int start) {
        if (sum > target) return;
        if (target == sum) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        // 这里从 i 开始，规定若第一个选定的为candidates[i]，
        // 那么下一个元素只能选它自己或者在它之后的元素，不能选在它之前的，
        // 这样就可以避免重复
        for (int i = start; i < nums.length; i ++) {
            if (sum + nums[i] <= target) {
                tmp.add(nums[i]);
                sum += nums[i];

                dfs(nums, target, tmp, sum, i);

                tmp.remove(tmp.size() - 1);
                sum -= nums[i];
            }
        }
    }
}
