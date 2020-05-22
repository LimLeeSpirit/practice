package algorithm.Aleetcode2_链表.leetcode83;
import algorithm.Aleetcode2_链表.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 由于第一个节点一定会保留，所以不需要再声明虚拟 dummy 节点
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }

        return head;
    }
}
