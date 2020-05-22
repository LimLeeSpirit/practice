package algorithm.Aleetcode3_树.leetcode572;


import algorithm.Aleetcode3_树.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 *
 *  注意和剑指offer 37 子结构的区别，这个题是要 子树
 *  s 的一个子树包括 s 的一个节点和这个节点的所有子孙，而不是部分子孙
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        if (isSub(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSub(TreeNode p1, TreeNode p2) {
        // 都到了空，说明都相等了
        if (p1 == null && p2 == null) return true;
        if (p1 == null && p2 != null) return false;
        if (p1 != null && p2 == null) return false;
        if (p1.val != p2.val) return false;
        return isSub(p1.left, p2.left) && isSub(p1.right, p2.right);
    }
}
