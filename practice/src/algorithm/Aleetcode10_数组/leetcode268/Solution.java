package algorithm.Aleetcode10_数组.leetcode268;

/**
 *
 * 缺失数字
 *
 * 和 第一个缺失的整数有点联系
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 *
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0;
        for (int i = 0; i <= nums.length; i ++) {
            sum1 += i;
        }
        int sum2 = 0;
        for (int a : nums) {
            sum2 += a;
        }
        return sum1 - sum2;
    }

    // 也可以用 异或运算做
    // 相同元素异或结果为0；不同元素异或结果为1； 0与任何数异或结果均为 任何数本身。
    public int missingNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i <= nums.length; i ++) {
            ans ^= i;
        }
        for (int a : nums) {
            ans ^= a;
        }
        return ans;
    }
}
