package algorithm.Aleetcode3_树.leetcode236_lowestCommonAncestor2;

import algorithm.Aleetcode3_树.TreeNode;

/**
 *  二叉树的两个节点的最近公共父节点
 *  递归得对左右子树进行查找p或q
 *
 *  如果左子树得查找结果为空，即在左子树没有找到p或q，则右子树存在三种情况：
 *      1、右子树也没找到，则在左右子树都没有，则返回 null
 *      2、右子树有p或q，则返回存在的p或q
 *      3、右子树都有，都返回右子树的根节点
 *
 *      所以在左子树返回结果为空的时候，不管右边是什么情况，返回值都是右边的返回值，
 *      同理在右子树返回结果为空的时候，不管左边什么情况，返回值就是左边的情况
 *
 *      如果左边右边都不空，则说明左边右边各查找到了一个，故返回root
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}


