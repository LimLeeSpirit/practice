package interview.others;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 电话号码对应的字符，每个号码对应的字符取一个，组成字符串，求所有的字符串
 */
public class Interview24 {
    public static String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        java.lang.String num = in.nextLine();
        List<String> ans = new ArrayList<>();
        dfs(ans, num,0, "");
        System.out.println(ans);

        System.out.println(test());

    }
    public static void dfs(List<String> ans, String s, int idx, String tmp) {
        if (idx >= s.length()) {
            ans.add(new String(tmp));
            return;
        }
        int k = s.charAt(idx) - '0';
        for (char c : strs[k].toCharArray()) {
            dfs(ans, s, idx + 1, tmp + c);
        }
    }

    // 如果try或catch中有return语句，finally 中对返回变量的改变不会影响最终的返回结果
    private static int test() {
        int i=0;
        try{
            i++;
            return i;
        } catch(Exception e)
        {
            i++;
        } finally {
            System.out.println("not here?");
            i ++;
            System.out.println("i:" + i);
            System.out.println("??");
        }
        return i;
    }
}
