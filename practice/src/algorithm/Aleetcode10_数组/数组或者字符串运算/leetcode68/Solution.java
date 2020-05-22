package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode68;

import java.util.ArrayList;
import java.util.List;

/**
 *  文本左右对齐
 *  hard级别。哈哈哈，做出来了。
 *  这道题考的就是细心程度，没啥高深思想。
 *  要求：1、尽可能多地往每行中放置单词，单词之间用空格隔开，使得每行恰好有 maxWidth 个字符。
 *       2、要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *       3、文本的最后一行，以及只有一个单词的行应为左对齐，且单词之间不插入额外的空格。
 *
 *  Y总的思路还是好呀，代码简洁，变量清晰明了。
 *  对每一行有三种情况进行判断：1、如果是最后一行，则说明遍历到最后一个字符串，需要左对齐，每个字符串之间相隔一个空格
 *                        2、如果是该行只有一个字符串，则直接加上相应的空格
 *                        3、如果是其他情况，则尽量对空格均分，不能均分，则左边的要比右边的多
 *
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; ) {
            // s 字符串加上空格的总长度， rs 目前字符串的长度
            int j = i + 1, s = words[i].length(), rs = words[i].length();
            while (j < n && s + 1 + words[j].length() <= maxWidth) {
                s += 1 + words[j].length();
                rs += words[j].length();
                j ++;
            }
            // 还剩多少空格
            rs = maxWidth - rs;
            String line = words[i];
            if (j == n) {
                for (++ i; i < j; i ++) {
                    line += " " + words[i];
                }
                while (line.length() < maxWidth) line += " ";
            } else if (j - i == 1) {
                line += space(rs);
            } else {
                int base = rs / (j - i - 1);
                int rem = rs % (j - i - 1);
                i ++;
                while (i < j) {
                    if (rem > 0) {
                        line += space(base + 1) + words[i];
                        rem --;
                    } else {
                        line += space(base) + words[i];
                    }
                    i ++;
                }
            }
            i = j;
            ret.add(line);
        }
        return ret;
    }
    private String space(int x) {
        String s = new String();
        while (x > 0) {
            s += " ";
            x --;
        }
        return s;
    }
}
