package algorithm.Aleetcode4_字符串.leetcode165;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 */
public class Solution {
    // 我的第一次想到的方法，有点慢，分给字符串，然后相同位进行比较，2次O（n）分割字符串，1次O（n）遍历，
    // 一次O（n遍历还没遍历完的），所以比较慢，可以考虑用指针直接对字符串进行移动。见方法2
    public static int compareVersion(String s1, String s2) {
        String[] str1 = s1.split("\\.");
        String[] str2 = s2.split("\\.");
        int i, j;
        System.out.println(str1.length);
        for ( i=0, j=0; i < str1.length || j < str2.length; i++, j++) {
            // 在走完一个字符串的时候，只要其中一个字符串还有，就继续走，并将已经走完的赋值为0
            int a = i >= str1.length ? 0 : Integer.valueOf(str1[i]);
            int b = j >= str2.length ? 0 :Integer.valueOf(str2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }

        return 0;
    }

    // 直接使用指针,以及在字符串中找到符合某一个条件的模版，更快！代码更简洁！！！
    public int compareVersion2(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() || j < s2.length()) {
            // 字符串中找到符合某一个条件的模版,以 . 结束
            int x = i, y = j;
            while (x < s1.length() && s1.charAt(x) != '.') x ++;
            while (y < s2.length() && s2.charAt(y) != '.') y ++;
            int a = x == i ? 0 : Integer.parseInt(s1.substring(i, x));
            int b = y == j ? 0 : Integer.parseInt(s2.substring(j, y));
            if (a > b) return 1;
            if (a < b) return -1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        String s1 = "1.0";
        String s2 = "1.1";
        System.out.println(compareVersion(s1,s2));
    }
}
