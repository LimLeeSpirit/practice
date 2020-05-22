package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode721;

import java.util.*;

/**
 * 合并邮箱账户
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，
 * 其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 *              ["John", "johnnybravo@mail.com"],
 *              ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 *              ["Mary", "mary@mail.com"]]
 *
 *
 * 如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。
 *
 * 即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
 *
 * 一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 *
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。
 *                           accounts 本身可以以任意顺序返回
 *
 */

/**
 * 第三遍终于自己写出来了，虽然中间思路忘了些，但是想一想还是可以完整写出来的，甚至debug哈哈
 * 并查集的题 200、547、684、721写个博客
 *
 * 这个题的思路：
 * 1、将n个账户放入并查集中，n个账户各成一类，令其种类信息分别为自己的下标
 *
 * 2、获取 email 对应的 种类信息，并将 email 相同的种类信息合并
 *
 * 3、获取到 emial2index 后，获取每个种类类别与对应的邮箱index2emails，所以选用set存储，又考虑到需要将邮箱字典序存放，所以用TreeSet保存邮箱
 *    TreeSet在Java中是由红黑树实现的高效搜索树
 *
 * 4、将 index2email 转化为 name2emial 的格式进行保存，最后需要返回 name 和 邮箱的形式
 *
 * 5、这里最开始先获取index 和 emails 的形式是因为要利用并查集的方式合并相同邮箱到一个账户下标。
 */
public class Solution3 {
    int n;
    int[] root;
    private int find(int x) {
        if (root[x] != x) root[x] = find(root[x]);
        return root[x];
    }

    public List<List<String>> accountsMerge(List<List<String>> a) {
        List<List<String>> ret = new ArrayList<>();

        n = a.size();

        root = new int[n];
        // 初始化 root
        for (int i = 0; i < n; i ++) root[i] = i;

        Map<String, Integer> email2index = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < a.get(i).size(); j ++) {
                String email = a.get(i).get(j);
                if (email2index.containsKey(email)) {
                    int k = email2index.get(email);
                    // 这里容易错，邮箱合并到一个种类的时候，是把种类信息进行更改
                    root[find(i)] = find(k);
                } else {
                    email2index.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> index2emails = new TreeMap<>();
        for (int i = 0; i < n; i ++) {
            int parent = find(i);
            index2emails.putIfAbsent(parent, new TreeSet<String>());

            List<String> emails = a.get(i);

            index2emails.get(parent).addAll(emails.subList(1, emails.size()));
        }

        for (Integer idx : index2emails.keySet()) {
            String name = a.get(idx).get(0);
            List<String> account = new ArrayList<>(index2emails.get(idx));
            account.add(0, name);
            ret.add(account);
        }

        return ret;
    }
}
