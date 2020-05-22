package algorithm.Aleetcode10_数组.JZoffer82;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 0, 1, …, n-1这n个数字(n>0)排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 *
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 输入：n=5 , m=3
 *
 * 输出：3
 *
 * 0-1-2-3-4-0，依次删除2，0，1， 4，最后剩下 3
 */
public class Solution {
    // 这递推操作也太神奇了
    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }

    // 更通用的思路：用数组或者链表来模拟
    public int lastRemaining2(int n, int m) {
        if (n == 1) return 0;
        List<Integer> circle = new LinkedList<>();
        for (int i = 0; i < n; i ++) circle.add(i);

        // 每隔 m 个需要删除的元素下标
        int idx = 0;
        while (circle.size() > 1) {
            // 走 m - 1 步就到了需要删除的元素下标
            for (int i = 1; i < m; i ++) {
                // 这个更新下标确实厉害，为什么我想不到
                idx = (idx + 1) % circle.size();
            }
            circle.remove(idx);
        }
        return circle.get(0);
    }
}
