package algorithm.Aleetcode4_字符串.leetcode5;

/**
 * 字符串匹配，判断 s2 是否是 s1 的子串；牛逼的解法就是 KMP 算法，一般来说有点难以写出来。这里还是先把基础的
 * 暴力法写一下吧
 */
public class StrMatch {
    public static boolean isMatch(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 < len2) {
            throw new IllegalArgumentException("参数错误");
        }
        // 两个指针往后走
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i ++;
                j ++;
            // 当前位置不匹配，则 i 退回去，j 退回到 s2 开始位置
            } else {
                i = i - j + 1;
                j = 0;
                // 这里判断一下，如果 s1 剩下的长度小于 s2 的总长度，就不用判断了，剪枝优化
                if (len1 - i < len2) {
                    return false;
                }
            }
        }

        return j >= len2;
    }
    public static boolean isMatch2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m < n) throw new IllegalArgumentException("参数错误");
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i ++;
                j ++;
            } else {
                 i = i - j + 1;
                 j = 0;
            }
        }
        // 如果走完了 s2，则成功匹配。
        return j == n;

    }
    public static void main(String[] args) {
        System.out.println(isMatch2("ewfrwtgr43f4tge", "43f4t"));
    }
}
