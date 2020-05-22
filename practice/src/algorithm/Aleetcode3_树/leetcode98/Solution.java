package algorithm.Aleetcode3_树.leetcode98;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  判断一棵树是否是 二叉搜索数
 *  BST 的特点：左孩子 < 父节点 < 右子节点
 *
 *  严格大于和小于，没有相等的情况
 */

public class Solution {
    public boolean isValidBST(TreeNode root) {
        // 递归写法，直接根据BST的特点进行处理，牛逼！
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return helper(root, min, max);
    }

    // 从上到下，缩小区间，精简！
    public boolean helper (TreeNode root, long Min, long Max) {
        if (root == null) {
            return true;
        }
        long value = root.val;
        return (root.val > Min &&
                root.val < Max &&
                helper(root.left, Min, value) &&
                helper(root.right, value, Max));
    }

    public boolean isValidBST2(TreeNode root) {
        // 中序遍历，获得一个升序数组，那么就是BST,   居然超出了空间复杂度！
        List<Integer> checked = new ArrayList<>();
        inOrder(root, checked);
        for (int i=1; i<checked.size(); i++) {
            if (checked.get(i) <= checked.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        while (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}


