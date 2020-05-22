package algorithm.Aleetcode4_字符串.leetcode14;

/**
 *  找出多个字符串中的最长公共前缀
 *
 *  字典树可以做，标准答案那种也可以，只不过调用的是库函数。
 */

public class Solution {
    public static String longestCommonPrefix2(String[] strs) {
        /**
         * 牛逼！不愧是标准答案。逆向思维，人家不是去找公共子串，
         *
         * 人家是先假设一个子串为公共子串，然后以这个子串去匹配其他所有的子串！不匹配就更新！
         *
         * 同时注意一个字符串函数：public int s.indexOf(String str).
         * 如果 s 中包含 str， 则返回 str 在 s 中首次出现的下标；如果不包含，则返回 -1。
         *
         */
        int n =strs.length;
        if(n == 0){
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i < n; i ++) {
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String s1 = "qwerasweraffs";
        String s2 = "wera";
        System.out.println(s1.indexOf(s2));
    }

}
