package algorithm.Aleetcode2_链表.JZoffer48;

import algorithm.Aleetcode2_链表.ListNode;

/**
 * 请实现一个函数可以复制一个复杂链表。
 *
 * 在复杂链表中，每个结点除了有一个指针指向下一个结点外，
 * 还有一个额外的指针指向链表中的任意结点或者null。
 *
 * 难就难在每个节点还可能有随机指针，如果只是单纯的单链表，直接开辟另外的空间顺序赋值就可以了。但有random指针，
 * 所以需要在原链表上操作，赋值完后重新抽取新链表，并维护好旧链表顺序。
 *
 * Y总这个思路真的牛逼：
 * 1、在原链表基础上，针对每个节点，复制一个节点到他后面
 *      原链表1-2-3-4，这样做完后1-1-2-2-3-3-4-4
 * 2、复制 random 指针
 * 3、抽取复制链表，维护旧链表
 */
public class Solution {
    public ListNode copyRandomList(ListNode head) {
        for (ListNode p = head; p != null;) {
            ListNode np = new ListNode(p.val);
            ListNode next = p.next;
            p.next = np;
            np.next = next;
            p = next;
        }

        for (ListNode p = head; p != null; p = p.next.next) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for (ListNode p = head; p != null ;) {
            cur.next = p.next;
            cur = cur.next;
            p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
    }
}
