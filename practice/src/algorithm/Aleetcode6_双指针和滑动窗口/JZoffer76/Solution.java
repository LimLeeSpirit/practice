package algorithm.Aleetcode6_双指针和滑动窗口.JZoffer76;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正数s，打印出所有和为 s 的 连续正数 序列（至少含有两个数）。
 *
 * 输入：15
 *
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 又是枚举所有情况，找出满足条件的情况就行，从O（n^2）的基础解法开始优化！
 */
public class Solution {
    /**
     * 基础的O（n^2）解法
     * @param sum
     * @return
     */
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= sum / 2 + 1; i ++) {
            for (int j = i + 1; j <= sum / 2 + 1; j ++) {
                if ((i + j) * (j - i + 1) / 2 == sum) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int k = i; k <= j; k ++) {
                        tmp.add(k);
                    }
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }

    /**
     * 发现随着 i 的增加，j 也会增加，所以可以使用双指针来优化成O（n）的解法.
     * 虽然知道可以用双指针算法，但是如何维护这个双指针，代码怎么改仍然需要很大功力
     * @param sum
     * @return
     */
    public List<List<Integer> > findContinuousSequence2(int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1, j = 1, s = 1; i <= sum / 2 + 1; i ++) {
            while (s < sum) s += ++ j;
            if (sum == s && j - i > 0) {
                List<Integer> tmp = new ArrayList<>();
                for (int k = i; k <= j; k ++) tmp.add(k);
                ret.add(tmp);
            }
            // 由于 i 往后走，所以要先把 i 减去，其实有点不明白这里
            // 其实是维护一个滑动窗口，窗口内的元素加起来要保证小于等于sum，大于则要删掉左边的元素
            // j随着i的增加，而不减，所以时间 O（n）
            s -= i;
        }
        return ret;
    }
}
