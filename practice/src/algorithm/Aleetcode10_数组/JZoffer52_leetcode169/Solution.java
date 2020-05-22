package algorithm.Aleetcode10_数组.JZoffer52_leetcode169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 假设数组非空，并且一定存在满足条件的数字。
 *
 * 假设要求只能使用 O(n) 的时间和额外 O(1)的空间
 *
 * 可以用topk的算法来做，不过那样空间利用率会超过。这里Y总的思路真的惊奇：
 * 既然次数超过数组长度的一半，那么这个元素的个数比所以其他元素的个数加起来还要多，就利用这一点条件，声明两个变量
 * cnt 和 val
 * 一遍循环，不断更新这两个变量，最后得到的肯定是需要的答案
 *
 * time O(n), space O(1)
 */
public class Solution {
    public int moreThanHalfNum_Solution(int[] nums) {
        int cnt = 0, val = 0;
        for (int a : nums) {
            if (cnt == 0) {
                val = a;
                cnt ++;
            } else {
                if (a == val) cnt ++;
                else cnt --;
            }
        }

        return val;
    }


    public int majorityElement2(int[] nums) {
        // 法1，排序后取中间的
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement3(int[] nums) {
        //法2，利用字典存每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length/2) {
                return nums[i];
            }
        }
        return -1;
    }
}
