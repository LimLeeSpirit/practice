package algorithm.Aleetcode3_树.leetcode257_path4;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 */
public class Solution {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        // 这里又遇到一个不能使用StringBuilder的情况！！！！！！只能使用String
        dfs(root, "");
        return ans;
    }
    // 因为是从根结点往下走，所以深搜，没有回溯
    private void dfs(TreeNode p, String tmp) {
        if (p != null) {
            tmp += String.valueOf(p.val);
            if (p.left == null && p.right == null) ans.add(tmp);
            else {
                tmp += "->";
                dfs(p.left, tmp);
                dfs(p.right, tmp);

            }
        }
    }
}
