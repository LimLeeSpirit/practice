package algorithm.Aleetcode3_树.leetcode105;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  根据一棵树的前序遍历与中序遍历构造二叉树。你可以假设树中没有重复的元素。
 *
 *  前序遍历 preorder = [3,9,20,15,7]
 *  中序遍历 inorder = [9,3,15,20,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    想一下如何通过前序遍历、中序遍历得到一颗树
 *    1、先在前序遍历中第一个点，就是整颗树的根节点
 *    2、在中序遍历中找到根节点的位置，和其下标
 *    3、中序遍历中根结点的左边就是左子树的节点，右边就是根节点的右子树所有节点，所有先构建根结点，再找其左右子节点
 *    4、构造根节点，递归的在左子树节点中、和右子树节点 来 构建子树
 *
 *    需要画个图，方便一点，想不起来就去b站看讲解
 *
 */

public class Solution {
    Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        // 为了快速在中序遍历里找到根结点的位置，用hash来存储中序遍历的节点和其位置，让查找速度达到O（1）
        for (int i = 0; i < n; i ++) pos.put(inorder[i], i);

        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        int val = preorder[pl];
        int k = pos.get(val);

        // 左子树节点的长度
        int len = k - il;

        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, inorder, pl + 1, pl + len, il, k - 1);
        root.right = dfs(preorder, inorder, pl + len + 1, pr, k + 1, ir);
        return root;
    }

}


