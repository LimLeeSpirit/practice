package algorithm.Aleetcode6_双指针和滑动窗口.leetcode76;

/**
 * 最短覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 明显的滑动窗口的题，就是要找到一个最短的窗口，使得窗口里的字符串包括 t 中的字符
 *
 * 双指针 + 哈希快速判断一个区间中的元素是否包含了字符串 t 的所有字符
 *
 */
class Solution {
    // i 往后走，j 也往后走，i 是右坐标，j 是左坐标，i 可以看成自变量，j 可以看成因变量，j 随着i的增大也是可以
    // 不减的，所以有单调性，用滑动窗口。i 和 j 都是不减的，所以可以实现O（n）复杂度
    // 难点：如何判断当前[j, i]是否已经包含了t中所有字母
    // 解决：开一个hash表，i往后走，对应字母个数++，j往后走，对应字母个数--，用一个cnt来统计总共的个数
    // 所以i和j都只走一遍，时间复杂度O（n）
    public String minWindow(String s, String t) {
        String ret = "";
        if (s.length() < t.length()) return ret;

        // 利用数组来保存字符串 t 中每个元素出现的个数
        int[] hash = new int[128];
        for (int i = 0; i < t.length(); i ++) hash[t.charAt(i) - 'A'] ++;
        // cnt 代表 t 中字母的个数
        int cnt = 0;
        for (int a : hash) cnt += a;

        char[] chars = s.toCharArray();
        for (int i = 0, j = 0, c = 0; i < chars.length; i ++) {
            // 刚好找到一个字符 计数器 ++
            if (hash[chars[i] - 'A'] > 0) c ++;
            // 不管是不是 t 中的元素，都 --
            hash[chars[i] - 'A'] --;
            // 在找完了元素之后，如果 j 可以更新，j 所在字符不包括在 t 中，然后 ++，因为先减了，在不需要这个
            // 元素的时候再继续往后走，需要将减过的加回去，实在是太高了
            while (c == cnt && hash[chars[j] - 'A'] < 0)  hash[chars[j ++] - 'A'] ++;
            // 更新结果
            if (c == cnt) {
                if (ret == "" || ret.length() > i - j + 1) {
                    ret = s.substring(j, i + 1);
                }
            }
        }
        return ret;
    }
}
