package algorithm.Aleetcode3_树.JZoffer37;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 *
 * 我们规定空树不是任何树的子结构。
 *
 * 这个题和 leetcode 572 类似，但是 572 是求是否是子树
 *
 * 样例
 *
 * 树A：
 *
 *      8
 *     / \
 *    8   7
 *   / \
 *  9   2
 *     / \
 *    4   7
 * 树B：
 *
 *    8
 *   / \
 *  9   2
 * 返回 true ,因为B是A的子结构。
 *
 * 题解：其实和字符串的匹配思路一致，遍历 root1 的每一个节点，从该节点开始，递归地判断两个子树的结构和值
 */
public class Solution {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (isPart(root1, root2)) return true;
        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean isPart(TreeNode p1, TreeNode p2) {
        // p2 走完了，说明匹配了
        if (p2 == null) return true;
        if (p1 == null || p1.val != p2.val) return false;
        return isPart(p1.left, p2.left) && isPart(p1.right, p2.right);
    }
}
