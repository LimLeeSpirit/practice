package algorithm.Aleetcode3_树.leetcode108;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 思路很简单，自己最开始也想到了，找到中点，就是根结点，然后递归在其左右找到左右子树
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    public TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + r >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }
}
