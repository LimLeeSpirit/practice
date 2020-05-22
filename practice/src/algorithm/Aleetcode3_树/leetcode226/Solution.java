package algorithm.Aleetcode3_树.leetcode226;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 翻转一棵二叉树。镜像二叉树
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 从上往下一层一层的反转，对于每个节点，交换其左右两个子节点的值
 *
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode p) {
        TreeNode tmp = p.left;
        p.left = p.right;
        p.right = tmp;
    }
}
