package algorithm.Aleetcode3_树.leetcode145;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树的后序遍历，递归写法，相当简单
 *
 *  非递归写法，比较难以思考，考虑前序遍历的非递归写法，root-left-right
 *
 *  后续遍历：left-right-root
 *
 *  先遍历root-right-left，然后再将结果逆序一遍，就得到了后续遍历
 */

public class Solution {
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 这个栈用来存节点
        LinkedList<TreeNode> stk = new LinkedList<>();

        // 这个栈用来存 根-右-左顺序的结果
        LinkedList<Integer> stk2 = new LinkedList<>();

        TreeNode p = root;
        while (p != null || !stk.isEmpty()) {
            while (p != null) {
                stk2.push(p.val);
                stk.push(p);
                p = p.right;
            }
            p = stk.pop();
            p = p.left;
        }

        while (!stk2.isEmpty()) list.add(stk2.pop());

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postHelper(root, list);
        return list;
    }

    private void postHelper(TreeNode root, List<Integer> list) {
        if (root!= null) {
            postHelper(root.left, list);
            postHelper(root.right, list);
            list.add(root.val);
        }
    }
}


