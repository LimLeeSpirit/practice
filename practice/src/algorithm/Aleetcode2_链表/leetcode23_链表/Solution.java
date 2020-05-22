package algorithm.Aleetcode2_链表.leetcode23_链表;


import algorithm.Aleetcode2_链表.ListNode;

/**
 * 合并 k 个有序链表
 *
 * 之前合并了2个的 21 题，那么合并 k 个，我们只需要分而治之，都转化为合并 2 个的就行了
 *
 * 重点学习这个归并的思想和处理过程
 */

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { return null; }
        return merge(lists, 0, lists.length - 1);
    }

    // 学习这种分而治之的思路，把个数大于2的集合 两两划分处理，最后再做最后一步的处理！高端！
    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l >= r) { return lists[l]; }
        int mid = l + r >> 1;
        ListNode l1 = merge(lists, l, mid);
        ListNode l2 = merge(lists, mid + 1, r);

        return merger2Lists(l1, l2);
    }

    public static ListNode merger2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
