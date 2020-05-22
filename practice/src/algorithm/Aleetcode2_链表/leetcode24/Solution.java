package algorithm.Aleetcode2_链表.leetcode24;

/**
 * 每2个翻转链表     25题  Reverse Nodes in k-Group
 *
 * 其实逻辑是已经掌握了的，分析得也很清楚，要交换两个节点，必定需要提前保存这两个节点，且前一节点也需要保存。
 *
 * 区别就是在 while 循环里面   取两个节点   还是    外面定义好节点，然后在循环中更新节点。
 *
 * 更好的是在循环里面取节点，这样不会报错！我也不明白为什么，一个更合理的解释是这种写法，代码更简洁，
 */

import algorithm.Aleetcode2_链表.ListNode;

public class Solution {
    public static ListNode swapPairs(ListNode head) {
        // 头节点会变，所以需要设置虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;

        while (pre.next != null && pre.next.next != null) {
            // 循环里面取节点保存，且能保证一定存在
            ListNode left = pre.next;
            ListNode right = left.next;

            // 第四次自己写出来了，其实确实搞清楚逻辑，就很简单。
            pre.next = right;
            left.next = right.next;
            right.next = left;

            pre = left;
        }
        return dummy.next;
    }
}
