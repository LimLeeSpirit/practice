package algorithm.Aleetcode3_树.leetcode297;

import algorithm.Aleetcode3_树.TreeNode;

class JZoffer50 {

    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs1(root, sb);
        return sb.toString();
    }

    private void dfs1(TreeNode p, StringBuilder sb) {
        if (p == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(p.val).append(',');
        dfs1(p.left, sb);
        dfs1(p.right, sb);
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        char[] chars = data.toCharArray();
        int u = 0;
        return dfs2(chars, u);
    }

    private TreeNode dfs2(char[] chars, int u) {
        if (u == chars.length) return null;
        int k = u;
        while (chars[k] != ',') k ++;

        if (chars[u] == '#') {
            u = k + 1;
            return null;
        }

        int val = 0;
        for (int i = u; i < k; i ++) {
            val = val * 10 + (chars[i] - '0');
        }
        u = k + 1;
        TreeNode root = new TreeNode(val);
        root.left = dfs2(chars, u);
        root.right = dfs2(chars, u);
        return root;
    }
}

