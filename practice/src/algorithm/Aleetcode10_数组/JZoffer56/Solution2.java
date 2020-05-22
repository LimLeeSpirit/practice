package algorithm.Aleetcode10_数组.JZoffer56;

import java.util.ArrayList;
import java.util.List;

/**
 * Y总的思路，根据个十百千万的位上可能会出现多少次1，来计算。是按照位来算的
 * n = 32105
 *
 * nums = [5, 0, 1, 2, 3]
 *
 * if i = 3, left = 501, right = 3, t = 10;
 * 第一种情况：left 在 0 - 500 之间，right 在0-9任选，故 1 的个数 = 501 * 10;
 * 第二种情况：left = 501, nums[i] = 1，则还有 0 - right = right + 1个；
 *                      nums[i] > 1, 则还有 0-9 个 = t 个；
 *                      nums[i] = 0, 则没有
 */
public class Solution2 {
    public int numberOf1Between1AndN_Solution(int n) {
        List<Integer> nums = new ArrayList<Integer>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }

        int ret = 0;
        for (int i = nums.size() - 1; i >= 0; i --) {
            int left = 0, right = 0, t = 0;
            for (int j = nums.size() - 1; j > i; j --) left = left * 10 + nums.get(j);

            for (int j = i - 1; j >= 0; j --) {
                right = right * 10 + nums.get(j);
                t *= 10;
            }

            ret += left * t;

            if (nums.get(i) == 1) ret += right + 1;
            else if (nums.get(i) > 1) ret += t;
        }

        return ret;
    }
}
