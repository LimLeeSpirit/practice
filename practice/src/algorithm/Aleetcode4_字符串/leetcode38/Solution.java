package algorithm.Aleetcode4_字符串.leetcode38;

/**
 * count and say
 *
 * facebook 面试题，leetcode 上的描述写得并不是很通俗易懂，让人读起来云里雾里。看看别人的题目描述：
 *  https://www.careercup.com/question?id=4425679
 *
 * 解决思路：第n个结果来源的依据是他前面的字符串，也就是n-1，那么这就可以用佩波拉契数列的动态规划求解思路去计算了。
 *         初始状态为 "1",依次计算其下一个字符串。直到第n个。
 *
 * 重点是写好 findNext() 方法，给定一个字符串，求出他的下一个字符串。
 */
public class Solution {
    public static String countAndSay(int n) {
        /*
        String[] res = new String[30];
        res[0] = "1";
        for(int i=1; i<n; i++) {
            res[i] = findNext(res[i-1]);
        }
        return res[n-1]; */

        String pre = "1";
        if (n==1) { return pre; }
        String res = "";
        for(int i=1; i<n; i++) {
            res = findNext(pre);
            pre = res;
        }
        return res;
    }

    public static String findNext(String pre) {
        //String next = "";
        StringBuilder next = new StringBuilder();

        int length = pre.length();
        int i = 0;
        while (i<length) {
            int count = 1;
            while (i+1<length && pre.charAt(i) == pre.charAt(i+1)) {
                count ++;
                i++;
            }
            next.append(count);
            //next += String.valueOf(count);
            next.append(pre.charAt(i));
            //next += pre.charAt(i);
            i++;
        }
        return next.toString();
    }

    public String countAndSay2(int n) {
        String[] dp = new String[n];
        dp[0] = "1";

        // int cnt = 0;
        int i=0;
        int j;

        for (int k=1; k<n; k++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = dp[k-1].toCharArray();
            while (i < chars.length) {
                j = i;
                while (j < chars.length && chars[i] == chars[j]) {
                    // cnt ++;
                    j ++;
                }
                sb.append(j-i).append(chars[i]);
                // cnt = 0;
                i = j;
            }

            dp[k] = sb.toString();
            System.out.println(dp[k]);
            i = 0;
        }
        return dp[n-1];
    }


    // 转化为字符数组来访问的效率居然比直接访问字符串下标 countAndSay3 更快
    public static String countAndSay4(int n) {
        String s = "1";
        int i=0;
        int j;

        for (int k = 1; k < n; k ++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            while (i < chars.length) {
                j = i;
                while (j < chars.length && chars[i] == chars[j]) {
                    j ++;
                }
                sb.append(j-i).append(chars[i]);
                i = j;
            }
            s = sb.toString();
            i = 0;
        }
        return s;
    }

    public static String countAndSay3(int n) {
        String s = "1";
        int i=0;
        int j;

        for (int k = 1; k < n; k ++) {
            StringBuilder sb = new StringBuilder();
            while (i < s.length()) {
                j = i;
                while (j < s.length() && s.charAt(i) == s.charAt(j) ) {
                    j ++;
                }
                sb.append(j - i).append(s.charAt(i));
                i = j;
            }
            i = 0;
            s = sb.toString();
        }
        return s;
    }

}
