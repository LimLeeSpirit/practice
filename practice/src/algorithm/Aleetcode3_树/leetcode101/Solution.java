package algorithm.Aleetcode3_树.leetcode101;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.LinkedList;

/**
 *  给定一个二叉树，检查它是否是镜像对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3  是镜像对称的，
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3  就不是镜像对称的
 *
 *
 *    无法用102题的层次遍历的方法BFS来做，因为要满足左右对称必须使用递归来做，将一颗树划分为左右子树，然后再划分
 *
 *    1 两个子树的跟节点值要想等
 *    2 左边的左子树和右边的右子树要对称
 *    3 左边的右子树和右边的左子树要对称
 */

public class Solution {
    // 递归写法,哈哈哈第三遍自己写出来了
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) return true;
        if (p1 != null && p2 == null) return false;
        if (p1 == null && p2 != null) return false;
        if (p1.val != p2.val) return false;
        return dfs(p1.left, p2.right) && dfs(p1.right, p2.left);
    }

    // 非递归写法
    // 左边子树用 左 中 右 的顺序遍历；右边子树用 右 中 左 的顺序遍历，好聪明啊
    public boolean isSymmetric2(TreeNode root) {
        if (root== null) return true;
        LinkedList<TreeNode> left = new LinkedList<>();
        LinkedList<TreeNode> right = new LinkedList<>();

        TreeNode l = root.left;
        TreeNode r = root.right;
        while (l!=null || r!=null || !left.isEmpty() || !right.isEmpty()) {
            while (l!=null && r!=null) {
                left.push(l);
                l = l.left;

                right.push(r);
                r = r.right;
            }

            if (l!=null || r!=null) return false;
            l = left.pop();
            r = right.pop();

            if (l.val != r.val) return false;
            l = l.right;
            r = r.left;
        }
        return true;
    }

}


