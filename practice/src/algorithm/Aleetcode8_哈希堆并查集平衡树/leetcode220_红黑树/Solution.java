package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode220_红黑树;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 217 存在重复元素 I
 * 219 存在重复元素 II
 * 220 存在重复元素 III
 *
 * 220
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] 与 nums [j] 的差的绝对值最大为 t，并且 i 和 j 的差的绝对值最大为 k。
 *
 */
public class Solution {
    /**
     * 照着219做，时间复杂度O（nk）超时了，说明可以做到O（n）？
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set = new HashSet<>();
        long tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int a : set) {
                tmp = Math.abs((long) a - (long) nums[i]);
                if (tmp <= t) {
                    return true;
                }
            }
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }

    /**
     * 利用平衡二叉搜索树，充当滑动窗口，因为我们上面用一个set充当滑动窗口，在内层循环的时候，必须遍历窗口所有元素，复杂度O（k）
     * 能不能找一种删除、查找、添加是 lg（n）甚至更少的数据结构呢？有，平衡二叉搜索树就可以。
     * Java 中的平衡二叉树：TreeSet，底层用红黑树实现。它里面有很多有用的方法，我们这里主要就用到了取ceil、floor、添加方法。
     * 所以时间复杂度O（nlgn）
     * @param nums nums
     * @param k    k
     * @param t    间隔
     * @return     bool
     *
     * 注意两点：1、测试集合有超过整形范围，所以用long型
     *         2、 set.ceiling((long)nums[i])返回的是对象，所以需要用引用类型 Long 去接收，才可以与 null 进行判断
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            // 返回此 set 中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null。
            // 注意
            Long s = set.ceiling((long)nums[i]);
            if (s != null && s - nums[i] <= t) return true;

            // 返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。
            Long f = set.floor((long)nums[i]);
            if (f != null && nums[i] - f <= t) return true;

            set.add((long)nums[i]);

            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}