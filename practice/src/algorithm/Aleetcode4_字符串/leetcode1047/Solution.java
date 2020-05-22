package algorithm.Aleetcode4_字符串.leetcode1047;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 输入："abbaca"
 * 输出："ca"
 *
 *
 * 删除相邻的重复字符 1047。  和书上一道题，有点类似：删除字符串中的重复元素
 * 要删除连续的相同字符，怎么就没有想到栈这种数据结构呢。。。。
 *
 * 改进用双端队列,注意双端队列不是很长见，要多熟悉
 */
public class Solution {
    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (deque.isEmpty()) {
                deque.offerLast(c);
            } else if (!deque.peekLast().equals(c)) {
                deque.offerLast(c);
            } else {
                deque.pollLast();
            }
        }

        for (char c : deque) {
            sb.append(c);
        }
        // deque.toString(); 是返回的数组形式的字符串 "[a,c,k,l]"
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aabbacaahjjhkiil";
        System.out.println(removeDuplicates(s));
    }
}
