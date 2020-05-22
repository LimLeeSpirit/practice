package algorithm.Aleetcode5_DFS和回溯.leetcode78;

import java.util.ArrayList;
import java.util.List;

// 求子集，循环做法

public class Solution2 {
    /**
     * 利用二进制的思路来做，我最开始也想到过，但是就是没有想到最好的方式获取二进制中 1 的下标位置
     *
     * 都使用到了二进制，怎么就没想到位运算？利用 j >> k & 1 == 1 ？ 就可以得到第 k 位 是不是 1
     *
     * 之前不是求过一个整数的二进制位有多少个 1 这种题吗？哈哈，可以，很牛逼
     *
     * 注意一下位运算的优先级问题：
     * 1    + - * / !
     * 2    << >>
     * 3    > < <= >=
     * 4    == !=
     * 5     & | ^
     * @param nums nums
     * @return list
     */
    public  static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());

        for (int i = 1; i < 1 << n; i ++) {
            List<Integer> tmp = new ArrayList<>();
            int j = i;
            for (int k = 0; k < n; k ++) {
                if ((j >> k & 1) == 1) {
                    tmp.add(nums[n - k - 1]);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
