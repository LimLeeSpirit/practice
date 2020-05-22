package algorithm.Aleetcode5_DFS和回溯.leetcode22_递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成有效的匹配符号
 *
 * 这里是递归，不是回溯
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        dfs(ret, "", 0, 0, n);
        return ret;
    }

    private void dfs(List<String> ret, String s, int left, int right, int n) {
        if (right == n && left == n) {
            ret.add(s);
            return;
        }

        if (left < n) {
            dfs(ret, s + '(', left + 1, right, n);
        }

        if (right < left && right < n) {
            dfs(ret, s + ')', left, right + 1, n);
        }
    }
}
