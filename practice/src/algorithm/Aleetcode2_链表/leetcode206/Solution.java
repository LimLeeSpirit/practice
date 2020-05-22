package algorithm.Aleetcode2_链表.leetcode206;

import algorithm.Aleetcode2_链表.ListNode;

/**
 *  反转链表
 *  这类题关键是注意保存哪些节点，想清楚指向逻辑、变量节点的变化逻辑。能少用节点是最好，那样变化逻辑也更少
 *
 */
public class Solution {
    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode second = head.next;

            head.next = second.next;
            second.next = dummy.next;
            dummy.next = second;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode tmp = new ListNode(1);
        ListNode head = tmp;
        for (int i=2; i<6; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        reverseList(head);
    }
}

