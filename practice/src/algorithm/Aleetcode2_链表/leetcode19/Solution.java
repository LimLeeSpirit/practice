package algorithm.Aleetcode2_链表.leetcode19;


import algorithm.Aleetcode2_链表.ListNode;

/**
 * 删除链表的倒数第 n 个节点
 *
 * 注意头节点不为空
 */
public class Solution {
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        /**
         * 高级解法，一遍for循环解题：关键是怎样一遍循环找到倒数第n个节点哈哈
         *
         * 我们可以先找到第 n 个节点，再设置一个preNode节点为实被删除节点的前一个节点
         *
         * 从第n个节点开始，curNode 和 preNode一起向后移动，直到preNode到达被删除节点的前一节点
         *
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curNode = dummy;
        ListNode preNode = dummy;

        int count = 0;
        while(count < n) {
            curNode = curNode.next;
            count ++;
        }


        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }

        preNode.next = preNode.next.next;
        return dummy.next;
    }
}
