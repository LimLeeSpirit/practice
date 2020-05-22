package interview.others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 大数加法
 * 加法还好，有减法的情况
 *
 * 输入：
 * "-1232"
 * "23"
 * 输出：
 * "-1209"
 */
public class Interview19 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s1 = in.nextLine();
//        String s2 = in.nextLine();
//        int a1 = Integer.parseInt(s1.substring(1, s1.length() - 1));
//        int a2 = Integer.parseInt(s2.substring(1, s2.length() - 1));
//        System.out.println("\"" + (a1 + a2) + "\"");
        System.out.println(simplifyPath("/home/../foo/"));


    }

    public static String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!deque.isEmpty()) deque.pollFirst();
            } else if (!item.isEmpty() && !item.equals(".")) deque.offerFirst(item);
        }
        String res = "";
        for (String d : deque) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }
}
