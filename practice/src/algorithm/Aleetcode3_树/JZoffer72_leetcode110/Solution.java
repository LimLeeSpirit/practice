package algorithm.Aleetcode3_树.JZoffer72_leetcode110;


import algorithm.Aleetcode3_树.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 所以在针对某个节点求最大深度的时候，需要先判断其左子树的最大深度 和 右子树的最大深度之差，来看是不是满足平衡
 */
public class Solution {
    boolean ret = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ret;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) ret = false;
        return Math.max(left, right) + 1;
    }
}
