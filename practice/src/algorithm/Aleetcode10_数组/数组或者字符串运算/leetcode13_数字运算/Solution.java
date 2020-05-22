package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode13_数字运算;

import java.util.HashMap;
import java.util.Map;

/*
 *  罗马数字转整数
 */

public class Solution {
    public static int romanToInt(String s) {
        int res=0, i=0;
        Map<Character, Integer> single = new HashMap<>();
        single.put('M', 1000);
        single.put('C', 100);
        single.put('X', 10);
        single.put('I', 1);
        single.put('D', 500);
        single.put('L', 50);
        single.put('V', 5);

        Map<String, Integer> multi = new HashMap<>();
        multi.put("IV", 4);
        multi.put("XL", 40);
        multi.put("CD", 400);
        multi.put("IX", 9);
        multi.put("XC", 90);
        multi.put("CM", 900);

        while(i < s.length()) {
            if ((i<s.length()-1) && multi.containsKey(s.substring(i, i+2))) {
                res += multi.get(s.substring(i, i+2));
                i += 2;
            } else {
                res += single.get(s.charAt(i));
                i += 1;
            }
            System.out.println("i:"+i);
        }
        return res;
    }
}
