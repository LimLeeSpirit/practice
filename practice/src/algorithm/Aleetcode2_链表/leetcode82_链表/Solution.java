package algorithm.Aleetcode2_链表.leetcode82_链表;

import algorithm.Aleetcode2_链表.ListNode;

/**
 *  给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 *  一遍 AC，太爽了。
 *  这题的思路就是：需要删除重复元素，如果连续两个节点值相同，那么就要删除这个值的所有节点了，找到后面不是这个值的节点，然后连接
 *
 *  总结出经验了，链表的题一般可以先定义一个头节点，指向head，然后定义 1 到 2 个指针，进行判断和移动
 *              期间针对题目场景考虑特殊情况。就很容易AC啦
 *
 *  第三次做的时候居然卡壳了？？，没搞清楚要操作哪些节点，再做一遍就清晰啦
 *
 *  由于头节点可能会变，所以需要虚拟头
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        ListNode mid, fol;

        while (pre.next != null && pre.next.next != null) {
            mid = pre.next;
            fol = mid.next;
            if (mid.val != fol.val)  pre = mid;
            else {
                ListNode tmp = fol;
                while (tmp != null && tmp.val == mid.val) {
                    tmp = tmp.next;
                }
                pre.next = tmp;
            }
        }
        return dummy.next;
    }
}
