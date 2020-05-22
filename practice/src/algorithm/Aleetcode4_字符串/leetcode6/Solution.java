package algorithm.Aleetcode4_字符串.leetcode6;
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 可以这样构造：
 * 0   8      16
 * 1 7 9  15  17
 * 2 6 10 14  18
 * 3 5 11 13  19
 * 4   12     20 ，这样申请的空间会更小，效率也会更高
 *
 */
class Solution {

    /**
     *  我的思路，构建成这样的排列，再构造成字符串。显然效率较低,  且申请了大量内存，空间效率也低
     *
     *  注意一点，进行字符串拼接操作比较多的话，最好用StringBuilder，更快，从30提升到70！
     *
     *  第二次自己写
     */
    public String convert(String s, int m) {
        if (m < 2) return s;
        int len = s.length();
        int n = 2 * len/(2 * m - 2) + 2;
        Character[][] chars = new Character[m][n];

        int k = 0;

        // 首先搞清楚 是以 列 为单位进行构造的
        for (int i = 0; i < n ; i++) {
            // 偶数列
            if ((i & 1) == 0) {
                for (int j = 0; j < m && k < len; j ++) {
                    chars[j][i] = s.charAt(k ++);
                }
            } else if ((i & 1) == 1) {
                for (int j = m-2; j > 0 && k < len; j --) {
                    chars[j][i] = s.charAt(k ++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character[] charA : chars) {
            for (Character c : charA) {
                if (c != null) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 大神的解法，找到了规律，第一行和最后一行是等差数列
     * 中间行是交错的等差数列
     * @param s
     * @param n
     * @return
     */
    public String convert3(String s, int n) {
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n-1) {
                for ( int j = i; j < len; j += 2 * (n - 1)) sb.append(s.charAt(j));
            } else {
                for (int j = i, k = 2 * (n - 1) - i; j < len || k < len; j += 2 * (n - 1), k += 2 * (n - 1)) {
                    if (j < len) sb.append(s.charAt(j));
                    if (k < len) sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }

    public static String convert2(String s, int numRows) {
        /*
         * 别人的，找到了规律，且直接生成最终的字符串
         */
        String newS = "";
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cyclelen = 2*numRows - 2;
        for (int i =0; i< numRows; i++){
            for(int j=0; j+i<n; j += cyclelen){

                // 针对首行和尾行
                ret.append(s.charAt(j+i));

                // 针对中间行
                if(i != 0 && i != numRows - 1 && j + cyclelen - i < n)
                    ret.append(s.charAt(j + cyclelen - i));
            }
        }
        return ret.toString();
    }

}
