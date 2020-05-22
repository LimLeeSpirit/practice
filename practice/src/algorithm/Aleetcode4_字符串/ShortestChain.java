package algorithm.Aleetcode4_字符串;

import java.util.*;

/**
 * 给定开始字符串和目标字符串，在字符串集合里找到一系列字符串，使 开始字符串、字符串、、、目标字符串形成一串长字符串
 * 形成规则使相邻字符串中只有一个位置的字符不一样。
 *
 * 输出字符串序列和长度
 *
 * 其实就是很简单的搜索过程，不要想太复杂了
 */
public class ShortestChain {
    // 时间复杂度为（n*m*k）n 输出字符串链长度，m为字符串集合长度， k为字符串长度，用于比较是否相邻
    public static int shortesChain(String start, String target, Set<String> set) {
        List<String> chains = new LinkedList<>();

        String lastStr = start;

        while (!lastStr.equals(target)) {
            Iterator<String> ite = set.iterator();
            while (ite.hasNext()) {
                String tmp = ite.next();
                if (check(tmp, lastStr)) {
                    chains.add(tmp);
                    lastStr = tmp;
                    // 将已经找过的字符串从字符串集合中删除
                    ite.remove();
                }
            }
        }
        for (String s : chains) {
            System.out.print(s + " ");
        }
        System.out.println();

        return chains.size();
    }

    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count ++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Set<String> strSet = new HashSet<>();
        strSet.add("pooN");
        strSet.add("pbcc");
        strSet.add("zamc");
        strSet.add("poIc");
        strSet.add("pbca");
        strSet.add("pbIc");
        strSet.add("poIN");
        System.out.println(shortesChain("TooN", "pbca", strSet));
    }

}
