package algorithm.Aleetcode7_栈队列.JZoffer64;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 字符流中第一个只出现一次的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *
 * 例如，当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是’g’。
 *
 * 当从该字符流中读出前六个字符”google”时，第一个只出现一次的字符是’l’。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 输入："google"
 *
 * 输出："ggg#ll"
 *
 * 解释：每当字符流读入一个字符，就进行一次判断并输出当前的第一个只出现一次的字符。
 *
 * 首先需要一个map来记录当前所以字符出现的次数，然后还需要一个数据结构来取出当前只出现过一次的字符，由于在不断添加字符的过程中，
 * 需要将前面出现的超过1次的字符删掉，所以就是一个从左到右的数据结构，所以想到队列，从队尾加元素，从队头删元素。
 */
public class Solution {
    Map<Character, Integer> map = new HashMap<>();
    Queue<Character> q = new ArrayDeque<>();
    //Insert one char from stringstream
    public void insert(char ch){
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.get(ch) > 1) {
            while (q.size() > 0 && map.get(q.peek()) > 1) q.poll();
        } else {
            q.offer(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        if (q.isEmpty()) return '#';
        return q.peek();
    }
}
