package algorithm.Aleetcode4_字符串.JZoffer77_leetcode151;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 是以单词为单位进行反转
 *
 * 法一：使用字符串切割的方法。 适用于 leetcode 151,要将多余的空格也删掉
 * 多余空格直接使用字符串切割
 * string.trim()：删除字符串首位多余的空格
 * string.split("\\s+")：以空格切割字符串，不管空格是否有连续的几个
 *
 * 法二：直接使用字符串反转，第一次反转每个单词，第二次反转整个字符串。
 * 适用于 JZoffer77，需要保留所有的字符，包括空格
 */
public class Solution {
    // 法 1
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i --) {
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }

    // 法 2
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        reverse(chars, 0, n - 1);

        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && chars[j] != ' ') j ++;
            reverse(chars, i, j - 1);
            i = j + 1;
        }
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
        // System.out.println(new String(chars));
    }
}
