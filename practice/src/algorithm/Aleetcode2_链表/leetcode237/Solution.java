package algorithm.Aleetcode2_链表.leetcode237;


import algorithm.Aleetcode2_链表.ListNode;

/**
 * 删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 比如 4->5->1->9, 只给定node = 5，如何删掉节点 5，由于没有前一个节点，所以无法完全意义上删除这个节点，只是不断把
 * 下一个节点的值赋给上一个节点
 */
public class Solution {
    // 大神的写法，实在是太牛逼了，直接将本节点的值替换，并删除下一节点，就不用考虑空判断了
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode(ListNode node) {
        ListNode cur = node;
        while (cur != null && cur.next != null) {
            cur.val = cur.next.val;
            if (cur.next.next == null) {
                cur.next = null;
                break;
            } else {
                cur = cur.next;
            }
        }
    }
}
