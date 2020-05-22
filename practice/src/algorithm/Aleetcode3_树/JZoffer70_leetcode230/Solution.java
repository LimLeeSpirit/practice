package algorithm.Aleetcode3_树.JZoffer70_leetcode230;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中的第 k 小的结点。
 *
 * 你可以假设树和k都存在，并且1≤k≤树的总结点数。
 *
 * 中序遍历的第k个节点
 */
public class Solution {
    // 笨办法
    List<TreeNode> l = new ArrayList<>();

    public TreeNode kthNode(TreeNode root, int k) {
        dfs(root);

        return l.get(k - 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        l.add(root);
        dfs(root.right);
    }
}
