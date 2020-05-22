package algorithm.Aleetcode7_栈队列.leetcode42;

import java.util.LinkedList;

/**
 * 数组容器装水题： 将数组的大小当作是木板的高度，这样一个高低不一的板子竖着放，能放多少水？
 *
 * 是单调减的栈
 *
 * 和 84 题很类似，不过在找左边离他最近的比他大的位置的时候，需要记录一些值,所以需要记录中间量，
 * 在针对一个槽进行计算的时候，分层进行计算，这个思路也是很牛逼，后面看到想不起来了就去看Y总的题解吧，
 * 但是单调栈的思路虽然是不错，但是这个分层计算的步骤比较难以想到；
 *
 * 更直观的是：针对每一个棍子，找其左边的最大棍子max_left，找其右边的最大棍子max_right，
 * 此棍子能接到的水就是min(max_left, max_right) - 当前棍子高度，然后对每条棍子的能接的水加起来，就是总的水！
 * 这种思路求的是每条棍子能接的水，是竖着的思想！更简单！
 *
 */
class Solution {
    // 只需要3次遍历，牛逼！竖着去思考
    public int trap2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if (n == 0) return ans;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        max_left[0] = nums[0];
        max_right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i ++) {
            max_left[i] = Math.max(max_left[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i --) {
            max_right[i] = Math.max(max_right[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i ++) {
            ans += Math.min(max_left[i], max_right[i]) - nums[i];
        }
        return ans;
    }


    public int trap(int[] nums) {
        int ret = 0;
        int n = nums.length;
        LinkedList<Integer> stk = new LinkedList<>();

        for (int i = 0; i < n; i ++) {
            int last = 0;
            // 第一部分：槽中的分层计算
            while (!stk.isEmpty() && nums[stk.peek()]  <= nums[i]) {
                int t = stk.peek();
                stk.pop();
                ret += (i - t - 1) * (nums[t] - last);
                last = nums[t];
            }
            // 第二部分：槽最上面那一块
            if (!stk.isEmpty()) ret += (i - stk.peek() - 1) * (nums[i] - last);

            stk.push(i);
        }
        return ret;
    }

}
