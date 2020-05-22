package algorithm.Aleetcode2_链表.leetcode160;

import algorithm.Aleetcode2_链表.ListNode;

/**
 *  找到两个单链表相交的起始节点。
 *  若不相交，返回null
 *  虽然标榜 easy，但是如果要实现O(n)复杂度，还真的难想到。
 *
 *  关键就是两个链表从相交位置往后，一直会有相同相同的长度，如果两个链表的长度不一样，一长一短，那么需要消除长度差，短链表指向头
 *  长链表指向消除长度差后的位置，然后再一起走，就会走到相交处。
 *
 *  哈哈哈第二遍做的时候已经会了，主要思路想到了，虽然写法没有那么精炼，但也不错了。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }
        ListNode pA = headA, pB = headB;
        // 如果都走到空了，还没有相遇的点，则null==null，也就返回null了，精辟！
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}