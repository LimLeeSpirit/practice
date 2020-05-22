package algorithm.Aleetcode4_字符串.leetcode273;

/**
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 2^31 - 1
 *
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 *
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * ___ billion ____ million  ____thousand  ____hundred
 * 1-999       1-999        1-999          1-999
 *
 * 比如最大整数：2 147 483 647
 * 化整为零 每三位判断一下读法，然后加上单位就好了
 *
 */
public class Solution {
    static String[] small = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static String[] decade = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    static String[] big = {"Billion", "Million", "Thousand", ""};

    public  static String numberToWords(int num) {
        if (num == 0) return small[0];
        StringBuilder sb = new StringBuilder();
        // 每三位三位地读取，从 Billion 到 Thousand，这种在一个for循环里从前到后，多个计数器的写法
        // 要学会，真的不愧是竞赛生
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, j ++) {
            if (num >= i) {
                sb.append(getPart(num/i)).append(big[j]).append(' ');
                num %= i;
            }
        }
        return sb.toString().trim();
    }

    // 将三位数字读出来，比较简单
    private static String getPart(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(small[num/100]).append(' ').append("Hundred").append(' ');
            num %= 100;
        }
        if (num == 0) return sb.toString();
        if (num >= 20) {
            sb.append(decade[num/10]).append(' ');
            num %= 10;
        }
        if (num== 0) return sb.toString();
        sb.append(small[num]).append(' ');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(234545323));
    }
}
