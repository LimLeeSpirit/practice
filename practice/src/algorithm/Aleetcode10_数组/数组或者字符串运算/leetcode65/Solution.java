package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode65;

/**
 * 判断一个字符串是否是数字形式。情况太多了！ 字母包括：数字、e、小数点、正负号
 *
 * 注意一个知识点：删除字符串的空格：String s = s1.replace(" ", "");
 *
 * 这个题虽然不好，但是可以锻炼我们 分类思想 和 逻辑思维
 */
public class Solution {
    public static boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if (s == null || s.length() == 0 || s.equals(".")) return false;

        char[] c = s.toCharArray();
        int n = c.length;

        int dot = 0, e = 0;
        for (int i = 0; i < n; i ++) {
            if (c[i] >= '0' && c[i] <= '9') continue;

            else if (c[i] == '.') {
                dot ++;
                // 433.345.455    23e32.324
                if (dot > 1 || e > 0) return false;

            } else if (c[i] == 'e') {
                e ++;
                // 3243e432e   324e         .e23                       e2332
                if (e > 1 || i + 1 == n || i == 1 && c[i - 1] =='.' || i == 0) return false;
                // e+                     e-
                if (c[i + 1] == '+' || c[i + 1] == '-') {
                    if (i + 2 == n) return false;
                    // 跳过 e 后面的正负号
                    i ++;
                }
            } else return false;
        }
        return true;
    }
}
