package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode12_数字运算;

import java.util.HashMap;
import java.util.Map;

/*
 * 整数转罗马数字
 */
public class Solution {
    public static String intToRoman(int num) {
        /*
         * 我还是用的整数转字符串的方式，针对每一位，进行判断
         */
        StringBuilder res  = new StringBuilder();
        String numberStr = String.valueOf(num);
        int size = numberStr.length();
        Map<Double, String> map = new HashMap<>();
        map.put(1000.0, "M");
        map.put(100.0, "C");
        map.put(10.0, "X");
        map.put(1.0, "I");
        map.put(500.0, "D");
        map.put(50.0, "L");
        map.put(5.0, "V");

        map.put(4.0, "IV");
        map.put(40.0, "XL");
        map.put(400.0, "CD");
        map.put(9.0, "IX");
        map.put(90.0, "XC");
        map.put(900.0, "CM");

        map.put(0.0,"");

        for(int i=0; i<size; i++) {
            String curChar = String.valueOf(numberStr.charAt(i));
            int curDigit = Integer.parseInt(curChar);
            if (curDigit==4 || curDigit==9 || curDigit==5) {
                res.append(map.get(curDigit*Math.pow(10, size-1-i)));
            }
            else {
                res.append(map.get( (curDigit/5) * (Math.pow(10, size-1-i)*5) ));

                while (curDigit%5 >0) {
                    res.append(map.get(Math.pow(10, size-1-i)));
                    curDigit--;
                }
            }
        }
        return res.toString();
    }

    public static String intToRoman2(int num) {
        /**
         * 为什么我就没想到这种方式呢？？？明显题目就有提示，这些个整数转化为罗马数字的规则就是加起来相等就行了
         * 如果是转化为罗马数字，只需要进行一步一步减法就行了。
         */
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < values.length;i ++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

}
