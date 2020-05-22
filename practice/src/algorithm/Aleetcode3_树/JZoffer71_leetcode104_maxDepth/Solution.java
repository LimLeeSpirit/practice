package algorithm.Aleetcode3_树.JZoffer71_leetcode104_maxDepth;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  求树的最大深度,二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 *  法1：就是求二叉树有多少层
 *  1、BFS一层一层地扫
 *  2、或者对每个节点进行左右子树的高度判断，返回最长的
 *
 *  法2：利用递归，找出左右子树的最大深度的较大值，然后 + 1
 */
public class Solution {
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret ++;
        }
        return ret;
    }
}