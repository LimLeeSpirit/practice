package algorithm.Aleetcode10_数组.重复元素或者单一元素.leetcode448_serial1;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 *  数组中的元素一些出现了两次，另一些只出现一次。
 *
 *  找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *  448、442、136就是 个系列：
 *      条件：1<=nums[i]<=n;
 *
 *  找出出现0次、1次、2次的元素。
 *
 *  利用好索引。因为 1<=nums[i]<=n 是最好的条件。
 *
 */
public class zeroNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int index = (nums[i]-1) % n;
            nums[index] += n;
        }
        for (int i=0; i<n; i++) {
            if (nums[i] <= n) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
