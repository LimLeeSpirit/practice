package algorithm.Aleetcode10_数组.数组交集.leetcode350_数组交集II;

import java.util.*;

/**
 * 求两个数组元素的交集，输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 仍然用两个hash， 不过这次用 hashMap，还要统计每个元素出现的次数。时间复杂度（m + n + m*k）。
 * 可以先对数组排序，然后从两头分别出发。也就是下面的进阶1
 *
 * 这个题有很多进阶题：
 * 1、若两个数组有序，升序，怎么优化？见解法2
 *
 * 2、若一个数组的元素个数远远小于另一个呢 ？
 *    针对这种情况，可是对个数少的数组的元素， 在另一个数组中进行二分查找。（n * m * lgm）
 */
public class Solution {
    // 两个集合无序的做法，O(n + M + n*k)
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int a : nums1) {
            map1.put(a, map1.getOrDefault(a, 0) + 1);
        }

        for (int a : nums2) {
            map2.put(a, map2.getOrDefault(a, 0) + 1);
        }

        for (int a : map1.keySet()) {
            if (map2.containsKey(a)) {
                int tmp = Math.min(map1.get(a), map2.get(a));
                for (int i=0; i<tmp; i++) {
                    list.add(a);
                }
            }
        }

        int[] ret = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    // 两个数组都有序的做法，抓住有序这个条件，O(n + m)
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i ++;
                j ++;
            } else if (nums1[i] < nums2[j]) {
                i ++;
            } else if (nums1[i] > nums2[j]) {
                j ++;
            }
        }

        int[] ret = new int[list.size()];
        for (int k=0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }
}
