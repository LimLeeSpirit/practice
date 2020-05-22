package algorithm.Aleetcode3_树.leetcode111_树_minDepth;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  树的最小深度，最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *  叶子节点是指没有子节点的节点
 *
 *  同样，BFS 或者 递归
 *
 *  递归做法和数的最大深度有点区别。叶子节点是没有子节点的节点，关键就是叶子节点的理解
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int ret = Integer.MAX_VALUE;
        if (root.left != null) ret = Math.min(ret, minDepth(root.left) + 1);
        if (root.right != null) ret = Math.min(ret, minDepth(root.right) + 1);
        if (ret == Integer.MAX_VALUE) return 1;
        return ret;
    }

    // 用 BFS 做的，如果遍历到某一层的时候，某个节点是叶子节点，没有子节点了，就返回结果。
    public int minDepth2(TreeNode root) {
        if (root == null) { return 0;}
        int ret = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return ret;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret ++;
        }
        return 0;
    }
}