package algorithm.Aleetcode6_双指针和滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除有序字符串中所以的重复字符
 * 输入：2334456
 * 输出：256 k = 3；
 *
 * 这种情况双指针就不好使了，需要结合 hash 和 桶排序的思路，将重复的部分跳过。
 *
 * 直接使用hash就行了，不用桶
 */
public class removeDuplicate0 {
    public static int remove(char[] chars) {
        int n = chars.length;
        int[] cnt = new int[256];
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            hash.put(chars[i], hash.getOrDefault(chars[i], 0) + 1);
            if (hash.get(chars[i]) > 1) cnt[chars[i] - '0'] = 0;
            else cnt[chars[i] - '0'] = 1;
        }

        int k = 0;
        for (int i = 0; i < n; i ++) {
            if (cnt[chars[i] - '0'] != 0) chars[k ++] = chars[i];
        }
        for (char c : chars) System.out.print(c + " ");
        System.out.println();
        return k;
    }

    public static void main(String[] args) {
        String s = "223344561";
        System.out.println(remove(s.toCharArray()));
    }
}
