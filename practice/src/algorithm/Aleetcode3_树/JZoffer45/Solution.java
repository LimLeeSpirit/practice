package algorithm.Aleetcode3_树.JZoffer45;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 *
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 其实就是 44 题的延伸，相对简单；头条一面
 */
public class Solution {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) return ret;
        q.offer(root);
        int flag = -1;
        while (q.size() > 0) {
            int len = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i ++) {
                TreeNode p = q.poll();
                tmp.add(p.val);
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }

            if (flag > 0) Collections.reverse(tmp);

            ret.add(tmp);

            flag *= (-1);
        }
        return ret;
    }
}
