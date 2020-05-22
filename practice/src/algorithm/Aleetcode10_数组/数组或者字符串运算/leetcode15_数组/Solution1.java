package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode15_数组;

import java.util.*;

/**
 * 找出所有三数之和为0的组合。
 * 巧妙的方法：仍然是抓住和为0。3个数中必有正负或者3个0！
 */
public class Solution1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 统计每个字母出现个数
        Map<Integer, Integer> count = counter(nums);

        // 防止边界情况{0,0,0}出现多次
        if(count.containsKey(0) && count.get(0)>2) {
            // 数组array转List
            res.add(Arrays.asList(0,0,0));
        }

        // 获取正负数组
        List<Integer> notNegative = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for(Integer in : count.keySet()) {
            if (in>=0) {
                notNegative.add(in);
            } else {
                negative.add(in);
            }
        }

        // 去重！
        for (int j=0; j<notNegative.size(); j++) {
            for (int z=0; z<negative.size(); z++) {
                int reverse = 0-(notNegative.get(j)+negative.get(z));
                if (count.containsKey(reverse)) {
                    if (reverse==notNegative.get(j) && count.get(reverse) > 1) {
                        res.add(Arrays.asList(reverse, reverse, negative.get(z)));
                    } else if (reverse==negative.get(z) && count.get(reverse) > 1) {
                        res.add(Arrays.asList(reverse, reverse, notNegative.get(j)));
                    } else if (reverse<notNegative.get(j) && reverse>negative.get(z)) {
                        res.add(Arrays.asList(reverse, notNegative.get(j), negative.get(z)));
                    }
                }
            }
        }

        return res;
    }

    public static Map<Integer,Integer> counter(int[] sums) {
        Map<Integer, Integer> countNum = new HashMap<>();
        for(int i=0; i<sums.length; i++) {
            if(countNum.containsKey(sums[i])) {
                countNum.put(sums[i], countNum.get(sums[i])+1);
            } else {
                countNum.put(sums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : countNum.entrySet()) {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
        return countNum;
    }
}
