package algorithm.Aleetcode3_树.leetcode102;


import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *  二叉树的层次遍历
 *  一层一层地遍历，BFS最合适了
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        // BFS 的核心，就是维护了这样一个队列，对每一层进行扫描
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> cur_level = new ArrayList<>();
            // 对本层的节点进行扫描
            int length = queue.size();
            for (int i=0; i<length; i++) {
                TreeNode node = queue.poll();
                cur_level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(cur_level);
        }
        return ret;
    }
}
