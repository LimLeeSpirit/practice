package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode204;

import java.util.ArrayList;
import java.util.List;

/**
 * 求质因素的个数
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution {
    // 计算小于n的数里面，有多少个质数，学习下Y总的思路，但是有点没有看明白
    public int countPrimes(int n) {
        boolean[] v = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n; i ++) {
            if (!v[i]) primes.add(i);
            for (int j = 0; i * primes.get(j) < n; j ++) {
                v[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) break;
            }
        }
        return primes.size();
    }
}
