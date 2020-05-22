package algorithm.Aleetcode2_链表.leetcode61;

import algorithm.Aleetcode2_链表.ListNode;

/**
 *  旋转链表，相当于对链表右移位 K 位
 *  找找规律就能写出O(n)时间复杂度的方法。哈哈
 *  不管移位多少次，其实只用管K % listLen = z 的次数。然后找到链表尾节点 和 新链表的尾部，连接起来即可。
 *
 *  可以写个博客！！
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        // cur 为 最后一个节点
        ListNode cur = head;
        int cnt = 0;
        while (cur.next != null) {
            cnt ++;
            cur = cur.next;
        }
        cnt ++;
        k %= cnt;

        int step = cnt - k - 1;
        ListNode pre = head;
        while (step > 0) {
            pre = pre.next;
            step --;
        }

        // 连接
        if (pre.next == null) return head;
        ListNode new_h = pre.next;
        pre.next = null;
        cur.next = head;

        return new_h;
    }
}
