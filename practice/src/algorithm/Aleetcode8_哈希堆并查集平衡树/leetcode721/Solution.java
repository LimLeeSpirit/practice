package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode721;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 */
public class Solution {
    /**
     * 笨办法，这题原来是考察并查集
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<>();
        Set<String> names = new HashSet<>();
        for (List<String> a : accounts) {
            if (!names.contains(a.get(0))) {
                ret.add(a);
                names.add(a.get(0));
            } else {
                boolean findFlag = false;
                for (List<String> b : ret) {
                    if (b.get(0).equals(a.get(0))) {
                        // 判断邮箱是否有相同的，有，则将交集替换到 b 的后面账户；没有，continue
                        findFlag = true;
                    }
                }
                if (!findFlag) {
                    ret.add(a);
                }
            }
        }
        return ret;
    }
}
