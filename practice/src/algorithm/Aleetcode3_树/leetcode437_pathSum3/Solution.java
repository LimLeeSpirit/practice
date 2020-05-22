package algorithm.Aleetcode3_树.leetcode437_pathSum3;

import algorithm.Aleetcode3_树.TreeNode;

/**
 *
 * 路径总和III437
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 *
 * 这几个路径和的问题简直经典，特别是这个不规定路径必须是从根节点到叶子节点，
 * 所以对每个节点，都要进行一次完整的查找，把该节点当作是新的一棵树的根节点
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        // 根结点的查找结果
        int ret = dfs(root, sum);

        // 左右子树是新的树 注意这里，很容易写错，
        // 其实是容易想错，对于每个子树，都要从该子树根节点出发去遍历路径，所以有多少个节点，就有多少个子树
        ret += pathSum(root.left, sum);
        ret += pathSum(root.right, sum);
        return ret;
    }
    private int dfs(TreeNode p, int sum) {
        if (p == null) return 0;
        int ret = 0;
        if (p.val == sum) ret ++;
        ret += dfs(p.left, sum - p.val);
        ret += dfs(p.right, sum - p.val);
        return ret;
    }
}
