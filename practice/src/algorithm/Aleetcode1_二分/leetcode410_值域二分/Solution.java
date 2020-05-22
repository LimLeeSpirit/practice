package algorithm.Aleetcode1_二分.leetcode410_值域二分;

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的 连续 子数组。注意是 连续的子数组
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。并求出这个最大值
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为 18，在所有情况中最小。
 *
 * 又是一道可以利用二分思想的题：  其实是用的二分逼近！！！！
 * 子数组的最大值的范围：在区间 [max(nums), sum(nums)] 之中。
 *
 * 计算数组和值不大于 mid 的子数组个数 cnt
 *
 * 如果 cnt > m，说明划分的子数组多了，即我们找到的 mid 偏小，故 l = mid+1；
 * 否则，说明划分的子数组少了，即 mid 偏大(或者正好就是目标值)，故 r = mid。
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        long l = (long)nums[0];
        long r = 0;
        for (int a : nums) {
            r += a;
            l = Math.max(l, a);
        }

        while (l < r) {
            long mid = l + r >> 1;
            long tmp = 0;
            int count = 1;

            // 遍历数组，看能得到多少个 和值 不大于 mid 的数组
            // 这个写法也很不错
            for (int b : nums) {
                tmp += b;
                if (tmp > mid) {
                    tmp = b;
                    count ++;
                }
            }

            // 个数多了，说明 mid 太小
            if (count > m) l = mid + 1;
            // 个数少了，说明 mid 太大。
            else if (count <= m) r = mid;
        }
        return (int)l;
    }

    public static void main(String[] args) {
        // 计算一个数组，可以被划分为多少个连续的子数组，且和都不大于某个值。
        int[] nums = {7, 2, 5, 3, 6, 4};
        int cnt = 1;
        int tmp = 0;
        for (int a : nums) {
            tmp += a;
            if (tmp > 9) {
                cnt ++;
                tmp = a;
            }
        }
        System.out.println(cnt);
    }
}
