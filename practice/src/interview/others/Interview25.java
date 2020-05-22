package interview.others;

import java.util.Collections;
import java.util.Scanner;

/**
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 *
 * 输出描述:
 *
 * 输出一个字符串，代表解压后的字符串。
 *
 * 输入例子1:
 * HG[3|B[2|CA]]F
 *
 * 输出例子1:
 * HGBCACABCACABCACAF
 *
 * 这个题其实考察 String 的 API
 *
 * indexOf(String st)
 * indexOf(String st, int fromIndex)
 * lastIndexOf(String st)
 * lastIndexOf(String st, from Index)
 * replace(String target, String newStr)
 * contains(String st) 当且仅当此字符串包含指定的 char 值序列时，返回 true。
 */
public class Interview25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        scanner.close();
        System.out.println(decode(next));
        System.out.println(Collections.nCopies(3, next));
    }

    public static String decode(String words){
        while (words.contains("]")) {
            int right = words.indexOf("]");  // ] 第一次出现的位置
            int left = words.lastIndexOf("[", right);  // 指定位置，从后往前找，最后出现的位置
            String repeatStr = words.substring(left + 1, right); // 需要处理的字符串
            String[] split = repeatStr.split("\\|");
            words = words.replace("["+repeatStr+"]", join(Integer.parseInt(split[0]), split[1]));
        }
        return words;
    }

    public static String join(int N, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i ++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
