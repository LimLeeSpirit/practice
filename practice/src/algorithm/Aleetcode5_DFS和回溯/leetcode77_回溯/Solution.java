package algorithm.Aleetcode5_DFS和回溯.leetcode77_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *  输入: n = 4, k = 2
 *  输出:
 *  [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *  ]
 *
 *  仍然是用DFS，和46、47、78、90有一拼。
 *
 *  start 从 1 开始，一直到 n
 */
class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combine(int n, int k) {
        ret = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<Integer>());
        return ret;
    }

    private void dfs(int n, int k, int start, List<Integer> tmp) {
        if (tmp.size() == k) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < n + 1; i ++) {
            tmp.add(i);
            dfs(n, k, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

