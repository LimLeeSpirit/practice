package algorithm.Aleetcode7_栈队列.leetcode84;

import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 枚举所有的上边界，作为整个矩形的上边界
 * 然后找出左右边界：
 *  1、找出左边离他最近的，比他小的矩形；
 *  2、找出右边离他最近的，比他小的矩形；
 *
 *  这不就是最长回文子串的从中心扩展的思路吗
 *  基础解法：使用两个指针，分别指到以当前矩形 i 为基准的大矩形的边界位置，时间O（n^2）；需要注意边界条件
 *
 *  高级解法：使用单调栈，求每个位置处的左右边界，用的就是上面那个构造矩形的思想，由于每个元素都只需要进出栈一次，所以复杂度是
 *          O（n），
 *          使用两个数组，遍历两次，分别保存每个位置能构造出的大矩形的左边界和右边界
 */
public class Solution {
    public int largestRectangleArea(int[] nums) {
        int ret = 0;
        for (int i = 0, l = -1, r = 1; i < nums.length; i ++, l = i - 1, r = i + 1) {
            while (l >= 0 && nums[l] >= nums[i]) l --;
            while (r < nums.length && nums[r] >= nums[i]) r ++;
            ret = Math.max(nums[i] * (r - l - 1), ret);
        }
        return ret;
    }

    /**
     * 究极神作之单调栈！ 这个写法和接雨水的三次遍历有相同之处呀！
     * @param nums 数组
     * @return     最大面积矩形
     */
    public int largestRectangleArea2(int[] nums) {
        int ret = 0;
        int n = nums.length;
        // 单调栈
        LinkedList<Integer> stk = new LinkedList<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // 构造左边界
        for (int i = 0; i < n; i ++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) stk.pop();
            if (stk.isEmpty()) left[i] = -1;
            else left[i] = stk.peek();
            stk.push(i);
        }

        while (!stk.isEmpty()) stk.pop();

        // 构造右边界
        for (int i = n - 1; i >= 0; i --) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) stk.pop();
            if (stk.isEmpty()) right[i] = n;
            else right[i] = stk.peek();
            stk.push(i);
        }

        for (int i = 0; i < n; i ++) ret = Math.max(ret, (right[i] - left[i] - 1) * nums[i]);

        return ret;
    }
}
