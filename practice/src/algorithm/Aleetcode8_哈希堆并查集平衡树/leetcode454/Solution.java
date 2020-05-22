package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode454;

import java.util.HashMap;
import java.util.Map;

/**
 *  四个长度相同的列表，分别找出一个元素使之和为 0，这样的组合有多少个。
 *  输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 *  解法：依然是用映射，四个化为 2 个。 解法牛逼！
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length, ret = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++) {
                map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0) + 1);
            }
        }
        for (int k = 0; k < len; k ++) {
            for (int z = 0; z < len; z ++) {
                int val = -(C[k] + D[z]);
                ret += map.getOrDefault(val, 0);
                /**
                if (map.containsKey(val)) {
                    ret += map.get(val);
                }*/
            }
        }
        return ret;
    }
}
