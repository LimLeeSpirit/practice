package algorithm.Aleetcode1_二分;

/**
 * 快速求升序数组中绝对值最小的数
 *
 * 若第一个数 > 0，则直接取第一个数；
 * 若最后一个数 < 0，则直接取最后一个数；
 * 若负数整数都有，则进行二分查找，找到正负数分界之处，将两个分界处的元素绝对值进行比较。
 *
 */
public class MinAbsNumber {
    public static int getMinAbs(int[] nums) {
        if (nums==null || nums.length ==0) {
            throw new IllegalArgumentException("参数不合理");
        }

        if (nums[0] >=0) {
            return nums[0];
        } else if (nums[nums.length - 1] <= 0){
            return nums[nums.length - 1] * -1;
        } else {
            return helper(nums);
        }
    }

    // 找出比0大的和比0小的，然后再进行比较
    private static int helper(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = l + r >> 1;
            if (nums[mid] <= 0) l = mid + 1;
            else r = mid;
        }
        int bigger = nums[l];
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            mid = l + r + 1>> 1;
            if (nums[mid] >= 0) r = mid - 1;
            else l = mid;
        }
        int smaller = nums[l];

        if (Math.abs(bigger) < Math.abs(smaller)) return bigger;
        return smaller;
    }

    public static void main(String[] args) {
        int[] nums = {-13,-1, 2};
        System.out.println(getMinAbs(nums));
    }
}
