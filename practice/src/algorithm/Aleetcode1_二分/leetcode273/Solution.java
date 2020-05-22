package algorithm.Aleetcode1_二分.leetcode273;

/**
 * 题目原意为从一连串11111100000000中找到第一个0的下标
 * 直接利用模版1就成了
 *
 * ?? 题号写错了 ？？？
 */
public class Solution {
    public int firstBadVersion(int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
