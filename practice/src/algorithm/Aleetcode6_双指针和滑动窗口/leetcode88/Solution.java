package algorithm.Aleetcode6_双指针和滑动窗口.leetcode88;

/**
 * 给定两个 有序 整数 数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 随便想一下就会，合并链表那个类似，只不过这个是从后往前，而且给出了真实数据的长度。
 * 如果不给，则自己要先计算 nums1 的真实有效数据的长度。
 *
 * 同样的双指针思路
 * 如何合并：
 * 如何存储：
 */
public class Solution {
    /**
     * 现在我自己都能完整的写出来了，真是棒！其实这类题画个图就出来了
     * @param nums1 num1
     * @param m     num1元素个数
     * @param nums2 num2
     * @param n     num2元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            nums1[cur --] = nums1[p1] > nums2[p2] ? nums1[p1 --] : nums2[p2 --];
        }
        // 若nums2 用完了，则正常结束；若nums1用完了，则需要把nums2中前面剩的复制到1的前部
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        if (p1 < 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}
