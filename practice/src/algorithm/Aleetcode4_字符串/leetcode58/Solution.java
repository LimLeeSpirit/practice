package algorithm.Aleetcode4_字符串.leetcode58;

/**
 *  返回最后一个单词的长度，单词之间用空格隔开。
 *
 *  注意一点：
 *  字符串按照空格切割：String[] s1 = s.split("\\s+");
 *  总结一下字符串按照特定格式切割！写个博客
 */
public class Solution {
    public static int lengthOfLastWord(String s) {
        /**
         *         法1：切割成字符串数组，获取最后一个字符串的长度。
         *         这种做法效率较低，因为它把所以的单词都切割出来了，只取最有一个，效率当然低。

        String[] s1 = s.split("\\s+");
        if (s1.length==0) { return 0; }
        return s1[s1.length-1].length(); */

        // 法2： 规规矩矩地从最后开始遍历，直到遇到空格结束。
        s = s.trim(); // while(s.charAt(j) == ' ') j --; 删除s的末尾的字符串
        int cnt = 0;
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) != ' ') {
            j --;
            cnt ++;
        }
        return cnt;
    }
}
