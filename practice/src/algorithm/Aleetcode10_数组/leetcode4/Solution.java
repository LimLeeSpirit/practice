package algorithm.Aleetcode10_数组.leetcode4;

/**
 * 找出两个有序数组联合在一起后的中位数
 * 比如：[1, 2], [3, 4]
 * 输出：2.5
 *
 * 1 基础解法：合并两个数组，找出中位数
 *
 * 2 仔细思考下，发现并不需要将所有值都排序好再找中间值，只需要在排序的时候找到第mid个元素就行了。
 * Time: O(m + n), Space: O(1)
 *
 * 3 也可以用求 TopK 的方法，小顶堆。
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) throw new IllegalArgumentException("参数错误");

        int m = nums1 != null ? nums1.length : 0, n = nums2.length;
        int right = helper(nums1, nums2, (m + n) / 2);
        if (((m + n) & 1) == 1) return (double)right;
        int left = helper(nums1, nums2, ((m + n) / 2) - 1);
        return (left + right) / 2.0;
    }

    private static int helper(int[] nums1, int[] nums2, int idx) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, k = 0;
        int target = -1;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == idx) return nums1[i];
                i ++;
                k ++;
            } else {
                if (k == idx) return nums2[j];
                j ++;
                k ++;
            }
        }

        while (i < m) {
            if (k == idx) return nums1[i];
            i ++;
            k ++;
        }

        while (j < n) {
            if (k == idx) return nums2[j];
            j ++;
            k ++;
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1};
//        int[] nums2 = {3, 4, 4,90};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//        String s = "2e   w deq";
//        System.out.println(s.replace(" ", ""));
//        System.out.println((char)(1 + 'A'));
        int n = 89;
        String s = Integer.toBinaryString(n);
        System.out.println(s);

        StringBuilder sb = new StringBuilder(s);

        sb.reverse();
        System.out.println(sb);
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
