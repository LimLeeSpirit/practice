package algorithm.Aleetcode4_字符串;

/**
 * 给定两个字符串，s1 的长度 > s2 的长度，判断 s1 是否包含 s2,即 s2 中的字符是否在 s1 中出现
 *
 * 这个题与 同分异构词有一样的解法，就是设计一个 count 变量。
 */
public class IsContain {
    public static boolean isContain(String s1, String s2) {
        int[] charsOfS2 = new int[256];
        int count = 0;
        for (char c : s2.toCharArray()) {
            charsOfS2[c-'A'] += 1;
            count ++;
        }

        for (char c : s1.toCharArray()) {
            // s1 中字符在 s2 中出现过的才算数，不然跳过。
            if (charsOfS2[c-'A'] > 0) {
                charsOfS2[c-'A'] -= 1;
                count --;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(isContain("qwwweeerrtt", "qwwwerrrtt"));
    }
}
