package algorithm.Aleetcode3_树.leetcode124;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42 = 15+20+7
 *
 *  可以借用543题的思路最大直径 = 左子树的最大深度 + 右子树的最大深度
 *  枚举每个最高点，以最高点为最高点的路径的权值路径是多少
 */
public class Solution {
    // 保存结果
    private int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // 返回从node往下走的最大值
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDep = dfs(node.left);
        int rightDep = dfs(node.right);
        // 更新结果 max,要加上本节点的权重
        max = Math.max(max, leftDep + rightDep + node.val);

        // 返回的是单边的最长路径，难题不愧为难题，思路必修完全清晰才行，如果本节点的权重之和是一个负数，对于它的
        // 父节点来说，还不如不经过这个节点，直接返回 0
        return Math.max(0, Math.max(leftDep, rightDep) + node.val);
    }
}
