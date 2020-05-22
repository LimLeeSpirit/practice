package algorithm.Aleetcode4_字符串.leetcode28;

/*
 * 返回子串在字符串中出现的位置
 */
public class Solution {
    public static int strStr(String haystack, String needle) {
        int nlength = needle.length();
        for(int i=0; i<haystack.length()-nlength+1; i++) {
            if(haystack.substring(i, i + nlength).equals(needle)) { return i; }
        }

        // return haystack.indexOf(needle);
        return -1;
    }
}
