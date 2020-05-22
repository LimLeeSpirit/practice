package algorithm.Aleetcode7_栈队列.leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ( { [ ] } ) 判断符合是否匹配
 *
 * 结合 leetcode 32 Longe Valid Parentheses 一起思考
 *
 * 这个题直接用一个栈来做就可以判断是否合法；32题要求最长有效子串，则需要在栈中记录下标了。
 */
public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parentMap = new HashMap<>();
        parentMap.put(')', '(');
        parentMap.put(']', '[');
        parentMap.put('}', '{');

        for(int i = 0; i < s.length(); i ++) {
            Character c = s.charAt(i);
            if (!parentMap.containsKey(c)) {
                stack.add(c);
            } else if (stack.empty() || (parentMap.get(c) != stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }
}
