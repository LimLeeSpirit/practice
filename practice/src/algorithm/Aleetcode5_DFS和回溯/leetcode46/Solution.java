package algorithm.Aleetcode5_DFS和回溯.leetcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含有重复元素的数组，返回 全排列 的组合的数组，要求不重复
 *
 * 依然是回溯。
 * 使用类似解法的还有：40. 组合总和 II    46. 全排列     47. 全排列 II      78. 子集      90. 子集 II
 *
 * 这个解法是 枚举：该位置该放哪个数，下一个数该放谁，位置放完了也就返回一个完整的字符串
 *
 */
class Solution {
    List<List<Integer>> res;
    int[] visited;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        // 用来记录该位置处的元素已经被用过
        visited = new int[n];

        dfs(nums, new ArrayList<Integer>());

        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> temp) {
        // 递归终止条件
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            // process
            if (visited[i] == 0) {
                visited[i] = 1;
                temp.add(nums[i]);

                // 继续下一层
                dfs(nums, temp);

                // 回到上一层，对更改过的东西，需要改回来。
                visited[i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
    }
}

