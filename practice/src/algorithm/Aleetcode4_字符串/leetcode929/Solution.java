package algorithm.Aleetcode4_字符串.leetcode929;

import java.util.HashSet;
import java.util.Set;

/**
 * 求有多少种不同的邮箱地址
 *
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 *
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 *
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 *
 * 规则1：如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），
 *         则发往那里的邮件将会转发到本地名称中没有点的同一地址。
 *         例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
 *         （请注意，此规则不适用于域名。）
 *
 * 规则2：如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。
 *       这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。
 *       （同样，此规则不适用于域名。）
 *
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 */
public class Solution {
    // 简直完美，需要处理的不就是本地名称嘛，分别对本地名称和域名进行处理。
    // 采用哈希集保存处理过的邮箱
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String str : emails) {
            StringBuilder name = new StringBuilder();
            int k = str.indexOf("@");
            for (int i = 0; i < k; i++) {
                if (str.charAt(i) == '+') {
                    break;
                }
                if (str.charAt(i) != '.') {
                    name.append(str.charAt(i));
                }
            }
            String tmp = name.toString() + str.substring(k);
            set.add(tmp);
        }
        return set.size();
    }


    public static void main(String[] args) {
        String s1 = "lzlz.de@bupt.edu.cn";
        String s2 = "1.1";
        System.out.println(s1.indexOf("@"));
    }
}
