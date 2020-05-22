package algorithm.Aleetcode3_树.leetcode173;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.LinkedList;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 也就是第一次调用next的时候返回中序遍历的第一个值，第二次调用的时候返回中序遍历的第二个值，。。。。
 * 所以不能使用中序遍历的值存下来，那样空间超过了。
 * 那么可以使用迭代的方式来做中序遍历，就是把中序遍历 94题 代码进行拆分一下，就得到这个迭代器。
 *
 * 面对这类题，思路一定要清晰，想清楚和平时做过的题有什么联系。
 */
public class BSTIterator {
    LinkedList<TreeNode> stk = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stk.pop();
        int val = p.val;

        p = p.right;

        while (p != null) {
            stk.push(p);
            p = p.left;
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
