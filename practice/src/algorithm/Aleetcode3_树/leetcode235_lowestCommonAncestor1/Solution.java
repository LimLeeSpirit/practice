package algorithm.Aleetcode3_树.leetcode235_lowestCommonAncestor1;


import algorithm.Aleetcode3_树.TreeNode;

/**
 *  二叉搜索树的最近公共祖先，注意是二叉搜索树了。
 *
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = new TreeNode(-1);
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                ret = root;
                break; //找到了比其中一个大，比其中一个小的节点了，这个点就是最近公共祖先了，返回
            }
        }
        return ret;
    }
}
