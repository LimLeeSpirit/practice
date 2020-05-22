package algorithm.Aleetcode3_树.leetcode543;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *       返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *       两结点之间的路径长度是以它们之间边的数目表示。
 *
 *       最大直径 = 左子树的最大深度 + 右子树的最大深度
 */
public class Solution {
    // 保存结果
    private int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDep = depth(node.left);
        int rightDep = depth(node.right);
        // 更新结果 max
        max = Math.max(max, leftDep + rightDep);
        // 返回的是单边的最长路径
        return Math.max(leftDep, rightDep) + 1;
    }
}
