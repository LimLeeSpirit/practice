package algorithm.Aleetcode3_树.leetcode112_树_pathSum1;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 路径总和III 437、   路径总和 113
 *
 * 路径总和I 112
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 *
 * 这个题用一个变量往下走，不需要回溯，不需要恢复上一层。
 * 如果当前节点是叶子节点且sum = 最后剩下的一点，则找到了这样的路径。返回true
 *
 *
 */
public class Solution {
    boolean ret = false;
    // 这个写法和 路径和II_113 的思路一样
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        dfs(root, sum, 0);
        return ret;
    }

    private void dfs(TreeNode root, int sum, int cnt) {
        if (root == null) return;
        cnt += root.val;
        if (root.left == null && root.right == null && cnt == sum) {
            ret = true;
            return;
        }
        dfs(root.left, sum, cnt);
        dfs(root.right, sum, cnt);
        // 由于不是回溯，不会再返回去所以不用写下面一句
        cnt -= root.val;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        if (root.left != null && hasPathSum(root.left, sum - root.val)) return true;
        if (root.right != null && hasPathSum(root.right, sum - root.val)) return true;
        return false;
    }
}


