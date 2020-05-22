package algorithm.Aleetcode10_数组.位运算.JZoffer73_位运算_has2;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *
 * 请写程序找出这两个只出现一次的数字。
 *
 * 你可以假设这两个数字一定存在。
 *
 * 输入：[1,2,3,3,4,4]
 *
 * 输出：[1,2]
 *
 * 一般思路：利用哈希表统计个数进行选择
 *
 * 高级思路：利用异或操作。异或操作的一个特点就是相同元素的异或值为 0
 */
public class Solution {
    public int[] findNumsAppearOnce(int[] nums) {
        int sum = 0; // x ^ y， x 和 y 是结果
        for (int a : nums) sum ^= a;

        // 得到 x^y 后，找到其是 1 的那一位，比如第k位为 1，说明 x 和 y 在第k位值不同。
        int k = 0;

        while ((sum >> k & 1) == 0) k ++;

        // 然后将nums分为两个集合，分别包含x 和 y，且两个集合只有一个元素出现了一次，其余均出现了两次
        // 这样就把 x 和 y 分在两个集合了
        int first = 0;

        for (int a : nums) {
            if ((a >> k & 1) == 1) first ^= a;
        }

        // 第二个值，直接用 nums ^ first，就得到了
        return new int[]{first, sum ^ first};
    }
}
