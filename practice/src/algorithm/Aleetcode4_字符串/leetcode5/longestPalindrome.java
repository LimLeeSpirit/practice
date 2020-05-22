package algorithm.Aleetcode4_字符串.leetcode5;

/**
 * 求 s 的最长回文子串
 */
public class longestPalindrome {
    /**
     * 这种方法才是最合适掌握的，马拉车法只适合求这一种情况，没有其他用武之地
     *
     * 每个中心点遍历一遍，每一次从两边扩散，最长为n，所以时间复杂度为 2 倍 O（n*n），分奇偶情况
     */
    public static String longestPalindrome(String s) {
        // String ret = "";
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i ++) {
            // 最长回文串为奇数情况
            for (int l = i, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l --, r ++) {
                if (right - left < r - l + 1) {
                    left = l;
                    right = r + 1;
                }
                // if (ret.length() < r - l + 1) ret = s.substring(l, r+1);
            }
            // 最长回文串为偶数情况
            for (int l = i, r = i + 1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l --, r ++) {
                if (right - left < r - l + 1) {
                    left = l;
                    right = r + 1;
                }
                // if (ret.length() < r - l + 1) ret = s.substring(l, r+1);
            }
        }
        return s.substring(left, right);
        // return ret;

    }
}
