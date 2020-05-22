package algorithm.Aleetcode4_字符串.JZoffer78;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *
 * 请定义一个函数实现字符串左旋转操作的功能。
 *
 * 输入："abcdefg" , n = 2
 *
 * 输出："cdefgab"
 *
 * 目的：XY -> YX
 *
 * 1、XY 反转 Y'X'
 * 2、对Y'X'的两段分别反转 得到 YX
 */
public class Solution {
    public String leftRotateString(String s,int n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        reverse(chars, 0, len - 1);
        reverse(chars, 0, len - n - 1);
        reverse(chars, len - n, len - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[j];
            chars[j] = chars[i];
            chars[i] = tmp;
            i ++;
            j --;
        }
    }
}
