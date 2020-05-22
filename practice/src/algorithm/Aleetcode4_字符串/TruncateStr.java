package algorithm.Aleetcode4_字符串;

/**
 * 切割字符串，利用到一个知识点：Java 中默认使用Unincode编码，一个字符占用2个字节，在String中，通过优化
 * 一个英文字符占1个字节，一个中文字符占用2个字节。
 *
 * 要求字节长度切割字符串，不能出现半个中文字符。
 * 比如：哈dqd哈jdwe， 字节长度4，输出哈dq；
 *      字节长度6，输出哈dqd；字节长度7，输出 哈dqd哈
 */
public class TruncateStr {
    public static String truncateStr(String s, int k) {
        int m = s.length();
        int used = 0;
        for (int i = 0; i < m; i++) {
            if (used <= k - 2) {
                if (isChinesCharacter(s.charAt(i))) {
                    used += 2;
                } else {
                    used += 1;
                }
            } else if (used == k - 1) {
                if (isChinesCharacter(s.charAt(i))) {
                    if (i == 0) {
                        return null;
                    } else {
                        return s.substring(0, i);
                    }
                } else {
                    used += 1;
                }
            } else if (used == k) {
                return s.substring(0, i);
            }
        }
        return s;
    }

    private static boolean isChinesCharacter(char c) {
        String sb = String.valueOf(c);
        return sb.getBytes().length > 1;
    }

    public static void main(String[] args) {
        System.out.println(truncateStr("哈dqwdd哈dew", 4));
    }
}
