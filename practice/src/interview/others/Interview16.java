package interview.others;

import java.util.Scanner;

/**
 * 输入数据只有一行，为一个字符串(不包含引号)，长度不超过1000，只包含大写字母'A'到'Z'，字符之间无空格。
 * 输出每个分割成子字符串的长度，要求每个每个字符只能出现在一个子段里面，且划分出的子段数量要最尽量多
 *
 * 输入例子1:
 *
 * MPMPCPMCMDEFEGDEHINHKLIN
 *
 * 输出例子1:
 *
 * 9 7 8
 *
 * 双指针，到 j 字符的时候，j为head，找到j字符最后出现的位置tail，[head, tail]之间的字符要保证只出现在这个段里面，
 * 即动态更新tail
 */
public class Interview16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int i = 0, j = 0, len = s.length();
        while (j < len) {
            char c = s.charAt(j);
            int tail = s.lastIndexOf(c);
            int head = j;
            i = j + 1;
            j = tail;
            while (i < j) {
                char inner = s.charAt(i);
                j = Math.max(j, s.lastIndexOf(inner));
                i ++;
            }
            j ++;
            System.out.println(s.substring(head, j));
            System.out.println(j - head + " ");
        }
    }
}
