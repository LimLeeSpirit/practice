package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode7_数字运算;

/**
 * 将一个有符号整数 反转
 * -123 -> -321
 * 123290 -> 92321
 *
 * note:
 *      字符串转为整数：
 *          int i = Integer.parseInt(String  s)
 *          int i = Integer.valueOf(my_str).intValue()
 *      整形转字符串：
 *          String s = String.valueOf(i);
 *          String s = Integer.toString(i);
 */
public class Solution {
    public static int reverse2(int x) {
        /**
         * 标准解法：利用取模取余的运算！
         * 自己在写的时候注意防治内存溢出
         */
        int sign = x < 0 ? -1 : 1;
        int y = Math.abs(x);

        // output 和 y 同时进行动态增长/减少
        // 考虑到反转后可能会溢出整数范围，所以用long
        long output = 0;
        while (y > 0) {
            int bottom = y % 10;
            y = y / 10;
            output = (10 * output) + bottom;
        }

        System.out.println(output);  // if x=-2147483648, output = 0

        if (output > Integer.MAX_VALUE) return 0;
        return sign * (int) output;
    }

    public static int reverse(int x) {
        /*
         * 我的第一思路：整形->字符串->反转->整形
         */

        // 这两种方法有什么区别？
        // Character[] y  = new Character[];

        // 判断正负 ，只算正的，负的在最后结果再乘以-1
        int sign = x < 0 ? -1 : 1;

        // 这里有陷阱，最小整数 -2147483648 以整数形式传进去 转化为其绝对值失败，因为其字面意义的绝对值
        // 是2147483648，但最大整形是是2147483647。溢出了。所以转化为long求其绝对值
        long newX = Math.abs((long)x);
        System.out.println("sign:"+sign);
        System.out.println("newX:"+newX);

        String src = String.valueOf(newX);
        char[] y = new char[src.length()];

        for(int i =src.length()-1; i>=0; i--) {
                    y[src.length()-i-1] = src.charAt(i);
        }

        String dest = new String(y);
        if (Long.parseLong(dest)>Integer.MAX_VALUE) {
            return 0;
        }
        return sign*Integer.parseInt(dest);
    }


}