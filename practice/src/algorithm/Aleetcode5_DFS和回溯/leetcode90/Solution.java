package algorithm.Aleetcode5_DFS和回溯.leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 幂集II
 *
 * 给定一组 包含重复 元素的整数数组 nums，返回该数组所有可能的子集（幂集）。要求子集不重复
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 *  使用类似解法的还有：40. 组合总和 II    46. 全排列     47. 全排列 II      78. 子集      90. 子集 II
 *
 *  这道题我能理解的就只能使用回溯法 + 判重了，每次枚举位置 count 的元素
 *  y总那种方式理解不了，java实现也通过不了
 *
 *  在函数的参数传递过程中，慎用 j ++ 和 j + 1
 *  j ++ 会将传入的 j 更改掉，j + 1会将 j + 1算出来再传入函数体内，但是j不会变
 */

public class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int count, ArrayList<Integer> temp) {
        if (count > n) return ;
        res.add(new ArrayList<>(temp));
        for(int j = count; j < n; j ++) {
            // 卧槽，我居然一步就改对了！！！！有点掌握到精髓的意思哦！！
            if (j > count && nums[j] == nums[j-1]) { continue; }
            temp.add(nums[j]);
            // 慎用 j + 1 和 j ++
            dfs(nums, j+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
