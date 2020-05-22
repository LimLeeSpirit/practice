package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode66;

import java.util.ArrayList;
import java.util.List;

/**
 *  数组最后一位 +1 后，形成的新数组，挺简单，就是需要细心点。
 *  输入: [4,3,2,1]
 *  输出: [4,3,2,2]
 *  解释: 输入数组表示数字 4321。
 *
 *  哈哈哈，现在做这种题简直简单呀
 */
public class Solution {
    public static int[] plusOne(int[] nums) {
        int n = nums.length;
        int tmp = nums[n - 1] + 1;
        nums[n - 1] = tmp;
        if (tmp < 10) {
            return nums;
        }

        List<Integer> ret = new ArrayList<>();
        int carry = 0;
        for (int i = n - 1; i >= 0; i --) {
            int cur = nums[i] + carry;
            ret.add(cur % 10);
            carry = cur / 10;
        }
        if (carry > 0) ret.add(carry);

        int m = ret.size();
        int[] ans = new int[m];
        for (int i = 0; i < m; i ++) {
            ans[i] = ret.get(m - i - 1);
        }
        return ans;
    }
}
