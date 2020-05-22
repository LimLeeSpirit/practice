package algorithm.Aleetcode10_数组.JZoffer58_leetcode179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 例如输入数组[3, 32, 321]，则打印出这3个数字能排成的最小数字321323。
 *
 * 样例
 *
 * 输入：[3, 32, 321]
 *
 * 输出：321323
 * 注意：输出数字的格式为字符串。
 *
 * 这种解法就是一种巧妙的解法，按照我们定义的方式将元素排序，然后加起来就行了，排序规则：
 * a, b <=> ab < ba
 */
public class Solution {
    public String printMinNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int a : nums) strs.add(String.valueOf(a));
        Collections.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo((o2 + o1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);

        return sb.toString();
    }

    public String largestNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int a : nums) strs.add(String.valueOf(a));
        Collections.sort(strs, new Comparator<String>(){
            public int compare(String o1, String o2) {
                return (int)(Long.valueOf(o2 + o1) - Long.valueOf(o1 + o2));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        String ans = sb.toString();

        // 去出首部的0
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') i ++;
        ans = ans.substring(i);
        return ans == null || ans.length() == 0 ? "0" : ans;
    }
}
