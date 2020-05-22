package algorithm.Aleetcode3_树.JZoffer46;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *
 * 如果是则返回true，否则返回false。
 *
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 样例
 *
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 *
 * 输出：true
 *
 * 这个题针对二叉搜索树的性质 和 后续遍历进行考察，Y总思路真的太好了！简直加深了我对后续遍历的理解
 * 对于一颗二叉搜索树的后续遍历
 *
 * 左子树    右子树   根
 *
 * 最后一个节点必定是根，根前面所以大于它的都是它的右子树， 前面小于它的都是它的左子树。
 * 利用： 根的左子树节点值都小于 根， 根的右子树值都大于 根
 */
public class Solution {
    int[] seq;
    public boolean verifySequenceOfBST(int [] sequence) {
        seq = sequence;
        return dfs(0, seq.length - 1);
    }

    private boolean dfs(int l, int r) {
        if (l >= r) return true;
        int root = seq[r];
        // k 为右子树开始节点
        int k = l;
        while (k < r && seq[k] < root) k ++;
        for (int i = k; i < r; i ++) {
            if (seq[i] < root) return false;
        }
        return dfs(l, k - 1) && dfs(k, r - 1);
    }
}
