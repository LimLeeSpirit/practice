package algorithm.Aleetcode5_DFS和回溯.leetcode217;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 枚举所有的所有可能情况，将满足条件的放入结果中
 *
 * 依次枚举每个数 从哪个位置上选
 *
 * dfs的参数：当前枚举到了第几个数字，下一次开始枚举的位置，当前选择的数的和
 */
class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ret = new ArrayList<List<Integer>>();
        dfs(k, 1, n, new ArrayList<Integer>());
        return ret;
    }

    /**
     * 因为候选元素是从 1-n，而且枚举过程是往后一直走的，所以需要 k 记录还剩多少元素，next下次枚举的起始下标，n 和 tmp
     * @param k 还需要枚举的数目
     * @param u 下一个枚举的起始值
     * @param n 当前数组的和
     * @param tmp 当前数组
     */
    private void dfs(int k, int next, int n, ArrayList<Integer> tmp) {
        if (k == 0 && n == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        // 优化一下：在[i, 9]区间里一定要至少有 k 个数才有机会成为结果 9 - i + 1>= k,所以 10 - k >= i
        for (int i = next; i <= 10 - k; i ++) {
            tmp.add(i);
            dfs(k - 1, i + 1, n - i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
