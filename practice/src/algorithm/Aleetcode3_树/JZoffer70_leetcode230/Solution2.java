package algorithm.Aleetcode3_树.JZoffer70_leetcode230;

import algorithm.Aleetcode3_树.TreeNode;

/**
 * 剪枝，只需要使用 dfs 遍历到第 k 个就行了，后面的不用再遍历了。
 */
public class Solution2 {
    TreeNode ret;
    int c;

    public TreeNode kthNode(TreeNode root, int k) {
        c = k;
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        c --;
        if (c == 0) {
            ret = root;
            return; // 找到了就结束递归
        }

        if (c > 0 ) dfs(root.right);
    }
}
