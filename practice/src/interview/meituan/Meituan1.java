package interview.meituan;

public class Meituan1 {
    public static void main(String[] args) {
        String s1 = "10";
        String s2 = "-10";
        System.out.println(subStr(s1, s2));
    }

    /**
     * 大数相加 简单
     * @param s1  正
     * @param s2  正
     * @return
     */
    public static String addStr(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = len1 - 1, j = len2 - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int c1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int c2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int cur = c1 + c2 + carry;
            carry = cur / 10;
            sb.append(cur % 10);
            i --;
            j --;
        }
        return sb.reverse().toString();
    }

    /**
     * 大数相减， 如果两个数都是负数的话，则取其绝对值做一遍加法后加上负号即可
     * @param s1  "345"   正
     * @param s2  "-2356" 负
     * @return string ans
     *
     * 减法的时候需要考虑到最后得到的结果是正还是负，是正好说，则 s1 - s2；
     * 否则，计算的时候是用 s2 - s1，最后加上负号。
     */
    public static String subStr(String s1, String s2) {
        s2 = s2.substring(1);
        int len1 = s1.length(), len2 = s2.length();
        char[] c1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(s2).reverse().toString().toCharArray();

        // 判断结果正负
        boolean is_minus = false;
        if (len1 < len2) is_minus = true;
        else if (len1 == len2) {
            int i = len1 - 1;
            while (i >= 0 && c1[i] == c2[i]) i --;
            if (i >= 0 && c1[i] < c2[i]) is_minus = true;
        }

        // 计算 ans 的每一位，有个技巧，每一位的运算先计算，减的时候不足的话也先留着
        int ans_len = len1 > len2 ? len1 : len2;
        int[] ans = new int[ans_len];
        for (int i = 0; i < ans_len; i ++) {
            int a = i < len1 ? c1[i] - '0' : 0;
            int b = i < len2 ? c2[i] - '0' : 0;
            if (is_minus) ans[i] = b - a;
            else ans[i] = a - b;
        }

        // 对于 ans 中的每一位，如果是负数，则说明需要借位
        for (int i = 0; i < ans_len - 1; i ++) {
            if (ans[i] < 0) {
                ans[i + 1] --;
                ans[i] += 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int j = ans_len - 1;
        while (j >= 0 && ans[j] == 0) j --;
        while (j >= 0) {
            sb.append(ans[j --]);
        }

        if (sb.length() == 0) return "0";
        if (is_minus) {
            return "-" + sb.toString();
        } else return sb.toString();
    }
}