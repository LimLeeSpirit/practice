package algorithm.Aleetcode1_二分.leetcode275;

/**
 * H 指数 II
 * 这个题比较绕，目的是求一个有序数组中，至少 h 个数都大于等于 h，这个 h 就是 H 指数
 * 比如：
 * [0, 1, 3, 5, 6]，由于后三个值都大于等有3，故h指数为3
 *
 * [0, 1, 4, 5, 6]，后三个值也都大于等于3， 故h指数也为3
 *
 * [0, 1, 5, 6, 7, 8]，后四个数也都大于等4，故h指数为4
 *
 * 有点难想
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        // 找满足规律的最大值：至少 h 个数大于等于 h，所以使用的模版1
        int l=0, r = citations.length;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            // 满足条件，开始的第一个数大于等于mid，[l, r]->[mid, r]
            if (citations[ citations.length - mid] >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
