package algorithm.Aleetcode3_树.JZoffer44;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 *     8
 *    / \
 *   12  2
 *      /
 *     6
 *    /
 *   4
 *
 * 输出：[[8], [12, 2], [6], [4]]
 *
 * 其实就是二叉树的层次遍历的延伸
 */
public class Solution {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) return ret;
        q.offer(root);
        while (q.size() > 0) {
            int len = q.size();
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < len; i ++) {
                TreeNode p = q.poll();
                tmp.add(p.val);
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }
            ret.add(tmp);
        }
        return ret;
    }
}
