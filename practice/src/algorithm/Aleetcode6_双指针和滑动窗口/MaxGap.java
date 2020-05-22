package algorithm.Aleetcode6_双指针和滑动窗口;

/**
 * 求给定数组中的最大数对的差值，左边元素 - 右边元素的最大差值。
 *
 * 简单的双指针问题吧
 *
 * 题目要求左边-右边，所以应该是从右往左找最小值，对于每个元素，找出在他后面的最小值，做个差值，就得到答案。
 * 哈哈用一个变量来维护这个最小值
 */
public class MaxGap {
    public static int getMax2(int[] nums) {
        int n = nums.length;
        int min_n = nums[n - 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i --) {
            ans = Math.max(ans, nums[i] - min_n);
            System.out.println(ans);
            min_n = Math.min(min_n, nums[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 3, 9, 1};
        System.out.println(getMax2(nums));
    }
}
