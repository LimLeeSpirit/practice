package interview.meituan;

import java.util.Scanner;

/**
 * 将字符串转化为另一种写法，货币->新写法
 */
public class Interview2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            check(in.nextLine());
        }
    }
    public static void check(String s) {
        StringBuilder sb = new StringBuilder();

        boolean is_minus = false;
        if (s.length() > 0 && s.charAt(0) == '-') {
            is_minus = true;
            sb.append('(');
            s = s.substring(1);
        }
        sb.append('$');

        String[] strs = s.split("\\.");
        if (strs.length == 1) {
            sb.append(getFirstPart(strs[0])).append(".00");
        } else {
            sb.append(getFirstPart(strs[0])).append(getSecondPart(strs[1]));
        }

        if (is_minus) {
            sb.append(')');
        }
        System.out.println(sb.toString());
    }

    public static String getFirstPart(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n % 3;
        if (i > 0) {
            sb.append(s.substring(0, i)).append(',');
        }
        for (; i < n; i += 3) {
            sb.append(s.substring(i, i + 3)).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String getSecondPart(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('.');
        if (s.length() >=2) {
            sb.append(s.substring(0, 2));
        } else if (s.length() == 1) {
            sb.append(s).append('0');
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

}
