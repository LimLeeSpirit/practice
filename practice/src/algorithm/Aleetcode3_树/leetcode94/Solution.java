package algorithm.Aleetcode3_树.leetcode94;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  给定一个二叉树，返回它的中序 遍历。递归算法很简单，你可以通过迭代算法完成吗？
 *
 *  将整棵树的 最左边 一条链压入栈中；
 *  每次取栈顶元素，如果其有右子树，则将右子树压入栈中
 */

public class Solution {
    List<Integer> list;
    // 大神给的非递归的解法，其实就是根据中序的规律来做的，非递归，那自己就得开一个栈来模拟递归，太精辟了。
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        // 手动开一个栈，模拟递归操作
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            // 将p的左子树那一条边全部加入栈
            while (p != null) {
                stack.push(p);
                // stack.addFirst(p);
                p = p.left;
            }

            // 根
            // 弹出栈顶元素
            p = stack.pop();
            list.add(p.val);

            // 右 看看p是否有右子树，有的话，进行该右子树的 下一次的左子树的添加
            p = p.right;
        }
        return list;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        // ans.add(root.val);
        inorder(root.right);
    }
}


