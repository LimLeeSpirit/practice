package algorithm.Aleetcode3_树.JZoffer19;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 给定二叉树和 其中一个节点，找出这个节点的后继节点
 *
 * 后继节点：一个节点的后继节点是 树的中序遍历的后面那个节点
 *
 * 又是考察中序遍历的熟练度，前-根-右
 *
 * 时间复杂度O（h），因为网上找的时候最多走树的高度
 *
 * 这种题需要给出节点的父指针
 */
public class Solution {
    public TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        // 如果p有右子树，则找他的右子树的最左边的那个点
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }

        // 否则，p没有右子树：
        // (1)如果 p 是左孩子 且 有父节点，则其后继节点就是父节点；
        // (2)若是右孩子，则往上找，找到 是左孩子的节点，返回其父节点
        while (p.father != null && p == p.father.right) {
            p = p.father;
        }
        return p.father;
    }
}
