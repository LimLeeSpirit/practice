package algorithm.Aleetcode10_数组.数组交集.leetcode349_数组交集I;

import java.util.HashSet;
import java.util.Set;

/**
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 最简单的，两个 set 取交集
 *
 * 注意一点：
 * list ——> 数组，对于基本类型来说，那种方法不行，要用也只有放在其包装类型里，对于 String 等引用类型来说可以，所有还是直接
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int a : nums1) {
            set1.add(a);
        }
        for (int a : nums2) {
            set2.add(a);
        }

        // 这个方法可以学到
        set1.retainAll(set2);

        int[] ret = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            ret[index ++] = num;
        }
        return ret;
        /**

        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        使用泛型，无需显式类型转换
        String[] array = list.toArray(new String[list.size()]);

         Integer list2[] = new Integer[arrlist.size()];
         list2 = arrlist.toArray(list2);
         */


    }

}
