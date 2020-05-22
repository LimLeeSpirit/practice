package algorithm.Aleetcode2_链表.leetcode143;

import algorithm.Aleetcode2_链表.ListNode;

/**
 * 对链表重排序，l0-l1-l2-l3-l4.....ln 转换成 l0-ln-l1-l(n-1)-l2-l(n-2).....
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * leetcode 143
 *
 * 观察想要得到的链表结构，发现规律。
 * 1、先找到中间节点
 * 2、对中间节点后面的节点进行反转，得到前后两个部分的链表
 * 3、先后对前后两个链表取一个元素进行合并。
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        // 找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 是中间节点
        ListNode h2 = reverse(slow.next);
        // 将前后两个部分断开
        slow.next = null;
        ListNode h1 = head;

        while (h1 != null && h2 != null) {
            ListNode h11 = h1.next;
            ListNode h22 = h2.next;
            h1.next = h2;
            h2.next = h11;
            h1 = h11;
            h2 = h22;
        }
    }


    // 反转后半部分节点，并返回头节点
    private ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(- 1);
        ListNode cur = head;
        dummy.next = head;
        while (cur != null && cur.next != null) {
            ListNode fol = cur.next;
            cur.next = fol.next;
            fol.next = dummy.next;
            dummy.next = fol;
        }
        return dummy.next;
    }
}
