package algorithm.Aleetcode2_链表.leetcode2;

import algorithm.Aleetcode2_链表.ListNode;

/**
 *  两个整数 以逆序的形式存放在链表中，每个节点存放一个数字，计算这两个数的和，输出为链表形式
 *  比如： 数字 1345 + 36
 *             5->4->3->1
 *             6->3
 *  题目的数字是逆序的，减小了难度，但一些细节：空指针、边界条件 自己得多多注意呀！
 *
 *  如果数字是顺序的呢？可以出个扩展题
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res;
        ListNode cur = new ListNode(0);
        res = cur;
        int carry = 0, x, y, sum;
        while (l1 != null || l2 != null || carry > 0) {   // 注意carry还有的时候，还要继续，不然漏解了
            x = l1 != null ? l1.val : 0;  // 注意在存在的时候才有值
            y = l2 != null ? l2.val : 0;

            sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10); // cur的下一个节点
            cur = cur.next;         //cur移动

            l1 = l1 != null ? l1.next : null;   // 注意这里，！l1、l2必须存在才能才能继续找下一个，不然会报空指针异常
            l2 = l2 != null ? l2.next : null;
        }
        return res.next;
    }
}