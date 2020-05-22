package algorithm.Aleetcode2_链表.leetcode25_链表;

import algorithm.Aleetcode2_链表.ListNode;

/**
 * Reverse Nodes in k-Group
 *
 * 答案这个写法是真牛逼，难顶
 *
 * 结合了反转链表(206)、2reverse(24)、Kreverse(25) 之后，发现都是要先在最前面设置一个 pre，然后从cur = head 开始，总结起来
 * 确实很好！代码确实很简洁！
 *
 */

public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;

        ListNode cur = head;

        while (cur!= null) {
            // 在 k 个 节点都存在的情况下才进行翻转
            ListNode t = cur;
            int count = 1;
            while (count < k && t != null) {
                t = t.next;
                count += 1;
            }

            // 在 k 个 节点都存在的情况下才进行翻转
            if (count == k && t != null) {
                // 翻转k个链表，总共翻转k-1次。重点是找到cur的运动规律！ 太精辟了
                for(int i=0; i<k-1; i++) {
                    ListNode fol = cur.next;
                    cur.next = fol.next;
                    fol.next = pre.next;
                    pre.next = fol;
                }
                pre = cur;
                cur = pre.next;

            // 否则， 退出
            } else { break; }
        }
        return dummy.next;
    }
}
