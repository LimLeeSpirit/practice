package algorithm.Aleetcode1_二分.leetcode162;

/**
 * 寻找峰值，即局部最大值。比如[1,2,3,1]，峰值是3，返回下标2。一个数组中峰值可能有多个，返回一个即可
 *
 * 边界nums[-1] = nums[nums.length] = - ∞，且相邻元素不相同
 */

public class Solution {
    // 先写一个O（n）的顺序遍历吧,当然这是最笨的
    public int findPeakElement(int[] nums) {
        if (nums == null | nums.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i=0; i<nums.length; i++) {
            if (i == 0 && i+1 < nums.length && nums[i]> nums[i+1] ) {
                return i;
            }

            if (i == nums.length - 1 && i >= 1 && nums[i-1] < nums[i]) {
                return i;
            }

            if (i >= 1 && nums[i-1] < nums[i] &&  i+1 < nums.length && nums[i] > nums[i+1] ) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 虽然找不到两段的性质，一半满足性质，另一半不满足，
     * 但是仍然可以利用二分的思想，画图来想，山峰一样的，每次都折半查找。进而缩小查找范围
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            // 当前点大于右边点，则左半子数组必定存在峰值
            // 还要注意一下边界，这里的边界并不会越界，原因是mid下取整，只有当l=r的时候才会有mid到达右边界，但是l=r的时候
            // 已经推出循环了。
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid  + 1;
        }
        return r;
    }
}
