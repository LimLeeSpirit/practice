package interview.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个int数是不是回文数字
 */
public class Interview6 {
    public static void main(String[] args) {
        System.out.println(check(656));
    }
    public static boolean check(int a) {
        if (a < 0) return false;
        List<Integer> values = new ArrayList<>();
        while (a > 0) {
            int yu = a % 10;
            a /= 10;
            values.add(yu);
        }
        for (int i = 0, j = values.size() - 1; i < j; i ++, j --) {
            if (values.get(i) != (values.get(j))) return false;
        }
        return true;
    }

}
