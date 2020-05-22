package algorithm.Aleetcode3_树.leetcode113_树_pathSum2;


import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 路径总和I 112、   路径总和III437
 *
 * 路径总和113
 * 给定一个二叉树和一个目标和，找到所有从 根节点 到 叶子节点 路径总和等于给定目标和的路径。
 *
 * 思路和112一样，只不过要记录一下路径
 */
public class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<>();
        dfs(root, new ArrayList<Integer>(), sum, 0);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> tmp, int sum, int cnt) {
        if (root == null) return;
        cnt += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null && cnt == sum) ret.add(new ArrayList<>(tmp));
        dfs(root.left, tmp, sum, cnt);
        dfs(root.right, tmp, sum, cnt);
        // 由于不会再返回去所以不用写下面一句
        cnt -= root.val;
        // 但是这句必须写
        tmp.remove(tmp.size() - 1);
    }
}