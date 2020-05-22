package algorithm.Aleetcode6_双指针和滑动窗口;

/**
 * 统计字符串中连续的重复字符个数
 * 比如 aabbbcbbccccbb,最长连续重复字符个数为 4 个。
 *
 * 简单的思想，设置两个指针，依次往后查找最长的重复字符个数
 */
public class LongestDupChar {
    public static int getLongestDupChar(String s) {
        if (s == null || s.length()<2) {
            throw new IllegalArgumentException("参数不正确");
        }

        int n = s.length();
        int i = 0, j;
        int ans = 1;
        while (i < n) {
            j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) j ++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(getLongestDupChar("asdfdsadfffffedsadsa"));
    }
}
