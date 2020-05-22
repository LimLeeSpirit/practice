package algorithm.Aleetcode10_数组.重复元素或者单一元素.leetcode287_serial1;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 */
public class Solution {
    // 先用数组下标的方式做，完美。时间复杂度为O(n + n)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i=0; i < n; i++) {
            int index = nums[i] % n;
            nums[index] += n;
        }

        for (int i = 0; i < n; i ++) {
            if (nums[i] > 2 * n) {
                return i;
            }
        }
        return -1;
    }

    // 升级版，值阈二分法，不用修改数字。
    public int duplicateInArray(int[] nums) {
        int n = nums.length;
        int l = 1; int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0; // 找出左右区间的元素个数，如果左区间的元素个数大于区间的长度，说明左区间肯定有重复的
            for (int a : nums ) {
                if (a >= l && a <= mid) cnt ++;
            }
            if (cnt > mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
