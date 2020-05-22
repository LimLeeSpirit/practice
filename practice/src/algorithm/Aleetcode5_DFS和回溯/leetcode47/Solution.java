package algorithm.Aleetcode5_DFS和回溯.leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定有重复元素的数组，返回全排列的组合的数组，要求不重复
 *
 * 这里和 46题 的区别就是数组中有重复元素，需要去重，难点也就在这！！！实在是难以想到
 *
 * 依然是回溯、递归。
 * 使用类似解法的还有：40. 组合总和 II    46. 全排列     47. 全排列 II      78. 子集      90. 子集 II
 *
 * 仍然使用的第一个搜索顺序：枚举 每个位置该放哪个数字，加入了判重
 */
class Solution {
    List<List<Integer>> ret;
    int n;
    int[] v;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        ret = new ArrayList<>();
        v = new int[n];

        dfs(nums, new ArrayList<Integer>());

        return ret;
    }

    private void dfs(int[] nums, ArrayList<Integer> tmp) {
        if (tmp.size() == n)  {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < n; i ++) {
            // 判断用过没有 + 去重，如果前面一个数字没用，但是和现在这个数字相等了，那就跳过
            // 这里的去重，真的是大有学问，跟着Y总学了之后，才发现原来这个语句的原理。
            // 比如序列 1 1 2 2 3，为了不重复，对于 1 来说，前后两个1需要保持相对静止，也就是说第一个1
            //一定要在第二个1的前面，不能在用第二个1的时候，第一个1还没用。
            if (v[i] == 1 || (i > 0 && v[i - 1] == 0 && nums[i - 1] == nums[i])) {
                continue;
            }

            v[i] = 1;
            tmp.add(nums[i]);

            dfs(nums, tmp);

            v[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}

