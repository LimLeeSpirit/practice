package algorithm.Aleetcode5_DFS和回溯.leetcode51;

import java.util.*;

/**
 * N-queue，给定数字n，求出该数字的 n-queue 的解法。
 *
 * 写博客。两个注意点：
 * 1、new ArrayList<>(curRes)
 * 2、List<List<Integer>> 在内层循环的时候，为什么会被显示为Object？哈哈哈哈解决了！
 */

class Solution {
    private  Set<Integer> col = new HashSet<>();
    private  Set<Integer> pie = new HashSet<>();
    private  Set<Integer> na = new HashSet<>();
    List<List<Integer>> lists;

    /**
     * 这里的思路是先将所有的Q所在的下标索引找出来，最后再根据每一个下标索引生成字符串。
     * 即先求出这样的list：[[1302],[2031]]
     */
    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();

        List<List<String>> ret = new ArrayList<>();

        dfs(n, 0, new ArrayList<Integer>());

        for (List<Integer> a: lists) {
            List<String> cur = new ArrayList<>();
            for(int b: a) {
                char[] curChar = new char[n];
                Arrays.fill(curChar,'.');
                curChar[b] = 'Q';
                cur.add(new String(curChar));
            }
            ret.add(cur);
        }
        return ret;
    }

    /**
     *
     * @param n n 行
     * @param row 当前深度搜索到第row行
     * @param tmp 当前行的临时结果
     */
    public void dfs(int n, int row, ArrayList<Integer> tmp) {
        if (row == n) {
            lists.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < n; i ++) {
            // 对该行，所有的列遍历
            if (col.contains(i) || pie.contains(i+row) || na.contains(i-row)) { continue; }

            // 符合条件：继续走
            col.add(i);
            pie.add(i+row);
            na.add(i-row);
            tmp.add(i);

            dfs(n, row + 1, tmp);

            // 回到上一层，修正
            tmp.remove(tmp.size()-1);
            col.remove(i);
            pie.remove(i+row);
            na.remove(i-row);
        }
    }
}
