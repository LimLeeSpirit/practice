package algorithm.Aleetcode4_字符串;

/**
 * 和 leetcode 1047 有点类似，不过这个是删除重复的，那个是删除连续的前后两位
 *
 * 直接用 hash 或者 字符ASCII码当作索引，进行统计，将个数超过 1 的删除，不就结束了嘛
 *
 * 不对，这个题目不清晰，直接hash计数就行了
 */
public class DeleteDuplicateChar {
    public static String deleteDuplicate(String s) {
        char[] chars = s.toCharArray();

        int[] flags = new int[256];

        for (int i = 0; i < chars.length; i ++) {
            if (flags[chars[i]-'0'] > 0) {
                chars[i] = '0';
            } else {
                flags[chars[i]-'0'] ++;
            }
        }

        // 这个写法还可以，将 字符数组更新，并截取，生成最终的
        int k = 0;
        for (int j = 0; j < chars.length; j ++) {
            if (chars[j] != '0') {
                chars[k ++] = chars[j];
            }
        }

        return new String(chars, 0, k);
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicate("abcaabcd"));
    }
}
