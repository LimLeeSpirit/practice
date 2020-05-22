package algorithm.Aleetcode5_DFS和回溯.leetcode17_深搜;

/**
 *  电话号码的数字组合
 *  2-9 分别对应 abc、def、ghi、.....
 *
 *  输入："23"， 2对应 adc、3对应 def
 *
 *  输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *  自己没做出来！
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    // 可以说是一遍成功！利用迭代的思想，首先思考23的结果怎么得到，再思考234的结果怎么得到，再思考2345怎么得到
    // 不就是根据前一个结果，再进行得到的嘛，所以就是迭代更新的思想
    // 这个思想更实用
    public static List<String> letterCombinations(String digits) {
        List<String> state = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return state;

        // 第0层的 state
        state.add("");
        for (char c : digits.toCharArray()) {
            List<String> now = new ArrayList<>();
            for (char d : str[c-'0'].toCharArray()) {
                for (String s : state) {
                    s += d;
                    now.add(s);
                }
            }
            // 更新 state
            state = now;
        }
        return state;
    }

    // 这才是我能想到的dfs解法，就是要找完所有情况，在每个子字符串中都取一个字符组成结果。深度搜索实现的
    List<String> ans;
    String[] d = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations2(String digits) {
        ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        dfs(digits, 0, "");
        return ans;
    }

    private void dfs(String digits, int idx, String cur) {
        // 递归终止条件, 走到了最后一个子字符串后面，说明走完了，返回结果。
        if (idx >= digits.length()) {
            ans.add(new String(cur));
            return;
        }

        // 该子字符串的所以字符均参加自己的深搜
        int k = digits.charAt(idx) - '0';
        for (char c : d[k].toCharArray()) {
            dfs(digits, idx + 1, cur + c);
        }
    }
}
