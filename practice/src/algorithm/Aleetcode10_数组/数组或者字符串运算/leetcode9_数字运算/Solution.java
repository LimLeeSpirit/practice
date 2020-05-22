package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode9_数字运算;

/**
 * 判断一个整数是否是回文数
 * 如：123的逆序数：321=123，所以他不是
 *    -141的逆序数：141-，他也不是
 *    12321的逆序数：12321=12321，所以是
 */
public class Solution {
    public static boolean isPalindrome2(int x) {
        /**
         * 不转化为字符串，用整数运算：除法与取模！类似leetcode7，反转整数！
         */
        if (x<0) {
            return false;
        }

        int total = 0;
        int y;
        int ori = x;
        while (x > 0) {
            y = x % 10;
            x = x / 10;
            total = total * 10 + y;
            System.out.println(total);
        }
        return total==ori;
    }

    public static boolean isPalindrome(int x) {
        /*
         * 转化为字符串，两个指针从首尾出发进行相等判断
         */

        if (x<0) {
            return false;
        }

        String s = String.valueOf(x);
        if (s.length()==1) {
            return true;
        }

        for(int i=0; i<s.length()/2; i++) {
            int j = s.length()-1-i;
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
