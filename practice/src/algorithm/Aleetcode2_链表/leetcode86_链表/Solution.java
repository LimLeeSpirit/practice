package algorithm.Aleetcode2_链表.leetcode86_链表;

import algorithm.Aleetcode2_链表.ListNode;

/**
 * 分割链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 定义两个头节点，遍历一遍链表，小的节点加在第一个头后面，其他的加在第二个头后面，想清楚这个原理，不要搞复杂了
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-1);
        ListNode c1 = h1;
        ListNode c2 = h2;
        while (head != null) {
            if (head.val < x) {
                c1.next = head;
                c1 = c1.next;
            } else {
                c2.next = head;
                c2 = c2.next;
            }
            head = head.next;
        }
        c1.next = h2.next;
        // 这个最后一个节点指向null必须写，因为这代表一个链表结束
        c2.next = null;
        return h1.next;
    }
}

