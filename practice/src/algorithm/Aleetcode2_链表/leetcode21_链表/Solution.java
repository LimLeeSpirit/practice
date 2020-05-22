package algorithm.Aleetcode2_链表.leetcode21_链表;


import algorithm.Aleetcode2_链表.ListNode;

/**
 * Merge Two Sorted Lists
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */

public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 直接常规解法就出来了，节点依次往后延升，并且不断的进行节点大小的判断。
         */
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }

        head.next = l1 != null ? l1 : l2;

        return dummy.next;
    }
}
