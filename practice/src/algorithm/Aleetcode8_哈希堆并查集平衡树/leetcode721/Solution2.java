package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode721;

import java.util.*;

/**
 * 这个题：合并账户。有以下几点需要学习
 * 1、并查集的概念、使用场景
 * 2、ArrayList的初始化方法       List<String> account2 = Arrays.asList("John", "johnnybravo@mail.com");
 * 3、对字符串可变数组进行排序：使用 TreeSet 这一数据结构
 */
class Solution2 {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // map from each email to the userId
        UnionFind uf = new UnionFind(accounts.size());

        // 因为邮箱是唯一的，可以用来当作 key
        Map<String, Integer> email2userId = new HashMap<>();

        // find and union emails
        // 主要是用来生成 uf 森林，分别找出用户下标的根节点，也就是谁和谁是一颗树
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (email2userId.containsKey(email)) {
                    uf.union(email2userId.get(email), i);
                } else {
                    email2userId.put(email, i);
                }
            }
        }
        // 获取所有用户id对应的邮箱,为什么用 TreeSet 呢，是因为 TreeSet 是有序集合，排序是用树结构完成的（红黑树）
        // 这里只是获取了id与对应的邮箱，要转化为 name 和对应的邮箱
        Map<Integer, TreeSet<String>> userId2emails = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int parent = uf.find(i);
            List<String> emails = accounts.get(i);
            userId2emails.putIfAbsent(parent, new TreeSet<String>());
            userId2emails.get(parent).addAll(emails.subList(1, emails.size()));
        }

        // 将 userId2emails 转化为 name2emails
        List<List<String>> name2emails = new ArrayList<>();
        for (Integer idx : userId2emails.keySet()) {
            String name = accounts.get(idx).get(0);
            List<String> emails = new ArrayList<>(userId2emails.get(idx));
            // 将 name 添加到第一个位置处
            emails.add(0, name);
            name2emails.add(emails);
        }
        return name2emails;
    }

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();

        List<String> account1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> account2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> account3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> account4 = Arrays.asList("Mary", "mary@mail.com");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        List<List<String>> name2emails = accountsMerge(accounts);
        for (List<String> a : name2emails) {
            for (String b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 并查集的数据结构，帮派识别、组织结构识别
 * @roots 根节点
 * @ranks 该节点所在树的深度
 */
class UnionFind {
    int[] roots;
    int[] ranks;

    // 初始化，数组的每个元素的
    UnionFind(int n) {
        roots = new int[n]; // 初始跟节点为自己
        ranks = new int[n]; // 默认全是0
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    // 找到节点 i 的根节点
    int find(int i) {
        if (roots[i] != i) {
            roots[i] = find(roots[i]);
        }
        return roots[i];
    }

    // 合并节点 i 和 j
    void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        // 本来就是一个组织的，根节点相同
        if (rootI == rootJ) return;

        if (ranks[rootI] > ranks[rootJ]) {
            roots[rootJ] = rootI;
        } else if (ranks[rootI] < ranks[rootJ]) {
            roots[rootI] = rootJ;
            // 根节点所在树的深度都相同，把 rootJ 下挂到 rootI 下面，rootI所在树深度+1
        } else {
            roots[rootJ] = rootI;
            ranks[rootI]++;
        }
    }

    // 判断两个节点是否在同一个树中
    boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}
