package algorithm.Aleetcode1_二分;

/**
 *  在有序数组中，查找比给定目标小的前第一个数，也可以出题为查找给定目标大的第一个数
 *  对于第一种，找前一个小的：nums[mid] >= target,说明目标还在左边，且 mid 一定不是答案，直接 r = mid - 1；
 *                       否则，l = mid
 */
public class FindSmallerOrBigger_二分模版题 {
    public static int findSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 1) { return Integer.MIN_VALUE; }
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= target) r = mid - 1;  // 出现了 mid - 1，所以需要在计算mid的时候 + 1
            else l = mid;
        }
        return nums[l];
    }


    public static int findBigger(int[] nums, int target) {
        if (nums == null || nums.length == 1) { return Integer.MIN_VALUE; }
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {-1,3,3,4,5,7,7,7,7,8,8,90};
        System.out.println(findSmaller(nums, 8));
    }
}
