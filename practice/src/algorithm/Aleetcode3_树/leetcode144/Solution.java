package algorithm.Aleetcode3_树.leetcode144;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树的前序遍历，非递归写法，和中序遍历的思路一致，
 *  因为前序和中序的差别仅仅是第一次读根节点还是第二次读根节点的区别
 *
 *  前序：144  根 左 右
 *  中序：94
 *  后续：145
 */

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stk = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stk.isEmpty()) {
            while (p != null) {

                list.add(p.val); // 前序

                stk.push(p);
                p = p.left;
            }

            p = stk.pop();
            // list.add(p.val) 中序
            p = p.right;
        }

        return list;
    }

}


