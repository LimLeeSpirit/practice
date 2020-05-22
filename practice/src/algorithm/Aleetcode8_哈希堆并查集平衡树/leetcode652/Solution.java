package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode652;

import algorithm.Aleetcode3_树.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值
 *
 * 首先思考：
 * 1、相同的子树，要有相同的节点值和结构；
 * 2、如果唯一确定一颗树呢？之前做过二叉树的序列化和反序列化，所以直接将每个子树序列化为一个字符串，
 *    序列化的时候采用前序遍历，子节点为空的话使用'#'代替。
 *
 * 3、问题也就变成了找到重复出现过 2 次以上的字符串。
 */

/**
 * 最基本的解法，因为每个节点需要遍历一次，对每个节点进行遍历的时候需要遍历 n 个节点，所以需要O（n^2）复杂度
 * 用时 22ms
 */
class Solution1 {
    List<TreeNode> ret;
    Map<String, Integer> hash;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ret = new ArrayList<>();
        hash = new HashMap<>();

        if (root == null) return ret;

        dfs(root);

        return ret;
    }

    private String dfs(TreeNode root) {
        if (root == null) return "#";

        String l = dfs(root.left);
        String r = dfs(root.right);
        String treeSerial = String.valueOf(root.val) + "," + l + "," + r;
        hash.put(treeSerial, hash.getOrDefault(treeSerial, 0) + 1);

        if (hash.get(treeSerial) == 2) ret.add(root);

        return treeSerial;
    }
}

/**
 * 进阶解法，考虑最坏情况，一颗树是一条链的时候，对于每个子树，序列化后的字符串都是O（n）级别的，n个子树的操作代价是n方的；
 * 字符串长度太长了，考虑将得到的字符串也hash一次，将之映射为一个整形：
 *      比如对于当前子树的序列化结果 treeSerial，将之映射为整形 cnt，所以一个子树的映射结果就是最多为3个整形（根，左子树，右子树）
 *      所以两次hash之后的结果都是O（1）的，n个子树，所以就是O（n）复杂度。
 * 此思路用时 10ms
 */
public class Solution {
    // 全局递增变量，是 treeSerial 的 value
    int cnt = 0;
    List<TreeNode> ret;
    Map<String, Integer> hash;
    Map<Integer, Integer> count;

    private String dfs(TreeNode root) {
        if (root == null) return hash.get("#").toString();

        String left = dfs(root.left);
        String right = dfs(root.right);

        String treeSerial = String.valueOf(root.val) + "," + left + "," + right;

        if (!hash.containsKey(treeSerial)) hash.put(treeSerial, ++ cnt);

        int t = hash.get(treeSerial);
        count.put(t, count.getOrDefault(t, 0) + 1);

        if (count.get(t) == 2) ret.add(root);

        return String.valueOf(t);
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ret = new ArrayList<>();
        hash = new HashMap<>();
        count = new HashMap<>();
        // 空字符串的key为 1
        hash.put("#", ++ cnt);

        dfs(root);

        return ret;
    }
}
