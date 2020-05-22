package algorithm.Aleetcode3_树.leetcode297;

import algorithm.Aleetcode3_树.TreeNode;

/**
 *  序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 *  进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 *  采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 */

public class Codec {
    int u = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs1(root, str);
        return str.toString();
    }

    private void  dfs1(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append('#').append(',');
            return;
        }

        str.append(root.val).append(',');

        dfs1(root.left, str);
        dfs1(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        char[] chars = data.toCharArray();

        return dfs2(chars);
    }
    private TreeNode dfs2(char[] chars) {
        if (u >= chars.length) return null;

        if (chars[u] == '#') {
            u ++;
            return null;
        }

        int t = 0;
        boolean minus = false;
        if (u < chars.length && chars[u] == '-') {
            minus = true;
            u ++;
        }

        while (u < chars.length && chars[u] != ',') {
            t = t * 10 + chars[u]-'0';
            u ++;
        }
        u ++;

        if (minus) {
            t = -t;
        }

        TreeNode root = new TreeNode(t);
        root.left = dfs2(chars);
        root.right = dfs2(chars);

        return root;
    }
}


