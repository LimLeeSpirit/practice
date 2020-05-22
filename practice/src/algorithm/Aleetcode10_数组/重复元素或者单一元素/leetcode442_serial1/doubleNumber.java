package algorithm.Aleetcode10_数组.重复元素或者单一元素.leetcode442_serial1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。leetcode 287 是只有一个重复元素，直接找出一个就行了。
 *
 * 448、442、136 就是一个系列，当然对这类题最直接的就是用hash表判重了
 */
public class doubleNumber {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = (nums[i] - 1) % n;
            nums[a] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) ret.add(i + 1);
        }
        return ret;
    }
}
